package com.juice.timetable.api

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface EduService {
    // 首页 以获取 cookie
    @GET("default.asp")
    suspend fun homePage(): Response<ResponseBody>

    // 获取验证码
    @Streaming
    @GET("ValidateCookie.asp")
    suspend fun getCaptcha(@Header("Cookie") cookies: String): Response<ResponseBody>

    // 登录
    @POST("loginchk.asp")
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun login(
        @Header("Cookie") cookies: String,
        @FieldMap data: HashMap<String, String>
    ): Response<ResponseBody>

    companion object {
        private const val BASE_URL = "https://jwc.fdzcxy.edu.cn/"

        fun create(): EduService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .build()
                .create(EduService::class.java)
        }
    }
}