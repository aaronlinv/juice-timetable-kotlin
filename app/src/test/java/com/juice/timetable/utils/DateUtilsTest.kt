package com.juice.timetable.utils

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDate

/**
 * <pre>
 * author : Aaron
 * time   : 2022/06/07
 * desc   :
 * version: 1.0
</pre> *
 */
class DateUtilsTest {
    @Test
    fun getFirstWeekMon() {
        // Convert String to LocalDate
        // https://howtodoinjava.com/java/date-time/localdate-parse-string/
        // 期望的第一周星期一
        val expectedDate = LocalDate.parse("2020-02-17")

        // 第一周周一
        var date: LocalDate = LocalDate.parse("2020-02-17")
        var firstWeekMon = DateUtils.getFirstWeekMon(1, date)

        assertEquals(expectedDate, firstWeekMon)

        // 第一周五
        date = LocalDate.parse("2020-02-21")
        firstWeekMon = DateUtils.getFirstWeekMon(1, date)
        assertEquals(expectedDate, firstWeekMon)

        // 周一
        date = LocalDate.parse("2020-05-25")
        firstWeekMon = DateUtils.getFirstWeekMon(15, date)
        assertEquals(expectedDate, firstWeekMon)

        // 周五
        date = LocalDate.parse("2020-05-29")
        firstWeekMon = DateUtils.getFirstWeekMon(15, date)
        assertEquals(expectedDate, firstWeekMon)

        // 周日
        date = LocalDate.parse("2020-05-24")
        firstWeekMon = DateUtils.getFirstWeekMon(14, date)
        assertEquals(expectedDate, firstWeekMon)
    }
}