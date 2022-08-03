package com.juice.timetable.data.parse

import com.juice.timetable.data.source.Exam
import org.jsoup.Jsoup

object ParseExam {
    fun parseExam(parseStr: String?): List<Exam> {
        val examArrayList: MutableList<Exam> = ArrayList()
        //解析统考成绩网页源码
        val doc = Jsoup.parse(parseStr)
        val rootSelect =
            doc.select("body > table > tbody > tr:nth-child(4) > td > table > tbody > tr")
        var examId = 0

        for (ele in rootSelect) {
            val all = ele.select("td")
            val semesterAll = all[0] //开课学期
            val semester = semesterAll.text()
            if (semester == "开课 学期") continue

            val courseNameAll = all[1] //课程名称
            val courseName = courseNameAll.text()

            val examTypeAll = all[2] //考试类型
            val examType = examTypeAll.text()

            val examCategoryAll = all[3] //考试类别
            val examCategory = examCategoryAll.text()

            val examTimeAll = all[4] //考试时间
            val examTime = examTimeAll.text()
            val arrangementAll = all[5]

            val arrangement = arrangementAll.text() //考场安排
            val classGradeAll = all[6]

            val classGrade = classGradeAll.text() //班级


            val exam = Exam(
                examId++,
                semester,
                courseName,
                examType,
                examTime,
                examCategory,
                arrangement,
                classGrade
            )
            examArrayList.add(exam)
        }
        return examArrayList
    }
}