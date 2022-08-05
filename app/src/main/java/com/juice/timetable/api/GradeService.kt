package com.juice.timetable.api

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Url

// 综合成绩
const val URI_SYNGRADE = "https://jwc.fdzcxy.edu.cn/cjgl/cx/zhcx_xs.asp"

// 统考成绩
const val URI_UNIGRADE = "https://jwc.fdzcxy.edu.cn/bmgl/tkcj/cjcx_xs.asp?menu_no=1004"

interface GradeService {
    // 动态获取指定 url 内容
    @GET()
    suspend fun gradeUrl(
        @Url url: String,
        @Header("Cookie") cookies: String,
    ): Response<ResponseBody>

    companion object {
        private const val BASE_URL = "https://jwc.fdzcxy.edu.cn/"

        fun create(): GradeService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .build()
                .create(GradeService::class.java)
        }
    }
}