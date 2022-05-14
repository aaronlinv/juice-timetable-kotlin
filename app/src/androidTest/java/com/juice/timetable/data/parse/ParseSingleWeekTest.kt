package com.juice.timetable.data.parse

import org.junit.Assert
import org.junit.Test

class ParseSingleWeekTest {
    /**
     * 17计科
     */
    @Test
    fun parseCS() {
        val actual: String = ParseSingleWeek.parseCourse(csCourses).toString()
        val expected = csCoursesExpected
        println(actual)
        println(expected)

        Assert.assertEquals(expected, actual)
    }

    /**
     * 汉语言
     */
    @Test
    fun parseChinese() {
        val actual: String = ParseSingleWeek.parseCourse(chineseCourses).toString()
        val expected = chineseCoursesExpected

        Assert.assertEquals(expected, actual)

    }

    /**
     * 2019 实验班
     */
    @Test
    fun parseExperimental() {
        val actual: String = ParseSingleWeek.parseCourse(experimentalCourses).toString()
        val expected = experimentalCoursesExpected

        Assert.assertEquals(expected, actual)
    }

    /**
     * 马同学周课表测试
     */
    @Test
    fun parseMa() {
        val actual: String = ParseSingleWeek.parseCourse(maCourses).toString()
        val expected = maCoursesExpected

        Assert.assertEquals(expected, actual)
    }

    /**
     * 停课周课表测试
     */
    @Test
    fun parseSuspend() {
        val actual: String = ParseSingleWeek.parseCourse(suspendCourses).toString()
        val expected = suspendCoursesExpected

        Assert.assertEquals(expected, actual)
    }

