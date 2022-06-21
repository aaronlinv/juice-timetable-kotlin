package com.juice.timetable.data.source

import java.time.LocalDate

/**
 * <pre>
 * author : Aaron
 * time   : 2020/05/23
 * desc   :
 * version: 1.0
</pre> *
 */
data class CourseViewBean(
    var allWeekCourse: List<Course>,
    var weekSet: Set<Int>,
    var singleWeekCourse: List<SingleWeekCourse>,
    var moocCourse: List<Course>,
    // 从 1 开始
    var currentIndex: Int,
    var firstWeekMon: LocalDate
)