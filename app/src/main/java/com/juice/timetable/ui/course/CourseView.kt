package com.juice.timetable.ui.course

import android.content.Context
import android.graphics.*
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.juice.timetable.data.source.Course
import com.juice.timetable.data.source.SingleWeekCourse
import com.juice.timetable.utils.DisplayUtils.dip2px
import com.juice.timetable.utils.DisplayUtils.getColor
import com.juice.timetable.utils.DisplayUtils.getPressedSelector
import com.juice.timetable.utils.LogUtils.d

/**
 * <pre>
 * author : Aaron
 * time   : 2020/04/29
 * desc   :
 * version: 1.0
</pre> *
 */
class CourseView : FrameLayout {
    companion object {
        // 最大周 默认25周
        val MAX_WEEK = 25
    }

    private var mRowItemWidth = dip2px(50f)
    private var mColItemHeight = dip2px(55f)
    private val mTextLRPadding = dip2px(2f)
    private val mTextTBPadding = dip2px(4f)
    private val textTBMargin = dip2px(3f)
    private val textLRMargin = textTBMargin
    private val mTextColor = Color.WHITE
    private val mTextSize = 12
    private var mWidth = 0
    var mHeight = 0
    private val mRowCount = 7
    private val mColCount = 11
    private var mFirstDraw = false

    // 行item的宽度根据view的总宽度自动平均分配
    private val mRowItemWidthAuto = true

    // 显示分割线
    private val mShowVerticalLine = true
    private val mShowHorizontalLine = true
    var itemClickListener: OnItemClickListener? = null
    private var mLinePaint: Paint? = null
    private val mLinePath = Path()

