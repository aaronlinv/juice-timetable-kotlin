package com.juice.timetable.api

import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.*

// 考试查询
const val URI_EXAM = "https://jwc.fdzcxy.edu.cn/ksgl/ksap/ksap_xs_list.asp"

interface ExamService {
    @POST
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    suspend fun examUrl(
        @Url url: String,
        @Header("Cookie") cookies: String?,
        @FieldMap data: HashMap<String, String>
    ): Response<ResponseBody>

    companion object {
        private const val BASE_URL = "https://jwc.fdzcxy.edu.cn/"

        fun create(): ExamService {
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .build()
                .create(ExamService::class.java)
        }
    }

}