    companion object {
        /**
         * 17计科周课表
         *
         * @return String
         */
        private val csCourses: String
            get() = """
<META NAME="ROBOTS" CONTENT="NOINDEX,NOFOLLOW">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META http-equiv="cache-control" content="no-cache">
<META HTTP-EQUIV="expires" CONTENT="0">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<html>
<head>
<title>福州大学至诚学院课程表</title>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<link rel="stylesheet" href="../inc/kbstyle.css">
</head>
<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
	 

  <table width="440" border="0" cellspacing="0" id="w" align="center">
  <tr height="45"><td align="center"><input name="pweek" type="button" value="上一周 " onClick="javascript:document.location='zkb_xs.asp?week1=10&kkxq=2019%E4%B8%8B';" class="button">   						
&nbsp;&nbsp;&nbsp;&nbsp;<input name="allkb" type="button" value="完整课表" onClick="javascript:document.location='kb_xs.asp';" class="button">&nbsp;&nbsp;&nbsp;&nbsp;   
	<input name="nweek" type="button" value="下一周 " onClick="javascript:document.location='zkb_xs.asp?week1=12&kkxq=2019%E4%B8%8B';" class="button">  
</td></tr>
<tr><td align="center" class="td3"><strong> 2019下学期第11周(2020-4-27-2020-5-3)，张三</strong> </td></tr>
</table>	


<table  cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
    <td valign="top">

	<table class="table1" width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" >
	    <tr  height="30"> 
	      <td align="center" class="td1">
	        4月<br>
	        节次 </td>
	      <td align="center" class="td1">27<br />周一</td>
	      <td align="center" class="td11">28<br />周二</td>
	      <td align="center" class="td1">29<br />周三</td>
	      <td align="center" class="td1">30<br />周四</td>
	      <td align="center" class="td1">1<br />周五</td>
		  
	    </tr>


​        
        <tr id="tr1"> 
          <td align="center" class="td1">1</td>
          
          <td align="center" rowspan=4 id="11"  class="td2">高级数据库技术(1)班<br>[网络教学]</td>
          
          <td id="12" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=4 id="13"  class="td2">高级数据库技术(1)班<br>[网络教学]</td>
          
          <td id="14" class="td2">&nbsp;</td>
          
          <td id="15" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center" class="td1">2</td>
          
          <td id="22" class="td2">&nbsp;</td>
          
          <td id="24" class="td2">&nbsp;</td>
          
          <td id="25" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center" class="td1">3</td>
          
          <td align="center" rowspan=2 id="32"  class="td2">高级数据库技术(1)班<br>[网络教学]</td>
          
          <td id="34" class="td2">&nbsp;</td>
          
          <td id="35" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center" class="td1">4</td>
          
          <td id="44" class="td2">&nbsp;</td>
          
          <td id="45" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center" class="td1">5</td>
          
          <td align="center" rowspan=2 id="51"  class="td2">软件工程(1)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="52"  class="td2">大数据应用开发实践(1)班<br>[网络教学]</td>
          
          <td id="53" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=4 id="54"  class="td2">大数据综合应用案例实训(1)班<br>[网络教学]</td>
          
          <td id="55" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center" class="td1">6</td>
          
          <td id="63" class="td2">&nbsp;</td>
          
          <td id="65" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center" class="td1">7</td>
          
          <td id="71" class="td2">&nbsp;</td>
          
          <td id="73" class="td2">&nbsp;</td>
          
          <td id="75" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center" class="td1">8</td>
          
          <td id="81" class="td2">&nbsp;</td>
          
          <td id="83" class="td2">&nbsp;</td>
          
          <td id="85" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center" class="td1">9</td>
          
          <td id="91" class="td2">&nbsp;</td>
          
          <td id="92" class="td2">&nbsp;</td>
          
          <td id="93" class="td2">&nbsp;</td>
          
          <td id="94" class="td2">&nbsp;</td>
          
          <td id="95" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center" class="td1">10</td>
          
          <td id="101" class="td2">&nbsp;</td>
          
          <td id="102" class="td2">&nbsp;</td>
          
          <td id="103" class="td2">&nbsp;</td>
          
          <td id="104" class="td2">&nbsp;</td>
          
          <td id="105" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center" class="td1">11</td>
          
          <td id="111" class="td2">&nbsp;</td>
          
          <td id="112" class="td2">&nbsp;</td>
          
          <td id="113" class="td2">&nbsp;</td>
          
          <td id="114" class="td2">&nbsp;</td>
          
          <td id="115" class="td2">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>

"""

        /**
         * 17计科周课表expected
         *
         * @return String
         */
        private val csCoursesExpected: String
            get() = "[SingleWeekCourse{onlyID=null, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=1, endNode=4, InWeek=11, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=3, startNode=1, endNode=4, InWeek=11, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=2, startNode=3, endNode=4, InWeek=11, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='软件工程(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=5, endNode=6, InWeek=11, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='大数据应用开发实践(1)班', couRoom='[网络教学]', dayOfWeek=2, startNode=5, endNode=8, InWeek=11, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='大数据综合应用案例实训(1)班', couRoom='[网络教学]', dayOfWeek=4, startNode=5, endNode=8, InWeek=11, CourseType=0, Color=null}]"

        /**
         * 汉语言周课表
         *
         * @return String
         */
        private val chineseCourses: String
            get() = """<META NAME="ROBOTS" CONTENT="NOINDEX,NOFOLLOW">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META http-equiv="cache-control" content="no-cache">
<META HTTP-EQUIV="expires" CONTENT="0">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<html>
<head>
<title>福州大学至诚学院课程表</title>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<link rel="stylesheet" href="../inc/kbstyle.css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
	 
  <table width="440" border="0" cellspacing="0" id="w" align="center">
  <tr height="45"><td align="center"><input name="pweek" type="button" value="上一周 " onClick="javascript:document.location='zkb_xs.asp?week1=11&kkxq=2019%E4%B8%8B';" class="button">   						
&nbsp;&nbsp;&nbsp;&nbsp;<input name="allkb" type="button" value="完整课表" onClick="javascript:document.location='kb_xs.asp';" class="button">&nbsp;&nbsp;&nbsp;&nbsp;   
	<input name="nweek" type="button" value="下一周 " onClick="javascript:document.location='zkb_xs.asp?week1=13&kkxq=2019%E4%B8%8B';" class="button">  
  
</td></tr>
<tr><td align="center" class="td3"><strong> 2019下学期第12周(2020-5-4-2020-5-10)，小易</strong> </td></tr>
</table>	


<table  cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
    <td valign="top">
	
	<table class="table1" width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" >
        <tr  height="30"> 
          <td align="center" class="td1">
            5月<br>
            节次 </td>
          <td align="center" class="td1">4<br />周一</td>
          <td align="center" class="td1">5<br />周二</td>
          <td align="center" class="td1">6<br />周三</td>
          <td align="center" class="td1">7<br />周四</td>
          <td align="center" class="td1">8<br />周五</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center" class="td1">1</td>
          
          <td id="11" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=2 id="12"  class="td2">毛泽东思想和中国特色社会主义理论体系概论(19)班<br>[网络教学]</td>
          
          <td id="13" class="td2">&nbsp;</td>
          
          <td id="14" class="td2">&nbsp;</td>
          
          <td id="15" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center" class="td1">2</td>
          
          <td id="21" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=3 id="23"  class="td2">古代汉语（下）(1)班<br>[网络教学]</td>
          
          <td id="24" class="td2">&nbsp;</td>
          
          <td id="25" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center" class="td1">3</td>
          
          <td align="center" rowspan=2 id="31"  class="td2">语言学概论(1)班<br>[网络教学]</td>
          
          <td id="32" class="td2">&nbsp;</td>
          
          <td id="34" class="td2">&nbsp;</td>
          
          <td id="35" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center" class="td1">4</td>
          
          <td id="42" class="td2">&nbsp;</td>
          
          <td id="44" class="td2">&nbsp;</td>
          
          <td id="45" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center" class="td1">5</td>
          
          <td align="center" rowspan=2 id="51"  class="td2">大学英语（四）(10)班<br>[网络教学]</td>
          
          <td align="center" rowspan=2 id="52"  class="td2">语言学概论(1)班<br>[网络教学]</td>
          
          <td id="53" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=2 id="54"  class="td2">毛泽东思想和中国特色社会主义理论体系概论(19)班<br>[网络教学]</td>
          
          <td id="55" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center" class="td1">6</td>
          
          <td id="63" class="td2">&nbsp;</td>
          
          <td id="65" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center" class="td1">7</td>
          
          <td id="71" class="td2">&nbsp;</td>
          
          <td id="72" class="td2">&nbsp;</td>
          
          <td id="73" class="td2">&nbsp;</td>
          
          <td id="74" class="td2">&nbsp;</td>
          
          <td id="75" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center" class="td1">8</td>
          
          <td id="81" class="td2">&nbsp;</td>
          
          <td id="82" class="td2">&nbsp;</td>
          
          <td id="83" class="td2">&nbsp;</td>
          
          <td id="84" class="td2">&nbsp;</td>
          
          <td id="85" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center" class="td1">9</td>
          
          <td align="center" rowspan=3 id="91"  class="td2">中国现当代文学（下）(1)班<br>[网络教学]</td>
          
          <td id="92" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=3 id="93"  class="td2">中国古代文学（四）(1)班<br>[机北407]</td>
          
          <td id="94" class="td2">&nbsp;</td>
          
          <td id="95" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center" class="td1">10</td>
          
          <td id="102" class="td2">&nbsp;</td>
          
          <td id="104" class="td2">&nbsp;</td>
          
          <td id="105" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center" class="td1">11</td>
          
          <td id="112" class="td2">&nbsp;</td>
          
          <td id="114" class="td2">&nbsp;</td>
          
          <td id="115" class="td2">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
		<hr style=" height:2px;border:none;border-top:2px dotted #185598;" />
		<font size='+1' color="#0000CC">&nbsp;&nbsp;注意：2020-5-9放假调课补2020-5-5,第12周周2的课</font>
		<hr style=" height:2px;border:none;border-top:2px dotted #185598;" />

</body>
</html>
"""

        /**
         * 汉语言周课表expected
         *
         * @return String
         */
        private val chineseCoursesExpected: String
            get() = "[SingleWeekCourse{onlyID=null, couID=null, couName='毛泽东思想和中国特色社会主义理论体系概论(19)班', couRoom='[网络教学]', dayOfWeek=2, startNode=1, endNode=2, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='古代汉语（下）(1)班', couRoom='[网络教学]', dayOfWeek=3, startNode=2, endNode=4, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='语言学概论(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=3, endNode=4, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='大学英语（四）(10)班', couRoom='[网络教学]', dayOfWeek=1, startNode=5, endNode=6, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='语言学概论(1)班', couRoom='[网络教学]', dayOfWeek=2, startNode=5, endNode=6, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='毛泽东思想和中国特色社会主义理论体系概论(19)班', couRoom='[网络教学]', dayOfWeek=4, startNode=5, endNode=6, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='中国现当代文学（下）(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=9, endNode=11, InWeek=12, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='中国古代文学（四）(1)班', couRoom='[机北407]', dayOfWeek=3, startNode=9, endNode=11, InWeek=12, CourseType=0, Color=null}]"

        /**
         * 2019下计科实验班
         *
         * @return String
         */
        private val experimentalCourses: String
            get() = """
<META NAME="ROBOTS" CONTENT="NOINDEX,NOFOLLOW">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META http-equiv="cache-control" content="no-cache">
<META HTTP-EQUIV="expires" CONTENT="0">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<html>
<head>
<title>福州大学至诚学院课程表</title>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<link rel="stylesheet" href="../inc/kbstyle.css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
	 
  <table width="440" border="0" cellspacing="0" id="w" align="center">
  <tr height="45"><td align="center"><input name="pweek" type="button" value="上一周 " onClick="javascript:document.location='zkb_xs.asp?week1=14&kkxq=2019%E4%B8%8B';" class="button">   						
&nbsp;&nbsp;&nbsp;&nbsp;<input name="allkb" type="button" value="完整课表" onClick="javascript:document.location='kb_xs.asp';" class="button">&nbsp;&nbsp;&nbsp;&nbsp;   
	<input name="nweek" type="button" value="下一周 " onClick="javascript:document.location='zkb_xs.asp?week1=16&kkxq=2019%E4%B8%8B';" class="button">  
  
</td></tr>
<tr><td align="center" class="td3"><strong> 2019下学期第15周(2020-5-25-2020-5-31)，热心同学</strong> </td></tr>
</table>	


<table  cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
    <td valign="top">
	
	<table class="table1" width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" >
        <tr  height="30"> 
          <td align="center" class="td1">
            5月<br>
            节次 </td>
          <td align="center" class="td1">25<br />周一</td>
          <td align="center" class="td1">26<br />周二</td>
          <td align="center" class="td1">27<br />周三</td>
          <td align="center" class="td11">28<br />周四</td>
          <td align="center" class="td1">29<br />周五</td>
		  
          <td align="center" class="td1">30<br />周六</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center" class="td1">1</td>
          
          <td id="11" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=4 id="12"  class="td2">证券投资模拟实验(实验班)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="13"  class="td2">数据挖掘应用实践(实验班)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="14"  class="td2">大数据计算实践(实验班)班<br>[网络教学]</td>
          
          <td id="15" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=2 id="16"  class="td2">数据可视化与可视分析(实验班)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center" class="td1">2</td>
          
          <td id="21" class="td2">&nbsp;</td>
          
          <td id="25" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center" class="td1">3</td>
          
          <td id="31" class="td2">&nbsp;</td>
          
          <td id="35" class="td2">&nbsp;</td>
          
          <td id="36" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center" class="td1">4</td>
          
          <td id="41" class="td2">&nbsp;</td>
          
          <td id="45" class="td2">&nbsp;</td>
          
          <td id="46" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center" class="td1">5</td>
          
          <td align="center" rowspan=4 id="51"  class="td2">数据可视化与可视分析(实验班)班<br>[网络教学]</td>
          
          <td id="52" class="td2">&nbsp;</td>
          
          <td id="53" class="td2">&nbsp;</td>
          
          <td id="54" class="td2">&nbsp;</td>
          
          <td id="55" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=4 id="56"  class="td2">互联网金融产品运营实践(实验班)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center" class="td1">6</td>
          
          <td id="62" class="td2">&nbsp;</td>
          
          <td id="63" class="td2">&nbsp;</td>
          
          <td id="64" class="td2">&nbsp;</td>
          
          <td id="65" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center" class="td1">7</td>
          
          <td id="72" class="td2">&nbsp;</td>
          
          <td id="73" class="td2">&nbsp;</td>
          
          <td id="74" class="td2">&nbsp;</td>
          
          <td id="75" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center" class="td1">8</td>
          
          <td id="82" class="td2">&nbsp;</td>
          
          <td id="83" class="td2">&nbsp;</td>
          
          <td id="84" class="td2">&nbsp;</td>
          
          <td id="85" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center" class="td1">9</td>
          
          <td id="91" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=3 id="92"  class="td2">金融仿真模拟交易系统(实验班)班<br>[网络教学]</td>
          
          <td align="center" rowspan=2 id="93"  class="td2">调课：形势与政策（六）<br>[网络教学]</td>
          
          <td id="94" class="td2">&nbsp;</td>
          
          <td id="95" class="td2">&nbsp;</td>
          
          <td id="96" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center" class="td1">10</td>
          
          <td id="101" class="td2">&nbsp;</td>
          
          <td id="104" class="td2">&nbsp;</td>
          
          <td id="105" class="td2">&nbsp;</td>
          
          <td id="106" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center" class="td1">11</td>
          
          <td id="111" class="td2">&nbsp;</td>
          
          <td id="113" class="td2">&nbsp;</td>
          
          <td id="114" class="td2">&nbsp;</td>
          
          <td id="115" class="td2">&nbsp;</td>
          
          <td id="116" class="td2">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>
"""

        /**
         * 2019下计科实验班expected
         *
         * @return String
         */
        private val experimentalCoursesExpected: String
            get() = "[SingleWeekCourse{onlyID=null, couID=null, couName='证券投资模拟实验(实验班)班', couRoom='[网络教学]', dayOfWeek=2, startNode=1, endNode=4, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='数据挖掘应用实践(实验班)班', couRoom='[网络教学]', dayOfWeek=3, startNode=1, endNode=4, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='大数据计算实践(实验班)班', couRoom='[网络教学]', dayOfWeek=4, startNode=1, endNode=4, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='数据可视化与可视分析(实验班)班', couRoom='[网络教学]', dayOfWeek=6, startNode=1, endNode=2, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='数据可视化与可视分析(实验班)班', couRoom='[网络教学]', dayOfWeek=1, startNode=5, endNode=8, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='互联网金融产品运营实践(实验班)班', couRoom='[网络教学]', dayOfWeek=6, startNode=5, endNode=8, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='金融仿真模拟交易系统(实验班)班', couRoom='[网络教学]', dayOfWeek=2, startNode=9, endNode=11, InWeek=15, CourseType=0, Color=null}, " +
                    "SingleWeekCourse{onlyID=null, couID=null, couName='调课：形势与政策（六）', couRoom='[网络教学]', dayOfWeek=3, startNode=9, endNode=10, InWeek=15, CourseType=0, Color=null}]"
    }

