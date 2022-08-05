package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "credit")
class Credit {
    @PrimaryKey
    var creditID: Int? = null

    var optionalCourseTypeCredits: String? = null       //学分选修类型
    var coursesCompletedCredits: String? = null         //已修课程学分总计
    var takeHomeCredits: String? = null                 //实得学分总计


    constructor(
        creditID: Int,
        optionalCourseTypeCredits: String?,
        coursesCompletedCredits: String?,
        takeHomeCredits: String?
    ) {
        this.creditID = creditID
        this.optionalCourseTypeCredits = optionalCourseTypeCredits
        this.coursesCompletedCredits = coursesCompletedCredits
        this.takeHomeCredits = takeHomeCredits
    }
}