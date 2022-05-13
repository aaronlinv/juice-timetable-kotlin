package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * <pre>
 * author : Aaron
 * time   : 2020/04/28
 * desc   :
 * version: 1.0
</pre> *
 */
@Entity
class Course {
    var couID: Long? = null

    @PrimaryKey
    var onlyID: Int? = null
    var couName: String? = null
    var couRoom: String? = null
    var couTeacher: String? = null

    // 这门课是在星期几上
    var couWeek: Int? = null

    // 这门课是从当天的第几节课开始
    var couStartNode: Int? = null

    // 这门课是从当天的第几节课结束
    var couEndNode: Int? = null

    // 单双周的判断 3为慕课
    var couWeekType: Int? = null

    // 这门课程开始于第几周
    var couStartWeek: Int? = null

    // 这门课结束于第几周
    var couEndWeek: Int? = null
    var couColor: Int? = null

    constructor() {}

    // 课程名，老师，起始结束周
    @Ignore
    constructor(
        couID: Long?,
        couName: String?,
        couTeacher: String?,
        couStartWeek: Int?,
        couEndWeek: Int?
    ) {
        this.couID = couID
        this.couName = couName
        this.couTeacher = couTeacher
        this.couStartWeek = couStartWeek
        this.couEndWeek = couEndWeek
    }

    override fun toString(): String {
        return "Course{" +
                "couID=" + couID +
                ", onlyID=" + onlyID +
                ", couName='" + couName + '\'' +
                ", couRoom='" + couRoom + '\'' +
                ", couTeacher='" + couTeacher + '\'' +
                ", couWeek=" + couWeek +
                ", couStartNode=" + couStartNode +
                ", couEndNode=" + couEndNode +
                ", couWeekType=" + couWeekType +
                ", couStartWeek=" + couStartWeek +
                ", couEndWeek=" + couEndWeek +
                ", couColor=" + couColor +
                '}'
    }
}