    /**
     * 马老师周课表
     */
    private val maCourses: String
        get() = """
<META NAME="ROBOTS" CONTENT="NOINDEX,NOFOLLOW">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META http-equiv="cache-control" content="no-cache">
<META HTTP-EQUIV="expires" CONTENT="0">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<html>
<head>
<title>福州大学至诚学院课程表</title>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<link rel="stylesheet" href="../inc/kbstyle.css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
	 
  <table width="440" border="0" cellspacing="0" id="w" align="center">
  <tr height="45"><td align="center"><input name="pweek" type="button" value="上一周 " onClick="javascript:document.location='zkb_xs.asp?week1=12&kkxq=2019%E4%B8%8B';" class="button">   						
&nbsp;&nbsp;&nbsp;&nbsp;<input name="allkb" type="button" value="完整课表" onClick="javascript:document.location='kb_xs.asp';" class="button">&nbsp;&nbsp;&nbsp;&nbsp;   
	<input name="nweek" type="button" value="下一周 " onClick="javascript:document.location='zkb_xs.asp?week1=14&kkxq=2019%E4%B8%8B';" class="button">  
  
</td></tr>
<tr><td align="center" class="td3"><strong> 2019下学期第13周(2020-5-11-2020-5-17)，马同学</strong> </td></tr>
</table>	


<table  cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
    <td valign="top">
	
	<table class="table1" width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" >
        <tr  height="30"> 
          <td align="center" class="td1">
            5月<br>
            节次 </td>
          <td align="center" class="td1">11<br />周一</td>
          <td align="center" class="td1">12<br />周二</td>
          <td align="center" class="td1">13<br />周三</td>
          <td align="center" class="td1">14<br />周四</td>
          <td align="center" class="td1">15<br />周五</td>
		  
          <td align="center" class="td1">16<br />周六</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center" class="td1">1</td>
          
          <td align="center" rowspan=4 id="11"  class="td2">高级数据库技术(1)班<br>[网络教学]</td>
          
          <td id="12" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=4 id="13"  class="td2">数据挖掘应用实践(1)班<br>[网络教学]</td>
          
          <td id="14" class="td2">&nbsp;</td>
          
          <td id="15" class="td2">&nbsp;</td>
          
          <td id="16" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center" class="td1">2</td>
          
          <td id="22" class="td2">&nbsp;</td>
          
          <td id="24" class="td2">&nbsp;</td>
          
          <td id="25" class="td2">&nbsp;</td>
          
          <td id="26" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center" class="td1">3</td>
          
          <td align="center" rowspan=2 id="32"  class="td2">大学物理（上）(15)班<br>[网络教学]<br>形势与政策（六）(6)班<br>[网络教学]</td>
          
          <td id="34" class="td2">&nbsp;</td>
          
          <td id="35" class="td2">&nbsp;</td>
          
          <td id="36" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center" class="td1">4</td>
          
          <td id="44" class="td2">&nbsp;</td>
          
          <td id="45" class="td2">&nbsp;</td>
          
          <td id="46" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center" class="td1">5</td>
          
          <td id="51" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=4 id="52"  class="td2">大数据应用开发实践(1)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="53"  class="td2">软件工程(1)班<br>[网络教学]</td>
          
          <td id="54" class="td2">&nbsp;</td>
          
          <td id="55" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=2 id="56"  class="td2">概率论与数理统计(普10)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center" class="td1">6</td>
          
          <td id="61" class="td2">&nbsp;</td>
          
          <td id="64" class="td2">&nbsp;</td>
          
          <td id="65" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center" class="td1">7</td>
          
          <td id="71" class="td2">&nbsp;</td>
          
          <td id="74" class="td2">&nbsp;</td>
          
          <td id="75" class="td2">&nbsp;</td>
          
          <td id="76" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center" class="td1">8</td>
          
          <td id="81" class="td2">&nbsp;</td>
          
          <td id="84" class="td2">&nbsp;</td>
          
          <td id="85" class="td2">&nbsp;</td>
          
          <td id="86" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center" class="td1">9</td>
          
          <td id="91" class="td2">&nbsp;</td>
          
          <td id="92" class="td2">&nbsp;</td>
          
          <td align="center" rowspan=2 id="93"  class="td2">概率论与数理统计(普10)班<br>[网络教学]</td>
          
          <td id="94" class="td2">&nbsp;</td>
          
          <td id="95" class="td2">&nbsp;</td>
          
          <td id="96" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center" class="td1">10</td>
          
          <td id="101" class="td2">&nbsp;</td>
          
          <td id="102" class="td2">&nbsp;</td>
          
          <td id="104" class="td2">&nbsp;</td>
          
          <td id="105" class="td2">&nbsp;</td>
          
          <td id="106" class="td2">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center" class="td1">11</td>
          
          <td id="111" class="td2">&nbsp;</td>
          
          <td id="112" class="td2">&nbsp;</td>
          
          <td id="113" class="td2">&nbsp;</td>
          
          <td id="114" class="td2">&nbsp;</td>
          
          <td id="115" class="td2">&nbsp;</td>
          
          <td id="116" class="td2">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>
"""

