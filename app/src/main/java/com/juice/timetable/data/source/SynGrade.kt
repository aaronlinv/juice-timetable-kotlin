package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "synGrade")
class SynGrade {
    @PrimaryKey
    var synGradeId: Int? = null

    var couYear: String? = null             //选课时间
    var couName: String? = null             //课程名
    var couGrade: String? = null            //课程成绩
    var courseCredit: String? = null        //课程学分
    var gradePoint: String? = null          //绩点
    var obtainCredit: String? = null        //获得学分
    var examType: String? = null            //考试类型
    var optionalCourseType: String? = null  //选修类型

    constructor(
        synGradeId: Int?,
        couYear: String?,
        couName: String?,
        couGrade: String?,
        courseCredit: String?,
        gradePoint: String?,
        obtainCredit: String?,
        examType: String?,
        optionalCourseType: String?
    ) {
        this.synGradeId = synGradeId
        this.couYear = couYear
        this.couName = couName
        this.couGrade = couGrade
        this.courseCredit = courseCredit
        this.gradePoint = gradePoint
        this.obtainCredit = obtainCredit
        this.examType = examType
        this.optionalCourseType = optionalCourseType
    }

    override fun toString(): String {
        return "SynGrade(synGradeId=$synGradeId, " +
                "couYear=$couYear, " +
                "couName=$couName, " +
                "couGrade=$couGrade, " +
                "courseCredit=$courseCredit, " +
                "gradePoint=$gradePoint, " +
                "obtainCredit=$obtainCredit, " +
                "examType=$examType, " +
                "optionalCourseType=$optionalCourseType)"
    }

}