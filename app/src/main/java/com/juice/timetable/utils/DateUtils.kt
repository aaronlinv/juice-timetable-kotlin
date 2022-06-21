package com.juice.timetable.utils

import java.time.DayOfWeek
import java.time.LocalDate

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/06/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
object DateUtils {
    /**
     * 通过当前周和当前日期推断出 第一周星期一所对应的日期
     * curWeek: 从 1 开始，表示第一周
     */
    @JvmStatic
    fun getFirstWeekMon(curWeek: Int, date: LocalDate): LocalDate {
        // 日期倒退回第一周
        val firstWeek = date.plusDays((curWeek - 1) * -7L)

        // Get date of first day of week based on LocalDate.now() in Java 8
        // https://stackoverflow.com/a/28454044
        return firstWeek.with(DayOfWeek.MONDAY)
    }
}