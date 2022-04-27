package com.juice.timetable.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import java.io.IOException

/**
 * <pre>
 * author : Aaron
 * time   : 2020/04/29
 * desc   : 识别验证码
 * version: 1.0
</pre> *
 */
object CaptchaUtils {
    private val trainMap: MutableMap<Bitmap, String> = HashMap()

    /**
     * 识别验证码
     *
     * @param code
     * @param context
     * @return
     */
    fun getAllOcr(code: Bitmap, context: Context): String? {
        // 分割
        val listImg = split(code)
        // 加载识别样本
        val map = loadTrainData(context)
        var result: String? = ""
        for (bi in listImg) {
            // 识别单个字符
            result += getSingleCharOcr(bi, map)
        }
        return result
    }

    /**
     * 识别验证码单个字符
     *
     * @param img
     * @param map
     * @return
     */
    private fun getSingleCharOcr(img: Bitmap, map: Map<Bitmap, String>): String? {
        var result: String? = "#"
        val width = img.width
        val height = img.height
        var min = width * height
        for (bi in map.keys) {
            var count = 0
            val widthMin = bi.width
            val heightMin = bi.height
            var countPixel = 1
            Label1@ for (x in 2 until widthMin - 1) {
                for (y in 0 until heightMin) {
                    // 统计不相同的像素个数
                    countPixel++
                    if (isWhite(img.getPixel(x, y)) != isWhite(bi.getPixel(x, y))) {
                        count++
                        if (count >= min) break@Label1
                    }
                }
            }
            if (count < min) {
                min = count
                result = map[bi]
            }
        }
        return result
    }

    /**
     * 分割验证码
     *
     * @param afterCode
     * @return
     */
    private fun split(afterCode: Bitmap): List<Bitmap> {
        val subImgs: MutableList<Bitmap> = ArrayList()
        val width = afterCode.width / 4
        val height = afterCode.height
        subImgs.add(Bitmap.createBitmap(afterCode, 0, 0, width, height))
        subImgs.add(Bitmap.createBitmap(afterCode, 10, 0, width, height))
        subImgs.add(Bitmap.createBitmap(afterCode, 20, 0, width, height))
        subImgs.add(Bitmap.createBitmap(afterCode, 30, 0, width, height))
        return subImgs
    }

    /**
     * 加载识别样本
     *
     * @param context
     * @return
     */
    private fun loadTrainData(context: Context): Map<Bitmap, String> {
        if (trainMap.isEmpty()) {
            try {
                val picsPtah = context.assets.list("match")
                var bitmap: Bitmap?
                for (picPath in picsPtah!!) {
                    val inputStream = context.resources.assets.open("match/$picPath")
                    inputStream.use {
                        bitmap = BitmapFactory.decodeStream(inputStream)
                        if (bitmap != null) {
                            trainMap[bitmap!!] = picPath[0].toString()
                        }
                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return trainMap
    }

    private fun isWhite(pixel: Int): Int {
        return if (Color.red(pixel) + Color.green(pixel) + Color.blue(
                pixel
            ) >= 705
        ) {
            1
        } else 0
    }
}