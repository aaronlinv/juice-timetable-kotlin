package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exam")
class Exam {

    @PrimaryKey
    var examId: Int? = null

    var semester: String? = null        //开课学期
    var courseName: String? = null      //课程名称
    var examType: String? = null        //考试类型
    var examTime: String? = null        //考试时间
    var examCategory: String? = null    //考试类别
    var arrangement: String? = null     //考场安排
    var classGrade: String? = null      //班级

    constructor(
        examId: Int?,
        semester: String?,
        courseName: String?,
        examType: String?,
        examTime: String?,
        examCategory: String?,
        arrangement: String?,
        classGrade: String?
    ) {
        this.examId = examId
        this.semester = semester
        this.courseName = courseName
        this.examType = examType
        this.examTime = examTime
        this.examCategory = examCategory
        this.arrangement = arrangement
        this.classGrade = classGrade
    }

    override fun toString(): String {
        return "Exam(examId=$examId, " +
                "semester=$semester, " +
                "courseName=$courseName, " +
                "examType=$examType, " +
                "examTime=$examTime, " +
                "examCategory=$examCategory, " +
                "arrangement=$arrangement, " +
                "classGrade=$classGrade)"
    }



}