package com.juice.timetable.data.parse

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.jsoup.Jsoup
import org.jsoup.nodes.Document


object ParseVersion {
    private var client: OkHttpClient? = null

    fun getSource(url: String): String {
        val request: Request = Request.Builder()
            .addHeader("Content-Type", "text/html")
            .addHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.93 Safari/537.36 Edg/90.0.818.56"
            )
            .get()
            .url(url)
            .build()
        val response: Response = getClient().newCall(request).execute()
        return response.body!!.string()
    }

    fun getVersion(Source: String?): String {
        val doc: Document = Jsoup.parse(Source)
        val rootSelect =
            doc.select("div.apk_left_one > div > div > div.apk_topbar_mss > p.detail_app_title > span")
        return rootSelect.text()
    }

    fun getVersionInfo(Source: String?): String {
        val doc: Document = Jsoup.parse(Source)
        val rootSelect =
            doc.select("div.apk_left_two > div > div:nth-child(2) > p.apk_left_title_info")
        return rootSelect.text()
    }


    // todo 优化
    private fun getClient(): OkHttpClient {
        if (client == null) {
            client = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .build()
        }
        return client as OkHttpClient
    }
}