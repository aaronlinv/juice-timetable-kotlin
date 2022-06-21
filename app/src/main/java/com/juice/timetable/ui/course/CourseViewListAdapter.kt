package com.juice.timetable.ui.course

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.juice.timetable.R
import com.juice.timetable.data.source.Course
import com.juice.timetable.data.source.CourseViewBean
import com.juice.timetable.utils.DisplayUtils.dip2px
import com.juice.timetable.utils.LogUtils
import java.time.LocalDate

/**
 * <pre>
 * author : Aaron
 * time   : 2020/05/15
 * desc   :
 * version: 1.0
</pre> *
 */
open class CourseViewListAdapter :
    ListAdapter<CourseViewBean, CourseViewHolder>(object :
        DiffUtil.ItemCallback<CourseViewBean>() {
        override fun areItemsTheSame(oldItem: CourseViewBean, newItem: CourseViewBean): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: CourseViewBean, newItem: CourseViewBean): Boolean {
            return oldItem.currentIndex == newItem.currentIndex
        }
    }) {
    companion object {
        val WEEK_SINGLE = arrayOf("一", "二", "三", "四", "五", "六", "日")
    }

    private val NODE_WIDTH = 28
    private val WEEK_TEXT_SIZE = 12
    private val NODE_TEXT_SIZE = 11
    var itemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseViewHolder {
        return CourseViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.pager_course_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val courseView: CourseView = holder.itemView.findViewById(R.id.course_view)
        val item = getItem(position)

        courseView.setCurrentIndex(item.currentIndex)
        courseView.set = item.weekSet.toHashSet()
        courseView.courses = item.allWeekCourse.toMutableList()
        courseView.oneWeekCourses = item.singleWeekCourse

        // 多慕课测试
        // val testMoocCourse = Course();
        // testMoocCourse.couName = "测试万一有小可怜，选了2门慕课"
        // testMoocCourse.couTeacher = "超新尔雅"
        // item.moocCourse.add(testMoocCourse)

        // 慕课处理 存在慕课 并且开启了慕课显示 就显示慕课界面 否者 GONE 掉
        val llMooc = holder.itemView.findViewById<LinearLayout>(R.id.ll_mooc)
        val tvMooc = holder.itemView.findViewById<TextView>(R.id.tv_mooc)

        // 先清空 放置多次刷新堆积
        tvMooc.text = ""
        if (item.moocCourse.isNotEmpty() && CourseFragment.enableShowMooc) {
            val sb = StringBuilder()
            val mooc = item.moocCourse
            for (i in mooc.indices) {
                if (i > 0) {
                    sb.append("\n")
                }
                sb.append(mooc[i].couTeacher).append("：")
                sb.append(mooc[i].couName)
            }
            tvMooc.text = sb
            llMooc.visibility = View.VISIBLE
        } else {
            llMooc.visibility = View.GONE
        }

        // 不重置，在切换不同周会出现重叠情况
        courseView.resetView()

        // 获取第一周星期一的时间
        val firstWeekMon = item.firstWeekMon;
        LogUtils.d("第一周星期一：$firstWeekMon")

        // 计算时间
        val now = LocalDate.now();
        // 加上相隔的周
        val weekGap = (item.currentIndex - 1) * 7L

        // 星期栏
        val week = holder.itemView.findViewById<LinearLayout>(R.id.ll_week)
        week.removeAllViews()
        // -1 ：星期栏   0-6：星期 一 ...日
        for (i in -1..6) {
            val textView = TextView(holder.itemView.context)
            textView.gravity = Gravity.CENTER
            textView.setTextColor(Color.GRAY)
            textView.width = 0
            var params: LinearLayout.LayoutParams

            val targetDate = firstWeekMon.plusDays(weekGap + i)
            val month = targetDate.month.value;

            // 获取当前天的 日（不可直接累加 会出现5月32号的情况）
            val day = targetDate.dayOfMonth
            LogUtils.d("第" + item.currentIndex + "周 周一为 -- > " + month + "." + day)

            if (i == -1) {
                // 初始化月份
                params = LinearLayout.LayoutParams(
                    dip2px(holder.itemView.context.applicationContext, NODE_WIDTH.toFloat()),
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
                textView.textSize = NODE_TEXT_SIZE.toFloat()
                val monthStr = StringBuilder()
                monthStr.append(month).append("\n月")
                textView.text = monthStr
            } else {
                // 初始化课程星期栏
                params = LinearLayout.LayoutParams(10, ViewGroup.LayoutParams.MATCH_PARENT)
                params.weight = 10f
                textView.textSize = WEEK_TEXT_SIZE.toFloat()

                val weekStr = StringBuilder()
                weekStr.append(WEEK_SINGLE[i])
                weekStr.append("\n").append(day)
                textView.text = weekStr

                // 给今天 加深背景色 本周且为当日
                if (now == targetDate) {
                    textView.setBackgroundColor(-0x222223)
                }
            }
            //添加这个视图
            week.addView(textView, params)
        }

        // 课程节数列表
        val node = holder.itemView.findViewById<LinearLayout>(R.id.ll_node)
        val dip2px = dip2px(holder.itemView.context.applicationContext, 125f)

        // 节数栏使用绝对高度
        val heightPixels = holder.itemView.resources.displayMetrics.heightPixels
        val nodeHeight = (heightPixels - dip2px) / 11
        LogUtils.d("nodeHeight == >$nodeHeight")

        // 清除已有 View 否则会导致切换时一直叠加新的 View
        node.removeAllViews()

        //  课程节数栏
        for (i in 1..11) {
            val textView = TextView(holder.itemView.context.applicationContext)
            textView.textSize = NODE_TEXT_SIZE.toFloat()
            textView.gravity = Gravity.CENTER
            textView.setTextColor(Color.GRAY)
            textView.text = i.toString()
            val params = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, nodeHeight
            )
            node.addView(textView, params)
        }
        initEvent(courseView)
    }

    private fun initEvent(courseView: CourseView) {
        courseView.itemClickListener = object : CourseView.OnItemClickListener {
            override fun onClick(cou: Course, conflictList: List<Course>) {
                if (itemClickListener != null) {
                    itemClickListener!!.onClick(cou, conflictList)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    /**
     * 点击监听器
     */
    interface OnItemClickListener {
        fun onClick(cou: Course, conflictList: List<Course>)
    }
}

class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)