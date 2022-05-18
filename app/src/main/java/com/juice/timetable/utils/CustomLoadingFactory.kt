package com.juice.timetable.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.dyhdyh.widget.loading.factory.LoadingFactory
import com.juice.timetable.R

class CustomLoadingFactory : LoadingFactory {
    private var mString = ""
    override fun onCreateView(parent: ViewGroup): View {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.loading_process_dialog, parent, false)
        val textView: TextView = view.findViewById(R.id.loading)
        textView.text = mString

        // 避免触摸穿透遮罩层，使得 Loading 时无法操作
        view.setOnTouchListener(View.OnTouchListener { _, _ ->
            return@OnTouchListener true
        })

        return view
    }

    fun setString(str: String) {
        mString = str
    }
}