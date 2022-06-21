package com.juice.timetable.utils

import android.R
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.StateListDrawable

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/06/04
 *     desc   :
 *     version: 1.0
 * </pre>
 */
object DisplayUtils {
    private val colorArr = intArrayOf(
        -0x146294,
        -0xb4669,
        -0x2f221d,
        -0x4b2231,
        -0x12492b,
        -0x162d1e,
        -0x31d3f,
        -0x1ca4bb,
        -0x27daa,
        -0x63d8e,
        -0x742a38,
        -0x53379c,
        -0x512a2c,
        -0x63177,
        -0x4d6a,
        -0x2b7a5,
        -0x8a3517,
        -0x582217,
        -0x82490,
        -0x108d86,
        -0x5c58,
        -0x586f,
        -0x8e795d,
        -0x833216,
        -0x34180b,
        -0x410b1a,
        -0x9a1122,
        -0x6e3813,
        -0x62e53,
        -0x231e1c,
        -0x63f47,
        -0x21654,
        -0x501625
    )

    /**
     * 返回一个随机颜色
     *
     * @param num
     * @return
     */
    @JvmStatic
    fun getColor(num: Int): Int {
        return colorArr[num % (colorArr.size - 1)]
    }

    @JvmStatic
            /**
             * 获取颜色数组的个数
             *
             * @return
             */
    fun getColorCount(): Int {
        return colorArr.size
    }

    @JvmStatic
    fun dip2px(context: Context, dpValue: Float): Int {
        return (0.5f + dpValue * context.resources.displayMetrics.density).toInt()
    }

    /**
     * 创建 Selector 配置：默认颜色和点击时的颜色
     *
     * @param context
     * @param color
     * @param pressedColor
     * @param radius
     * @return
     */
    @JvmStatic
    fun getPressedSelector(
        context: Context,
        color: Int,
        pressedColor: Int,
        radius: Float
    ): StateListDrawable {
        val normalD: GradientDrawable = getDrawable(context, color, radius, 0, 0)
        val pressedD: GradientDrawable = getDrawable(context, pressedColor, radius, 0, 0)
        val drawable = StateListDrawable()
        drawable.addState(intArrayOf(R.attr.state_pressed), pressedD)
        drawable.addState(intArrayOf(), normalD)
        return drawable
    }

    /**
     * 创建一个Drawable
     *
     * @param context
     * @param rgb
     * @param radius
     * @param stroke
     * @param strokeColor
     * @return
     */
    fun getDrawable(
        context: Context, rgb: Int,
        radius: Float, stroke: Int, strokeColor: Int
    ): GradientDrawable {
        val gradientDrawable = GradientDrawable()
        gradientDrawable.setColor(rgb)
        gradientDrawable.cornerRadius =
            dip2px(context, radius).toFloat()
        gradientDrawable.setStroke(
            dip2px(
                context,
                stroke.toFloat()
            ), strokeColor
        )
        return gradientDrawable
    }
}