    constructor(context: Context) : super(context) {}
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView()
    }

    /**
     * 初始化 分割线
     */
    private fun initView() {
        mLinePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mLinePaint!!.color = Color.LTGRAY
        mLinePaint!!.strokeWidth = 1f
        mLinePaint!!.style = Paint.Style.FILL_AND_STROKE
        mLinePaint!!.pathEffect = DashPathEffect(floatArrayOf(5f, 10f), 0F)
    }

    private fun drawLine(canvas: Canvas) {
        //横线
        if (mShowHorizontalLine) {
            for (i in 1 until mColCount) {
                mLinePath.reset()
                mLinePath.moveTo(0f, (i * mColItemHeight).toFloat())
                mLinePath.lineTo(mWidth.toFloat(), (i * mColItemHeight).toFloat())
                canvas.drawPath(mLinePath, mLinePaint!!)
            }
        }

        //竖线
        if (mShowVerticalLine) {
            for (i in 1 until mRowCount) {
                mLinePath.reset()
                mLinePath.moveTo((i * mRowItemWidth).toFloat(), 0f)
                mLinePath.lineTo((i * mRowItemWidth).toFloat(), mHeight.toFloat())
                canvas.drawPath(mLinePath, mLinePaint!!)
            }
        }
    }

    // 当前周
    var currentIndex = -1
        private set
    var courses: MutableList<Course> = mutableListOf()
    var oneWeekCourses: List<SingleWeekCourse>? = null
    var set = HashSet<Int>()
    fun addCourse(course: Course) {

        // 冲突课程集合
        val conflictList = findConflictCourse(course)
        var str = ""
        if (conflictList.size > 0) {
            // 把自己添加进去
            conflictList.add(course)
            for (course1 in conflictList) {
                str = str + "<--->" + course1.couName
            }
            d("查找冲突课程" + course.couName + " -- > " + str)
        }
        val itemView = createCourseItem(course, conflictList)
        // 节课节数
        val row = course.couEndNode!! - course.couStartNode!! + 1
        val params = LayoutParams(
            mRowItemWidth,
            mColItemHeight * row
        )
        params.leftMargin = (course.couWeek!! - 1) * mRowItemWidth
        params.topMargin = (course.couStartNode!! - 1) * mColItemHeight
        itemView.layoutParams = params
        addView(itemView)
    }

    // 只用于周课表 判断是否为当前显示周的课
    private fun isActiveStatus(course: Course?): Boolean {

        // 课为空 return回去 不显示
        if (course == null) {
            return false
        }
        // 单周课程，当前不为单周 返回
        if (course.couWeekType != null && course.couWeekType == 1 && currentIndex % 2 != 1) {
            return false
        }
        // 双周课程，当前不为双周 返回
        if (course.couWeekType != null && course.couWeekType == 2 && currentIndex % 2 != 0) {
            return false
        }
        // 起或止周不存在
        return if (course.couStartWeek == null || course.couEndWeek == null) {
            false
        } else course.couStartWeek!! <= currentIndex && currentIndex <= course.couEndWeek!!
    }

    /**
     * 单个课程模块
     *
     * @return
     */
    fun createCourseItem(course: Course, conflictList: List<Course>): View {
        // 背景
        val backgroundView = FrameLayout(context)

        //TextView
        d(course.toString())
        val row = course.couEndNode!! - course.couStartNode!! + 1
        val tv = getCourseTextView(mColItemHeight * row, mRowItemWidth)
        // 设置tv的边界
        val params = LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        params.setMargins(textLRMargin, textTBMargin, textLRMargin, textTBMargin)
        tv.layoutParams = params
        // 设置tv文本
        // 撞课 在前面 添加[课程冲突]
        var showText = ""
        if (conflictList.isNotEmpty()) {
            showText = "[课程冲突]"
        }
        showText = """
             $showText${course.couName}
             ${course.couRoom}
             """.trimIndent()
        tv.text = showText

        // 彩虹模式随机数
        val backgroundColor = getColor(course.couColor!! + CourseFragment.rainbowModeNum)
        tv.setBackgroundColor(backgroundColor)

        // 背景图层
        backgroundView.addView(tv)
        // 设置点击的背景色
        setItemViewBackground(tv, backgroundColor)
        // 点击事件
        initEvent(tv, course, conflictList)
        return backgroundView
    }

    private fun setItemViewBackground(tv: TextView, color: Int) {
        val drawable: StateListDrawable
        drawable = getShowBgDrawable(color, color and -0x7f000001)
        tv.background = drawable
    }

    private fun getShowBgDrawable(color: Int, color2: Int): StateListDrawable {
        return getPressedSelector(
            context,  // 0 不圆角矩形
            color, color2, 0f
        )
    }

    /**
     * 课程点击事件
     *
     * @param tv
     * @param course
     * @param conflictList
     */
    private fun initEvent(tv: TextView, course: Course, conflictList: List<Course>) {
        tv.setOnClickListener(object : OnClickListener {
            override fun onClick(v: View) {
                // 通知ViewPager
                if (itemClickListener != null) {
                    itemClickListener!!.onClick(course, conflictList)
                }
            }
        })
    }

    private fun getCourseTextView(h: Int, w: Int): TextView {
        val tv = TextView(context)
        val params = LayoutParams(w, h)
        tv.layoutParams = params
        tv.setTextColor(mTextColor)
        tv.setLineSpacing(-2f, 1f)
        tv.setPadding(mTextLRPadding, mTextTBPadding, mTextLRPadding, mTextTBPadding)
        tv.setTextColor(mTextColor)
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, mTextSize.toFloat())
        tv.isFocusable = true
        tv.isClickable = true
        //bold
        val tp = tv.paint
        tp.isFakeBoldText = true
        return tv
    }

    fun dip2px(dpValue: Float): Int {
        return (0.5f + dpValue * context.resources.displayMetrics.density).toInt()
    }

    override fun dispatchDraw(canvas: Canvas) {
        drawLine(canvas)
        super.dispatchDraw(canvas)
        if (!mFirstDraw) {
            // 通过这个添加 ，保证了课表宽度正常
            initCourseItemView()
            mFirstDraw = true
        }
    }

    /**
     * 把数组中的数据全部添加到界面
     */
    private fun initCourseItemView() {
        // 移除课表界面所有课程
        removeAllViews()
        d("initCourseItemView执行")
        // 通过Dao层获取课程数据 添加课程到课程界面
        if (courses == null) {
            courses = ArrayList()
        }
        // 需要被添加的课
        val addCouList: MutableList<Course> = ArrayList()
        // 数据库有存当前需要显示的周课表 那就都显示
        if (set.contains(currentIndex)) {
            for (oneCou in oneWeekCourses!!) {
                if (oneCou.inWeek == currentIndex) {
                    // 封装一个Course对象
                    val course = Course()
                    course.couName = oneCou.couName
                    course.couRoom = oneCou.couRoom
                    course.couStartNode = oneCou.startNode
                    course.couEndNode = oneCou.endNode
                    course.couColor = oneCou.color
                    course.couWeek = oneCou.dayOfWeek
                    course.onlyID = oneCou.onlyID
                    course.couID = oneCou.couID
                    course.couWeekType = oneCou.courseType
                    // 用于撞课的当前周判断
                    // 把起始周都赋值为当前周
                    course.couStartWeek = currentIndex
                    course.couEndWeek = currentIndex
                    addCouList.add(course)
                }
            }
        } else {
            // 如果不存在周课表就要筛选需要显示的完整课表
            for (cou in courses!!) {
                if (isActiveStatus(cou)) {
                    addCouList.add(cou)
                }
            }
        }
        // 添加课程
        courses = addCouList
        for (cou in courses) {
            // 如果为线上慕课则不添加课程格子
            if (cou.couWeekType == 3 && cou.couStartNode == null && cou.couEndNode == null) {
                continue
            }
            addCourse(cou)
        }
    }

    /**
     * 根据课程 id 和 起止节 查找冲突的课程
     *
     * @param cou
     * @return
     */
    private fun findConflictCourse(cou: Course): MutableList<Course> {
        // 上面已经处理好了 这里courses 就是单前周应该添加的所有课程（不管是周课表还是完整课表）
        val conflictCouList: MutableList<Course> = ArrayList()
        for (findCou in courses!!) {
            // 课不相同 周相同
            if (findCou.couID != cou.couID) {
                // 星期相同 起始结束节有碰到就为冲突
                if (findCou.couWeek == cou.couWeek
                    && (findCou.couStartNode == cou.couStartNode ||
                            findCou.couEndNode == cou.couEndNode)
                ) {
                    conflictCouList.add(findCou)
                }
            }
        }
        return conflictCouList
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        if (mRowItemWidthAuto) {
            mWidth = w
            mRowItemWidth = mWidth / mRowCount
            // 1.想法1获取父类的长度，课表格子可以适配，但是课程节数无法适配，getMeasureHeight始终获取到的是0
//            ViewGroup parent = (ViewGroup) getParent();
//            int height = parent.getMeasuredHeight();

            // 改用绝对数值，来匹配高度
            val dip2px = dip2px(this.context.applicationContext, 125f)
            val heightPixels = resources.displayMetrics.heightPixels
            mHeight = heightPixels - dip2px
            d("高度 == >$mHeight")
            mColItemHeight = mHeight / mColCount
        } else {
            mWidth = mRowItemWidth * mRowCount
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        d("调用onMeasure")
        val dip2px = dip2px(this.context.applicationContext, 125f)
        val heightPixels = resources.displayMetrics.heightPixels
        setMeasuredDimension(widthMeasureSpec, heightPixels - dip2px)
    }

    // 设置当前周
    fun setCurrentIndex(currentIndex: Int): CourseView {
        this.currentIndex = currentIndex
        postInvalidate()
        return this
    }

    // 设置当前周后重新刷新课表界面
    fun resetView() {
        initCourseItemView()
    }

    interface OnItemClickListener {
        fun onClick(cou: Course, conflictList: List<Course>)
    }
}