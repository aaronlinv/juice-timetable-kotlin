package com.juice.timetable.repo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.juice.timetable.api.EduService
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.utils.CaptchaUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class EduRepository {
    private val TAG = "EduRepository"

    private val eduService: EduService = EduService.create()

    // 根据 url 获取其内容（Cookie失效，自动重试） 无需传入参数
    suspend fun url(url: String, context: Context): String {
        return url(url, emptyMap(), context)
    }

    // 根据 url 获取其内容（Cookie失效，自动重试）
    suspend fun url(url: String, queryMap: Map<String, String>, context: Context): String {
        return withContext(Dispatchers.IO) {
            val db = JuiceDatabase.getDatabase(context)
            val stuInfoRepository = StuInfoRepository(db)

            val stuInfo = stuInfoRepository.get() ?: throw Exception("数据库中无账号数据，请重新登录")
            // 获取 cookies
            val cookies: String = stuInfo.cookies

            // cookie 有效，直接访问 url 获取内容
            if (cookies.isNotEmpty()) {
                try {
                    return@withContext url(url, cookies, queryMap)
                } catch (e: Exception) {
                    Log.d(TAG, "本地Cookie不可用，开始模拟登录获取 cookie")
                }
            }

            // 重新获取登录 cookies
            val accessCookies = login(stuInfo.stuID.toString(), stuInfo.eduPassword, context)
            // 更新 Cookie
            stuInfo.cookies = accessCookies
            stuInfoRepository.update(stuInfo)
            return@withContext url(url, accessCookies, queryMap)
        }
    }

    suspend fun loginAndUpdateStuInfo(
        stuInfo: StuInfo,
        context: Context,
        stuInfoRepository: StuInfoRepository
    ): String {
        return withContext(Dispatchers.IO) {
            // 重新获取登录 cookies
            var accessCookies = ""
            try {
                accessCookies = login(stuInfo.stuID.toString(), stuInfo.eduPassword, context)
            } catch (e: Exception) {
                if (e is UnknownHostException) {
                    throw Exception("网络不太好，检查一下网络吧")
                }
                throw  e
            }
            // 更新 Cookie
            stuInfo.cookies = accessCookies
            stuInfoRepository.update(stuInfo)
            return@withContext accessCookies
        }
    }

    // 根据 url 获取内容
    private suspend fun url(
        url: String,
        cookies: String,
        queryMap: Map<String, String>
    ): String {
        return withContext(Dispatchers.IO) {
            val response = eduService.eduUrl(url, cookies, queryMap)
            if (response.body() == null) {
                throw Exception("登录响应体为 null")
            }
            val result = response.body()!!.string()
            if (result.isEmpty()) {
                throw Exception("登录响应体为空")
            } else if (result.contains("出错提示") || result.contains("New Document")) {
                throw Exception("登录失败，需要重新获取Cookie")
            }
            return@withContext result
        }
    }

    // 登录获取身份 Cookie
    suspend fun login(
        stuId: String,
        stuPassword: String,
        context: Context
    ): String {
        val captcha: Bitmap?

        var accessCookies = getCookies()
        Log.d(TAG, "获取主页 Cookies：$accessCookies")
        val accessCookiesArr = accessCookies.split(";")
        for (it in accessCookiesArr) {
            if (it.startsWith("ssid")) {
                accessCookies = "$it;"
                break
            } else {
                throw Exception("获取主页 Cookie：未获取到 ssid 项")
            }
        }
        Log.d(TAG, "筛选主页 Cookies：$accessCookies")

        captcha = getCaptcha(accessCookies)
        val captchaCode = withContext(Dispatchers.Default) {
            return@withContext captcha?.let { CaptchaUtils.getAllOcr(it, context) }
        }
        Log.d(TAG, "验证码识别结果：$captchaCode")

        val finalCookie =
            loginToGetAccessCookies(
                stuId,
                stuPassword,
                captchaCode!!,
                accessCookies
            )
        Log.d(TAG, "最终用于登录的 Cookies：$finalCookie")
        return finalCookie
    }

    // 获取主页 cookie
    private suspend fun getCookies(): String {
        return withContext(Dispatchers.IO) {
            var accessCookies = ""
            val response = eduService.homePage()
            if (response.isSuccessful) {
                val cookies = response.headers()
                val setCookies = cookies.values("Set-Cookie")
                setCookies.forEach {
                    accessCookies += "$it;"
                }
            } else {
                throw Exception("获取主页 Cookie 失败")
            }
            accessCookies
        }
    }

    // 获取验证码
    private suspend fun getCaptcha(cookies: String): Bitmap? {
        return withContext(Dispatchers.IO) {
            val response = eduService.getCaptcha(cookies)
            if (response.isSuccessful) {
                response.body()?.byteStream().use {
                    BitmapFactory.decodeStream(it)
                }
            } else {
                throw Exception("获取验证码失败")
            }
        }
    }

    // 登录获取 cookie
    private suspend fun loginToGetAccessCookies(
        stuId: String,
        stuPassword: String,
        code: String,
        accessCookies: String
    ): String {
        return withContext(Dispatchers.IO) {
            val data = hashMapOf(
                "muser" to stuId,
                "passwd" to stuPassword,
                "code" to code
            )
            val response = eduService.login(accessCookies, data)
            if (response.isSuccessful) {
                if (response.body() == null) {
                    throw Exception("登录响应体为 null")
                }
                val result = response.body()!!.string()
                if (result.isEmpty()) {
                    throw Exception("登录响应体为空")
                } else if (result.contains("您输入的用户名或是密码出错")) {
                    throw Exception("教务网用户名或密码有误")
                } else if (result.contains("您输入的验证码不正确")) {
                    throw Exception("验证码识别失败，请再尝试一次")
                } else if (result.contains("您已连续输错密码3次，请过5分钟再尝试")) {
                    throw Exception("已连续输错教务网密码 3 次，请 5 分钟再尝试")
                } else if (!result.contains("网络办公系统")) {
                    throw Exception("登录响应体状态码为 200，但是还存在错误")
                }
            } else {
                throw Exception("登录教务网失败")
            }
            // 返回 Cookie
            return@withContext "${accessCookies}muser=$stuId"
        }
    }
}