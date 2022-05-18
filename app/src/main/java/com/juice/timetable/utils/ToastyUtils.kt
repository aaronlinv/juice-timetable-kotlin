package com.juice.timetable.utils

import android.content.Context
import android.graphics.Color
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

    fun c(context: Context, info: String) {
        Toasty.custom(
            context,
            info,
            context.getDrawable(R.drawable.ic_error),
            Color.RED,
            Color.WHITE,
            Toasty.LENGTH_SHORT,
            true,
            true
        ).show()
        Toasty.Config.reset()
    }
}