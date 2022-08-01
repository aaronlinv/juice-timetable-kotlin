package com.juice.timetable.ui.about

import android.content.Context

import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.LinearLayout
import com.juice.timetable.R
import com.juice.timetable.utils.RippleLayoutUtils
import kotlin.random.Random


class RippleLayout : LinearLayout {
    private var mPaint: Paint? = null
    private var mRandom: Random? = null
    private var mCircles: MutableList<Circle>? = null
    private var mWidth = 0
    private var mHeight = 0

    /**
     * 圆圈的个数
     */
    private var mCircleMax = 30

    constructor(context: Context?) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
        val array = context.obtainStyledAttributes(attrs, R.styleable.RippleLayout)
        mCircleMax = array.getInteger(R.styleable.RippleLayout_count, mCircleMax)
        array.recycle()
    }

    private fun init() {
        mRandom = Random
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint!!.style = Paint.Style.FILL_AND_STROKE
        mPaint!!.strokeWidth = 3f
        mPaint!!.color = RippleLayoutUtils.getDarkRandomColor()
        setBackgroundColor(0x20ffffff)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mWidth = w
        mHeight = h
        initCircle()
    }

    private fun initCircle() {
        if (mCircles == null) {
            mCircles = ArrayList()
        } else {
            mCircles!!.clear()
        }
        for (i in 0 until mCircleMax) {
            mCircles!!.add(resetCircle(Circle(), true))
        }
    }

    override fun draw(canvas: Canvas) {
        for (circle in mCircles!!) {
            mPaint!!.color =
                circle.color or ((0xFF * (1 - circle.currRadius * 1f / circle.maxRadius)).toInt() shl 24)
            canvas.drawCircle(
                circle.x.toFloat(), circle.y.toFloat(), circle.currRadius.toFloat(),
                mPaint!!
            )
            circle.currRadius += 1
            if (circle.currRadius > circle.maxRadius) {
                resetCircle(circle, false)
            }
        }
        super.draw(canvas)
        postDelayed(action, 16)
    }

    private fun resetCircle(circle: Circle, init: Boolean): Circle {
        circle.currRadius = 0
        circle.x = mRandom!!.nextInt(mWidth)
        circle.y = mRandom!!.nextInt(mHeight)
        circle.maxRadius = mRandom!!.nextInt(120) + 50
        circle.setColor(RippleLayoutUtils.getDarkRandomColor())
        if (init) {
            circle.currRadius = mRandom!!.nextInt(circle.maxRadius)
        }
        return circle
    }

    var action = Runnable { invalidate() }

    internal class Circle {
        var x = 0
        var y = 0
        var maxRadius = 0
        var currRadius = 0
        var color = 0

        @JvmName("getColor1")
        fun getColor(): Int {
            return color
        }

        @JvmName("setColor1")
        fun setColor(color: Int) {
            this.color = color and 0xFFFFFF
        }
    }
}