package com.juice.timetable.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import com.juice.timetable.R
import es.dmoral.toasty.Toasty

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/05/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
object ToastyUtils {
    fun i(context: Context, info: String) {
        Toasty.info(context, info, Toasty.LENGTH_SHORT).show()
    }

    fun s(context: Context, info: String) {
        Toasty.success(context, info, Toasty.LENGTH_SHORT).show()
    }

    fun longSuccess(context: Context, drawable: Int, info: String) {
        success(context, drawable, info, Toasty.LENGTH_LONG)
    }

    fun shortSuccess(context: Context, drawable: Int, info: String) {
        success(context, drawable, info, Toasty.LENGTH_SHORT)
    }

    private fun success(context: Context, drawable: Int, info: String, length: Int) {
        Toasty.custom(
            context,
            info,
            context.getDrawable(drawable),
            context.getColor(R.color.toasty_green),
            Color.WHITE,
            length,
            true,
            true
        ).show()
        Toasty.Config.reset()
    }

    fun warn(context: Context, info: String) {
        Toasty.custom(
            context,
            info,
            context.getDrawable(R.drawable.ic_error),
            Color.RED,
            Color.WHITE,
            Toasty.LENGTH_LONG,
            true,
            true
        ).show()
        Toasty.Config.reset()
    }

    fun warn(context: Context, drawable: Drawable, info: String) {
        Toasty.custom(
            context,
            info,
            drawable,
            Color.RED,
            Color.WHITE,
            Toasty.LENGTH_LONG,
            true,
            true
        ).show()
        Toasty.Config.reset()
    }
}