    /**
     * 马老师周课表expected
     */
    private val maCoursesExpected: String
        get() = "[SingleWeekCourse{onlyID=null, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=1, endNode=4, InWeek=13, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='数据挖掘应用实践(1)班', couRoom='[网络教学]', dayOfWeek=3, startNode=1, endNode=4, InWeek=13, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='大学物理（上）(15)班', couRoom='[网络教学]', dayOfWeek=2, startNode=3, endNode=4, InWeek=13, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='形势与政策（六）(6)班', couRoom='[网络教学]', dayOfWeek=2, startNode=3, endNode=4, InWeek=13, CourseType=4, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='大数据应用开发实践(1)班', couRoom='[网络教学]', dayOfWeek=2, startNode=5, endNode=8, InWeek=13, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='软件工程(1)班', couRoom='[网络教学]', dayOfWeek=3, startNode=5, endNode=8, InWeek=13, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='概率论与数理统计(普10)班', couRoom='[网络教学]', dayOfWeek=6, startNode=5, endNode=6, InWeek=13, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=null, couID=null, couName='概率论与数理统计(普10)班', couRoom='[网络教学]', dayOfWeek=3, startNode=9, endNode=10, InWeek=13, CourseType=0, Color=null}]"

    /**
     * 停课周课表
     *
     * @return
     */
    private val suspendCourses: String
        get() = """<META NAME="ROBOTS" CONTENT="NOINDEX,NOFOLLOW">
    <META HTTP-EQUIV="pragma" CONTENT="no-cache">
    <META http-equiv="cache-control" content="no-cache">
    <META HTTP-EQUIV="expires" CONTENT="0">
    <META http-equiv="Content-Type" content="text/html; charset=UTF-8">
     
    
    <html>
    <head>
    <title>福州大学至诚学院课程表</title>
    <meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
    <link rel="stylesheet" href="../inc/kbstyle.css">
    </head>
    
    <BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
         
      <table width="440" border="0" cellspacing="0" id="w" align="center">
      <tr height="45"><td align="center"><input name="pweek" type="button" value="上一周 " onClick="javascript:document.location='zkb_xs.asp?week1=8&kkxq=2021%E4%B8%8A';" class="button">   						
    &nbsp;&nbsp;&nbsp;&nbsp;<input name="allkb" type="button" value="完整课表" onClick="javascript:document.location='kb_xs.asp';" class="button">&nbsp;&nbsp;&nbsp;&nbsp;   
        <input name="nweek" type="button" value="下一周 " onClick="javascript:document.location='zkb_xs.asp?week1=10&kkxq=2021%E4%B8%8A';" class="button">  
      
    </td></tr>
    <tr><td align="center" class="td3"><strong> 2021上学期第9周(2021/10/25-2021/10/31)，谭同学</strong> </td></tr>
    </table>	
    
    
    <table  cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
      <tr> 
        <td valign="top">
        
        <table class="table1" width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" >
            <tr  height="30"> 
              <td align="center" class="td1">
                10月<br>
                节次 </td>
              <td align="center" class="td1">25<br />周一</td>
              <td align="center" class="td1">26<br />周二</td>
              <td align="center" class="td1">27<br />周三</td>
              <td align="center" class="td11">28<br />周四</td>
              <td align="center" class="td1">29<br />周五</td>
              
            </tr>
            
            
            <tr id="tr1"> 
              <td align="center" class="td1">1<br>08:00</td>
              
              <td align="center" rowspan=2 id="11"  class="td2">工程力学(1)班<br>[地矿310](08:00)</td>
              
              <td align="center" rowspan=2 id="12"  class="td2">大学物理（下）(17)班<br>[机北305](08:00)</td>
              
              <td id="13" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=2 id="14"  class="td2">工程制图(1)班<br>[地矿310](08:00)</td>
              
              <td id="15" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr2"> 
              <td align="center" class="td1">2<br>08:55</td>
              
              <td id="23" class="td2">&nbsp;</td>
              
              <td id="25" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr3"> 
              <td align="center" class="td1">3<br>10:00</td>
              
              <td id="31" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=2 id="32"  class="td2">工程制图(1)班<br>[地矿310](09:55)</td>
              
              <td id="33" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=2 id="34"  class="td2">工程CAD(1)班<br>[轻工615](09:55)</td>
              
              <td id="35" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr4"> 
              <td align="center" class="td1">4<br>10:55</td>
              
              <td id="41" class="td2">&nbsp;</td>
              
              <td id="43" class="td2">&nbsp;</td>
              
              <td id="45" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr5"> 
              <td align="center" class="td1">5<br>14:00</td>
              
              <td id="51" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=2 id="52"  class="td2">大学物理实验（下）(5)班<br>[单][电机楼四楼大厅](14:00)</td>
              
              <td align="center" rowspan=2 id="53"  class="td2">工程力学(1)班<br>[地矿310](14:00)</td>
              
              <td id="54" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=2 id="55"  class="td2">马克思主义基本原理概论(11)班<br>[机北407](14:00)<br>停课：马克思主义基本原理概论<br>[机北407]</td>
              
            </tr>
            
            <tr id="tr6"> 
              <td align="center" class="td1">6<br>14:55</td>
              
              <td id="61" class="td2">&nbsp;</td>
              
              <td id="64" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr7"> 
              <td align="center" class="td1">7<br>16:00</td>
              
              <td align="center" rowspan=2 id="71"  class="td2">电工学(1)班<br>[地矿306](15:55)</td>
              
              <td id="72" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=2 id="73"  class="td2">电工学(1)班<br>[地矿306](15:55)</td>
              
              <td align="center" rowspan=2 id="74"  class="td2">体育（三）(48)班<br>[田径场](15:55)</td>
              
              <td id="75" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr8"> 
              <td align="center" class="td1">8<br>16:55</td>
              
              <td id="82" class="td2">&nbsp;</td>
              
              <td id="85" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr9"> 
              <td align="center" class="td1">9<br>19:00</td>
              
              <td id="91" class="td2">&nbsp;</td>
              
              <td align="center" rowspan=3 id="92"  class="td2">跨文化交际(16)班<br>[机北207]</td>
              
              <td id="93" class="td2">&nbsp;</td>
              
              <td id="94" class="td2">&nbsp;</td>
              
              <td id="95" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr10"> 
              <td align="center" class="td1">10</td>
              
              <td id="101" class="td2">&nbsp;</td>
              
              <td id="103" class="td2">&nbsp;</td>
              
              <td id="104" class="td2">&nbsp;</td>
              
              <td id="105" class="td2">&nbsp;</td>
              
            </tr>
            
            <tr id="tr11"> 
              <td align="center" class="td1">11</td>
              
              <td id="111" class="td2">&nbsp;</td>
              
              <td id="113" class="td2">&nbsp;</td>
              
              <td id="114" class="td2">&nbsp;</td>
              
              <td id="115" class="td2">&nbsp;</td>
              
            </tr>
            
          </table></td>
      </tr>
    </table>
        
    </body>
    </html>
"""

