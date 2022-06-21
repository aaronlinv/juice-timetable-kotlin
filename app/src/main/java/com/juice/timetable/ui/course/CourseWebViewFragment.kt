package com.juice.timetable.ui.course

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.juice.timetable.R
import com.juice.timetable.api.FULL_URI_CUR_WEEK
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import com.juice.timetable.viewmodel.StuInfoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class CourseWebViewFragment : Fragment() {
    private lateinit var originCourseWeb: WebView
    private val stuInfoViewModel: StuInfoViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_course_web_view, container, false)
        //隐藏 toolbar 的按钮和星期下拉菜单按钮
        val toolbar: Toolbar = requireActivity().findViewById(R.id.toolbar)
        toolbar.findViewById<View>(R.id.spinner).visibility = View.INVISIBLE
        getWeb(root, FULL_URI_CUR_WEEK)
        return root
    }

    private fun getWeb(root: View, url: String) {
        //从数据库获取 cookies
        CoroutineScope(Dispatchers.Main).launch {
            val stuInfo = stuInfoViewModel.getStuInfo()

            if (stuInfo != null) {
                setCookie(url, stuInfo.cookies)
            }

            originCourseWeb = root.findViewById(R.id.originCourseWeb)
            originCourseWeb.settings.setSupportZoom(true)
            originCourseWeb.settings.builtInZoomControls = true
            // 缩放至屏幕大小
            originCourseWeb.settings.loadWithOverviewMode = true

            // 隐藏原生的缩放控件
            originCourseWeb.settings.displayZoomControls = false
            //启用 JavaScript
            // originCourseWeb.getSettings().javaScriptEnabled = true

            //访问 url
            originCourseWeb.loadUrl(url)
            originCourseWeb.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return super.shouldOverrideUrlLoading(view, url)
                }
            }
            val textView: TextView = root.findViewById(R.id.text_Loading)
            originCourseWeb.webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(view: WebView, newProgress: Int) {
                    if (newProgress < 100) {
                        val progress = "$newProgress%"
                        textView.text = progress
                    } else if (newProgress == 100) {
                        val progress = "$newProgress%"
                        textView.text = progress
                    }
                }
            }
        }
    }


    //设置 webView 的 cookies
    private fun setCookie(url: String, cookie: String) {
        val cookieManager = CookieManager.getInstance()
        cookieManager.removeSessionCookies(null)
        cookieManager.flush()
        cookieManager.setAcceptCookie(true)
        val c = cookie.split(";").toTypedArray()
        for (i in c) {
            cookieManager.setCookie(url, i)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        originCourseWeb.loadDataWithBaseURL(null, "", "text/html", "utf-8", null)
        originCourseWeb.clearHistory()
        (originCourseWeb.parent as ViewGroup).removeView(originCourseWeb)
        originCourseWeb.destroy()
    }
}