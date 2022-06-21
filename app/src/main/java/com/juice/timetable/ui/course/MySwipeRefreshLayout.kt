package com.juice.timetable.ui.course

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.ViewConfiguration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import kotlin.math.abs

/**
 * <pre>
 * author : Aaron
 * time   : 2020/05/27
 * desc   : 重写 SwipeRefreshLayout 解决左右滑动容易触发下拉刷新的问题
 * version: 1.0
</pre> *
 */
class MySwipeRefreshLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : SwipeRefreshLayout(context, attrs) {
    // 触发移动事件的最短距离，如果小于这个距离就不触发移动控件
    private val mTouchSlop: Int = ViewConfiguration.get(context).scaledTouchSlop

    // 上一次触摸时的 X 坐标
    private var mPrevX = 0f
    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> mPrevX = ev.x
            MotionEvent.ACTION_MOVE -> {
                val eventX = ev.x
                val xDiff = abs(eventX - mPrevX)
                // 增加 60 的容差，让下拉刷新在竖直滑动时就可以触发
                if (xDiff > mTouchSlop + 60) {
                    return false
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }
}