    /**
     * 停课周课表 结果
     *
     * @return
     */
    private val suspendCoursesExpected: String
        get() = "[SingleWeekCourse{onlyID=null, couID=null, couName='工程力学(1)班', couRoom='[地矿310](08:00)', dayOfWeek=1, startNode=1, endNode=2, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='大学物理（下）(17)班', couRoom='[机北305](08:00)', dayOfWeek=2, startNode=1, endNode=2, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='工程制图(1)班', couRoom='[地矿310](08:00)', dayOfWeek=4, startNode=1, endNode=2, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='工程制图(1)班', couRoom='[地矿310](09:55)', dayOfWeek=2, startNode=3, endNode=4, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='工程CAD(1)班', couRoom='[轻工615](09:55)', dayOfWeek=4, startNode=3, endNode=4, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='大学物理实验（下）(5)班', couRoom='[单][电机楼四楼大厅](14:00)', dayOfWeek=2, startNode=5, endNode=6, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='工程力学(1)班', couRoom='[地矿310](14:00)', dayOfWeek=3, startNode=5, endNode=6, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='马克思主义基本原理概论(11)班', couRoom='[机北407](14:00)', dayOfWeek=5, startNode=5, endNode=6, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='停课：马克思主义基本原理概论', couRoom='[机北407]', dayOfWeek=5, startNode=5, endNode=6, InWeek=9, CourseType=4, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='电工学(1)班', couRoom='[地矿306](15:55)', dayOfWeek=1, startNode=7, endNode=8, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='电工学(1)班', couRoom='[地矿306](15:55)', dayOfWeek=3, startNode=7, endNode=8, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='体育（三）(48)班', couRoom='[田径场](15:55)', dayOfWeek=4, startNode=7, endNode=8, InWeek=9, CourseType=0, Color=null}, SingleWeekCourse{onlyID=null, couID=null, couName='跨文化交际(16)班', couRoom='[机北207]', dayOfWeek=2, startNode=9, endNode=11, InWeek=9, CourseType=0, Color=null}]"
}
