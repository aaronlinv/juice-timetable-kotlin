package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "single_week_course")
class SingleWeekCourse {
    @PrimaryKey(autoGenerate = true)
    var onlyID: Int? = null

    //课程对应的ID（与完整的课表相同ID的课表）
    var couID: Long? = null
    var couName: String? = null
    var couRoom: String? = null
    var dayOfWeek: Int? = null
    var startNode: Int? = null
    var endNode: Int? = null
    var inWeek: Int? = null
    var courseType: Int? = null
    var color: Int? = null
    override fun toString(): String {
        return "SingleWeekCourse{" +
                "onlyID=" + onlyID +
                ", couID=" + couID +
                ", couName='" + couName + '\'' +
                ", couRoom='" + couRoom + '\'' +
                ", dayOfWeek=" + dayOfWeek +
                ", startNode=" + startNode +
                ", endNode=" + endNode +
                ", InWeek=" + inWeek +
                ", CourseType=" + courseType +
                ", Color=" + color +
                '}'
    }
}