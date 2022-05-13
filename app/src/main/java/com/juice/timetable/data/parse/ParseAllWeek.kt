package com.juice.timetable.data.parse

import com.juice.timetable.data.source.Course
import com.juice.timetable.utils.LogUtils
import org.jsoup.Jsoup

object ParseAllWeek {
    // 学期数据
    var semester = ""

    /**
     * 解析完整的课表
     */
    fun parseCourse(parseData: String): List<Course> {
        val couList: MutableList<Course> = ArrayList()
        val courseList: MutableList<Course> = ArrayList()
        var onlyID = 0
        var couID = 0L
        val document = Jsoup.parse(parseData)
        // 将 table 左边的表格标签里的内容提取（课程名，老师，起始结束周）
        val left = document.getElementsByTag("td").eq(1)
        if (left.isEmpty()) {
            // 可能是到了假期，教务网完整课表显示：该同学暂无课程记录
            LogUtils.i("获取完整课表失败：该同学暂无课程记录")
            return courseList
        }
        val leftTable = left[0]
        val div = document.getElementsByTag("div").eq(0)[0]
        semester = div.getElementsByTag("strong").text()
        LogUtils.i("所在学期 --> $semester")
        var trSize = leftTable.getElementsByTag("tr").size
        // 循环 tr 标签内容
        for (a in 1 until trSize) {
            val tr = leftTable.getElementsByTag("tr").eq(a)
            for (ele in tr) {
                val td = ele.getElementsByTag("td")
                // 跳过非课程的 tr标签
                if (td.size < 3) {
                    break
                }
                try {
                    val course = Course()
                    val tdCouName = td.eq(0).text().trim { it <= ' ' }
                    // 判断课程名里是否有特殊情况
                    // 例如 线性代数 (6)班（替代重修:线性代数（一））
                    var firstBan = tdCouName.indexOf("班")
                    if ("班" != tdCouName.substring(tdCouName.length - 1) && firstBan != -1) {
                        val couNameSize = tdCouName.length
                        while (firstBan < couNameSize) {
                            if (")" == tdCouName.substring(firstBan - 1, firstBan)) {
                                val couName =
                                    tdCouName.substring(0, firstBan + 1).trim { it <= ' ' }
                                course.couName = couName
                                break
                            } else {
                                val partCouName = tdCouName.substring(firstBan + 1)
                                firstBan = partCouName.indexOf("班")
                            }
                        }
                    } else {
                        course.couName = tdCouName
                    }
                    // 慕课提取并存储
                    if (td.eq(2).text().isEmpty() && "院选课" == td.eq(3).text()) {
                        val couTeacher = td.eq(5).text().substring(3)
                        course.couTeacher = couTeacher
                        course.couWeekType = 3
                        course.couID = couID
                        couID++
                        course.onlyID = onlyID
                        onlyID++
                        courseList.add(course)
                    }

                    // 老师不为空，设置
                    if (td.eq(2).text().isNotEmpty()) {
                        val couTeacher = td.eq(2).text().trim { it <= ' ' }
                        course.couTeacher = couTeacher
                    }
                    // 解析 起讫时间周序(星期)
                    // 可能出现 <td align="center">01～01<br>03～03</td>
                    if ("" != td.eq(10).text()) {
                        // 01～01 03～03
                        val startEndNode = td.eq(10).text().trim { it <= ' ' }
                        // 一般情况: 01～17
                        if (startEndNode.split(" ").toTypedArray().size == 1) {
                            val split = startEndNode.split("～").toTypedArray()
                            course.couStartWeek = Integer.valueOf(split[0])
                            course.couEndWeek = Integer.valueOf(split[1])
                        } else {
                            // 特殊情况：01～01 03～03
                            // 有几个这样的小节
                            val nodes = startEndNode.split(" ").toTypedArray()
                            for (node in nodes) {
                                // new一个id相同的新课来存放
                                val repeatedCou = Course()
                                repeatedCou.couName = course.couName
                                repeatedCou.couTeacher = course.couTeacher
                                val split = node.split("～").toTypedArray()
                                repeatedCou.couStartWeek = Integer.valueOf(split[0])
                                repeatedCou.couEndWeek = Integer.valueOf(split[1])
                                repeatedCou.couID = couID
                                couList.add(repeatedCou)
                            }
                            // 已经添加到 List，跳过本轮外层的添加
                            couID++
                            continue
                        }
                    }
                    course.couID = couID
                    couID++
                    couList.add(course)
                } catch (e: Exception) {
                    LogUtils.e("完整课表 leftTable 解析错误 --> ${e.message}")
                }
            }
        }

        // 将table右边的表格标签里的内容提取（）
        val rightTable = document.getElementsByTag("tbody").eq(3)[0]
        trSize = rightTable.getElementsByTag("tr").size
        for (i in 1 until trSize) {
            val tr = rightTable.getElementsByTag("tr").eq(i)
            for (el1 in tr) {
                val tdSize = el1.getElementsByTag("td").size
                for (j in 1 until tdSize) {
                    // 去除为空的课程
                    if ("" != el1.getElementsByTag("td").eq(j).text()) {
                        val td = el1.getElementsByTag("td").eq(j).html()
                        // tr 标签中 td 的数量
                        val brLen = td.split("<br>").toTypedArray().size
                        for (a in 0 until brLen) {
                            try {
                                var course: Course? = null
                                val trArr = td.split("<br>").toTypedArray()
                                // 兼容 形势与政策（三） 这样不包含 “班” 的课程
                                // if (trArr[a].contains("班")) {
                                if (trArr[a].isNotEmpty()) {
                                    val couName = td.split("<br>").toTypedArray()[a]
                                    //在leftTable解析完的List中寻找对应course
                                    for (cou in couList) {
                                        val parseName = couName.replace(" ", "")
                                        val listCouName = cou.couName!!.replace(" ", "")
                                        // 通过课程名字与 OnlyID 来做判断   Only -> 单个课程独有的属性，即使课程名字相同，OnlyID 也不同
                                        if (parseName == listCouName && cou.onlyID == null) {
                                            course = Course(
                                                cou.couID,
                                                cou.couName,
                                                cou.couTeacher,
                                                cou.couStartWeek,
                                                cou.couEndWeek
                                            )
                                            course.onlyID = onlyID
                                            onlyID++
                                        }
                                    }
                                    // 如果没找到 跳出本轮循环
                                    if (course == null) {
                                        continue
                                    }
                                    // 初步通过ID属性判断 起始结束节，周几
                                    val id = el1.getElementsByTag("td").eq(j).attr("id")
                                        .trim { it <= ' ' }
                                    val couWeek = Integer.valueOf(id.substring(id.length - 1))
                                    course.couWeek = couWeek
                                    val couStartNode =
                                        Integer.valueOf(id.substring(0, id.length - 1))
                                    course.couStartNode = couStartNode
                                    val time = Integer.valueOf(
                                        el1.getElementsByTag("td").eq(j).attr("rowspan")
                                            .trim { it <= ' ' })
                                    val couEndNode = couStartNode + time - 1
                                    course.couEndNode = couEndNode
                                    //增加教室，通过完整课表右边的课表判断在课程的后面是否有指定周·指定节·单双周
                                    for (b in 1 until brLen - a) {
                                        if (trArr[a + b].contains("[单]")) {
                                            course.couWeekType = 1
                                            val couRoom = trArr[a + b].substring(
                                                4,
                                                trArr[a + b].length - 1
                                            ).trim { it <= ' ' }
                                            course.couRoom = couRoom
                                        } else if (trArr[a + b].contains("[双]")) {
                                            course.couWeekType = 2
                                            val couRoom = trArr[a + b].substring(
                                                4,
                                                trArr[a + b].length - 1
                                            ).trim { it <= ' ' }
                                            course.couRoom = couRoom
                                        } else if (trArr[a + b].contains("节")) {
                                            val startNode = Integer.valueOf(
                                                trArr[a + b].split("~")
                                                    .toTypedArray()[0].substring(1)
                                            )
                                            course.couStartNode = startNode
                                            val endNode = Integer.valueOf(
                                                trArr[a + b].split("~")
                                                    .toTypedArray()[1].substring(
                                                    0,
                                                    trArr[a + b].split("~")
                                                        .toTypedArray()[1].length - 2
                                                )
                                            )
                                            course.couEndNode = endNode
                                        } else if (trArr[a + b].contains("周")) {
                                            val startWeek = Integer.valueOf(
                                                trArr[a + b].split("-")
                                                    .toTypedArray()[0].substring(1)
                                            )
                                            course.couStartWeek = startWeek
                                            val endWeek = Integer.valueOf(
                                                trArr[a + b].split("-")
                                                    .toTypedArray()[1].substring(
                                                    0,
                                                    trArr[a + b].split("-")
                                                        .toTypedArray()[1].length - 2
                                                )
                                            )
                                            course.couEndWeek = endWeek
                                        } else if (trArr[a + b].contains("[") && trArr[a + b].contains(
                                                "]"
                                            ) && !trArr[a + b].contains("周")
                                        ) {
                                            course.couWeekType = 0
                                            val couRoom = trArr[a + b].substring(
                                                1,
                                                trArr[a + b].length - 1
                                            ).trim { it <= ' ' }
                                            course.couRoom = couRoom
                                        } else if (trArr[a + b].contains("班")) {
                                            break
                                        }
                                    }
                                    courseList.add(course)
                                }
                            } catch (e: Exception) {
                                LogUtils.e("完整课程rightTable解析错误--->" + e.message)
                            }
                        }
                    }
                }
            }
        }

        // 解析结束
        LogUtils.i("完整课表解析成功---> $courseList")
        return courseList
    }
}