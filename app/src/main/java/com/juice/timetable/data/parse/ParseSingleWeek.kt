package com.juice.timetable.data.parse

import com.juice.timetable.data.source.SingleWeekCourse
import com.juice.timetable.utils.LogUtils
import org.jsoup.Jsoup

object ParseSingleWeek {
    /**
     * 周课表解析
     */
    fun parseCourse(parseStr: String?): List<SingleWeekCourse> {
        val couList: MutableList<SingleWeekCourse> = ArrayList()
        val doc = Jsoup.parse(parseStr)

        // 课表内容
        val table = doc.getElementsByTag("table").eq(2)[0]

        // 遍历表格
        // 获取当前周
        val title = doc.getElementsByClass("td3").text().trim { it <= ' ' }
        var week: Int? = null
        week = try {
            Integer.valueOf(title.substring(title.indexOf("第") + 1, title.indexOf("周")))
        } catch (e: Exception) {
            LogUtils.e("周课表解析当前周失败 --> ${e.message}")
            return couList
        }
        LogUtils.i("开始解析当前周课表 --> $week")
        // table中 tr 标签的数量
        val trSize = table.getElementsByTag("tr").size
        // 跳过 课表中的显示周几的 第一行
        for (a in 1 until trSize) {
            val tr = table.getElementsByTag("tr").eq(a)
            for (el in tr) {
                // tr标签中td的数量
                val tdSize = el.getElementsByTag("td").size
                for (b in 1 until tdSize) {
                    try {
                        // 获取课表单格
                        val td = el.getElementsByTag("td").eq(b)
                        // 判断当前单元格不为空
                        if ("" != td.text()) {
                            val tdText = td.html().split("<br>").toTypedArray()
                            val brSize = tdText.size
                            // 累加 2 是因为 它的规则是：一行课程 一行教室
                            // 例如：大学物理（上）(15)班<br>[网络教学]<br>形势与政策（六）(6)班<br>[网络教学]</td>
                            var c = 0
                            while (c < brSize) {
                                // if (tdText[c].contains("班") || tdText[c].contains("调课")) {
                                // 原来的逻辑是根据 关键词判断，但是这也会缺少判断： 形势与政策（三） 和 考试：工程制图(10:00-12:00)
                                // 具体课程解析逻辑
                                if (tdText[c].isNotEmpty()) {
                                    //创建一个新的对象
                                    val cou = SingleWeekCourse()
                                    cou.inWeek = week
                                    val couName = tdText[c]
                                    // 停课判断逻辑
                                    // 马克思主义基本原理概论(11)班<br>[机北407](14:00)<br>停课：马克思主义基本原理概论<br>[机北407]</td>

                                    // 22.5.14 自带停课提示，所以移除下面逻辑
                                    // if (brSize >= c+1) {
                                    //     boolean isSuspend = tdText[c+1].contains("停课");
                                    //     if (isSuspend) {
                                    //         couName = "[停课] " + couName;
                                    //     }
                                    // }
                                    cou.couName = couName
                                    val couRoom = tdText[c + 1]
                                    // 去除 [网络教室] 左右的 []
                                    // String couRoom = s1.substring(1, s1.length() - 1);
                                    // 20.10.27 增加了时间 故去掉上面功能，直接显示 [网络教室](19:00)
                                    LogUtils.i("couRoom --> $couRoom")
                                    cou.couRoom = couRoom
                                    val id = td.attr("id")
                                    val dayOfWeek = Integer.valueOf(id.substring(id.length - 1))
                                    cou.dayOfWeek = dayOfWeek
                                    val startNode = Integer.valueOf(id.substring(0, id.length - 1))
                                    cou.startNode = startNode
                                    val time = Integer.valueOf(td.attr("rowspan"))
                                    val endNode = startNode + time - 1
                                    cou.endNode = endNode
                                    cou.courseType = 0
                                    // 新增一个属性CourseType判断 重课
                                    for (SingleWeekCourse in couList) {
                                        if (cou.dayOfWeek == SingleWeekCourse.dayOfWeek && cou.startNode == SingleWeekCourse.startNode && cou.endNode == SingleWeekCourse.endNode) {
                                            cou.courseType = 4
                                        }
                                    }
                                    couList.add(cou)
                                }
                                c += 2
                            }
                        }
                    } catch (e: Exception) {
                        LogUtils.e("解析当前周课表课程异常 --> ${e.message}")
                        // 解析当前一门课程失败，跳过此课程
                    }
                }
            }
        }
        // 解析结束
        LogUtils.i("结束解析当前周课表 --> $couList")
        return couList
    }
}