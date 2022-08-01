package com.juice.timetable.utils


import android.content.Context
import java.util.*

object RippleLayoutUtils {
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
     * 解决一些布局问题
     *
     * @param context
     * @param dpValue
     * @return
     */
    fun dip2px(context: Context, dpValue: Float): Int {
        return (0.5f + dpValue * context.resources.displayMetrics.density).toInt()
    }

    /**
     * 生成UUID
     */
    fun createUUID(): String? {
        return UUID.randomUUID().toString().replace("-", "")
    }

    /**
     * 返回一个随机颜色
     *
     * @param num
     * @return
     */
    fun getColor(num: Int): Int {
        return colorArr[num % (colorArr.size - 1)]
    }

    /**
     * 获取颜色数组的个数
     *
     * @return
     */
    fun getColorCount(): Int {
        return colorArr.size
    }

    private val darkColorList = intArrayOf(
        -0xa54094,
        -0x86fa0,
        -0x9c3f43,
        -0x127c81,
        -0xa46b2,
        -0x356b7d,
        -0xce592d,
        -0x7438c3,
        -0x78593a,
        -0x208667,
        -0x2957a8,
        -0x66803d,
        -0x224685,
        -0x2c211b
    )

    private val random = Random()

    fun getDarkRandomColor(): Int {
        return darkColorList[random.nextInt(20) % darkColorList.size]
    }
}