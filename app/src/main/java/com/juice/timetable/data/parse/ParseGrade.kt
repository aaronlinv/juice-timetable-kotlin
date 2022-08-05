package com.juice.timetable.data.parse

import com.juice.timetable.data.source.Credit
import com.juice.timetable.data.source.SynGrade
import com.juice.timetable.data.source.UniGrade
import org.jsoup.Jsoup

object ParseGrade {
    //爬取成绩，一个是统考成绩爬虫，一个是综合成绩的爬虫
    fun parseSynGrade(parseStr: String): List<SynGrade> {
        val synGradeArrayList: MutableList<SynGrade> = ArrayList<SynGrade>()
        //解析综合成绩网页源码
        val doc = Jsoup.parse(parseStr)
        //如果存在成绩评测，就直接返回空列表
        val rootSelect =
            doc.select("body > table > tbody > tr:nth-child(2) > td > table:nth-child(4) > tbody > tr")
        var synGradeId = 0

        for (ele in rootSelect) {
            //然后获得标签里面具体的内容
            val all = ele.select("td")

            val couYearAll = all[0] //学年
            val couYear = couYearAll.text()
            if (couYear == "选课 时间") continue

            val courseNameAll = all[1] // 课程
            val courseName = courseNameAll.text()

            val courseCreditAll = all[2] //课程学分
            val courseCredit = courseCreditAll.text()

            val cougradeAll = all[3] //成绩
            val couGrade = cougradeAll.text()
            var gradePoint = "无"
            var obtainCredit = "无"
            var examType: String
            var optionalCourseType: String

            if (couGrade == "暂无成绩") {        //有成绩
                val examTypeAll = all[4] //考试类型
                examType = examTypeAll.text()

                val optionalCourseTypeAll = all[5] //选修类型
                optionalCourseType = optionalCourseTypeAll.text()
            } else {
                val gradePointAll = all[4] //绩点
                gradePoint = gradePointAll.text()

                val obtainCreditAll = all[5] //获得学分
                obtainCredit = obtainCreditAll.text()

                val examTypeAll = all[6] //考试类型
                examType = examTypeAll.text()

                val optionalCourseTypeAll = all[7] //选修类型
                optionalCourseType = optionalCourseTypeAll.text()
            }

            val synGrade = SynGrade(
                synGradeId++, couYear, courseName, couGrade, courseCredit,
                gradePoint, obtainCredit, examType, optionalCourseType
            )
            synGradeArrayList.add(synGrade)
        }
        return synGradeArrayList
    }

    fun parseUniGrade(parseStr: String): MutableList<UniGrade> {
        val uniGradeArrayList: MutableList<UniGrade> = ArrayList<UniGrade>()
        //解析统考成绩网页源码
        val doc = Jsoup.parse(parseStr)
        //爬虫
        val rootSelect = doc.select("tbody > tr")
        var uniGradeId = 0

        for (ele in rootSelect) {
            val all = ele.select("td")

            val uYearAll = all[0] //学年
            val uYear = uYearAll.text()
            if (uYear == "学年") continue

            val uNameAll = all[1] //考试项目
            val uName = uNameAll.text()

            val uGradeAll = all[2] //成绩
            val uGrade = uGradeAll.text()

            val uRemarkAll = all[3] //备注
            val uRemark = uRemarkAll.text()

            val uniGrade = UniGrade(uniGradeId++, uYear, uName, uGrade, uRemark)
            uniGradeArrayList.add(uniGrade)
        }
        return uniGradeArrayList
    }

    fun parseCredits(parseStr: String): List<Credit> {
        val creditsArrayList: MutableList<Credit> = ArrayList<Credit>()
        val doc = Jsoup.parse(parseStr)
        //如果存在成绩评测，就直接返回空列表
        val rootSelect =
            doc.select("body > table > tbody > tr:nth-child(2) > td > table:nth-child(2) > tbody > tr")
        var creditID = 0

        for (ele in rootSelect) {
            val all = ele.select("td")
            val courseTypeALL = all[0]
            val courseType = courseTypeALL.text()
            val completedCreditsALL = all[1]
            val completedCredits = completedCreditsALL.text()
            val takeHomeCreditsALL = all[2]
            val takeHomeCredits = takeHomeCreditsALL.text()
            val credit = Credit(creditID++, courseType, completedCredits, takeHomeCredits)

            creditsArrayList.add(credit)
        }
        return creditsArrayList
    }
}