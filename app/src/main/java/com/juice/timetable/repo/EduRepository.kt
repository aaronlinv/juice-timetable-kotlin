package com.juice.timetable.repo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.juice.timetable.api.EduService
import com.juice.timetable.utils.CaptchaUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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