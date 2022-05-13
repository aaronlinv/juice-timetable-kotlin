package com.juice.timetable.data.parse

import org.junit.Assert
import org.junit.Test

class ParseAllWeekTest {
    /**
     * 计算机科学与技术
     */
    @Test
    fun parseCS() {
        val actual: String = ParseAllWeek.parseCourse(csCourses).toString()
        val expected = csCoursesExpected
        Assert.assertEquals(expected, actual)

        val semester: String = ParseAllWeek.semester
        Assert.assertEquals("福州大学至诚学院 2019下学期张三同学课程表", semester)
    }

    /**
     * 汉语言
     */
    @Test
    fun parseChinese() {
        val actual: String = ParseAllWeek.parseCourse(chineseCourses).toString()
        val expected = chineseCoursesExpected
        Assert.assertEquals(expected, actual)

        val semester: String = ParseAllWeek.semester
        Assert.assertEquals("福州大学至诚学院 2019下学期小易同学课程表", semester)
    }

    /**
     * 2017 计科
     */
    @Test
    fun parseCS2017() {
        val actual: String = ParseAllWeek.parseCourse(cs2017Courses).toString()
        val expected = cs2017CoursesExpected
        Assert.assertEquals(expected, actual)

        val semester: String = ParseAllWeek.semester
        Assert.assertEquals("福州大学至诚学院 2017下学期张三同学课程表", semester)
    }

    /**
     * 2019 实验班
     */
    @Test
    fun parseExperimental() {
        val actual: String = ParseAllWeek.parseCourse(experimentalCourses).toString()
        val expected = experimentalCoursesExpected
        Assert.assertEquals(expected, actual)

        val semester: String = ParseAllWeek.semester
        Assert.assertEquals("福州大学至诚学院 2019下学期实验班同学课程表", semester)
    }

    /**
     * 马同学
     */
    @Test
    fun parseMa() {
        val actual: String = ParseAllWeek.parseCourse(maCourses).toString()
        val expected = maCoursesExpected
        Assert.assertEquals(expected, actual)

        val semester: String = ParseAllWeek.semester
        Assert.assertEquals("福州大学至诚学院 2019下学期马同学课程表", semester)
    }

    /**
     * 重修实验课测试
     */
    @Test
    fun parseExperimentalClass() {
        val actual: String = ParseAllWeek.parseCourse(relearnCourses).toString()
        val expected = relearnCoursesExpected
        Assert.assertEquals(expected, actual)

        val semester: String = ParseAllWeek.semester
        Assert.assertEquals("福州大学至诚学院 2019下学期吴同学课程表", semester)
    }

    companion object {
        /**
         * 计算机科学与技术完整课表
         */
        val csCourses: String
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
<style media=print>
.Noprint{display:none;}
.PageNext{page-break-after: always;}
</style>

<style>
<!-- 
table {
	font-size: 10pt;
}
td {
	font-size: 9pt;
}
.button {font-family: "宋体";font-size: 9pt;color: #00006a; height: 19}
-->
</style>

<link href="../inc/style.css" rel="stylesheet" type="text/css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
  <table width="100%" border="0" cellspacing="0" id="w" class="Noprint">
  <tr><td align="center">
<form name="form" method="post" action="kb_xs.asp">
	 <input name="menu_no" type="hidden" value="">
	 
&nbsp;查询学期：<input name="xn" type="text" size="4" value="2019">学年 
		<select name="xq">
			<option value="下">下</option> 
			<option value=""></option>  	
			<option value="上">上</option>
			<option value="下">下</option>
		</select>
		学期 <input type="submit" name="Submit" value="查询" class="button">
		&nbsp;&nbsp;<input name="print" type="button" value=" 打印 " onClick="javascript:window.print();" class="button">			 
</form>
</td></tr></table>	

<div align="center"><strong>福州大学至诚学院 2019下学期张三同学课程表</strong>(2020-4-28 14:45:12)</div>
<table width="880" cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
<!--      <td valign="top"><table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">-->
    <td valign="top"><table width="100%" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">课程名称</td>
          <td align="center">大纲/进度表</td>
          <td align="center">任课教师</td>
		  <td align="center">选修类型</td>
		  <td align="center">考试类别</td>		  
		  <td align="center">班级</td>		  
		  <td align="center">学分</td>
          <td align="center">总<br>学<br>时 </td>
          <td align="center">周<br>学<br>时 </td>
          <td align="center">实<br>验<br>学<br>时 </td>
          <td align="center">起讫时间<br>周序<br>(星期)</td>
        </tr>
        
        <tr> 
          <td  >&nbsp;形势与政策（六） (6)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106010" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106010" target="_blank">进度表</a></td>			
          <td align="center">韩晞婷</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">6班</td>					  
		  <td align="center">.5</td>
          <td align="center">8</td>
          <td align="center">2</td>
          <td align="center"></td>
          <td align="center">11～14</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;高级数据库技术 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111306&kkhm=2019%E4%B8%8B16111306001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111306&kkhm=2019%E4%B8%8B16111306001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向2</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">4</td>
          <td align="center">24</td>
          <td align="center">01～14</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：022</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数据挖掘与分析 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111405&kkhm=2019%E4%B8%8B16111405001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111405&kkhm=2019%E4%B8%8B16111405001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向2</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">4</td>
          <td align="center">10</td>
          <td align="center">01～08</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：022</td></tr>
       
        <tr> 
          <td  >&nbsp;大数据应用开发 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111308&kkhm=2019%E4%B8%8B16111308001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111308&kkhm=2019%E4%B8%8B16111308001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">4</td>
          <td align="center">16</td>
          <td align="center">01～08</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;软件工程 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06111303&kkhm=2019%E4%B8%8B06111303001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06111303&kkhm=2019%E4%B8%8B06111303001" target="_blank">进度表</a></td>			
          <td align="center">张栋</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">2</td>
          <td align="center">18</td>
          <td align="center">01～13</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;数据可视化与可视分析 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17111403&kkhm=2019%E4%B8%8B17111403001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17111403&kkhm=2019%E4%B8%8B17111403001" target="_blank">进度表</a></td>			
          <td align="center">沈炎斌</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">16</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;云计算与数据中心 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111407&kkhm=2019%E4%B8%8B16111407002" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111407&kkhm=2019%E4%B8%8B16111407002" target="_blank">进度表</a></td>			
          <td align="center">林庆新</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">8</td>
          <td align="center">12</td>
          <td align="center">01～04</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;中国古典诗词中的品格与修养 (121)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=80000117&kkhm=2019%E4%B8%8B80000117121" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=80000117&kkhm=2019%E4%B8%8B80000117121" target="_blank">进度表</a></td>			
          <td align="center"></td>
		  <td align="center">院选课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">院选课智慧树</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center"></td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：期末成绩=平时学习40%+学院组织的线下考试60%</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;大数据应用开发实践 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111603&kkhm=2019%E4%B8%8B16111603001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111603&kkhm=2019%E4%B8%8B16111603001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">09～16</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：选修</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;大数据综合应用案例实训 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17111607&kkhm=2019%E4%B8%8B17111607001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17111607&kkhm=2019%E4%B8%8B17111607001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">05～11</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：选修</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数据挖掘应用实践 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17111606&kkhm=2019%E4%B8%8B17111606001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17111606&kkhm=2019%E4%B8%8B17111606001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">√</td>
          <td align="center">4</td>
          <td align="center">09～15</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：选修</td></tr>
       
      </table><font color="#CC3333">
	  </font>
	  </td>
    <td valign="top">
	
	<table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">
            星期<br>
            节次 </td>
          <td align="center">一</td>
          <td align="center">二</td>
          <td align="center">三</td>
          <td align="center">四</td>
          <td align="center">五</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center">1</td>
          
          <td align="center" rowspan=4 id="11">高级数据库技术(1)班<br>[网络教学]</td>
          
          <td id="12">&nbsp;</td>
          
          <td align="center" rowspan=4 id="13">数据挖掘与分析(1)班<br>[网络教学]<br>数据挖掘应用实践(1)班<br>[网络教学]<br>数据挖掘应用实践(1)班<br>[网络教学]<br>[1~2节]<br>(16-16周)</td>
          
          <td id="14">&nbsp;</td>
          
          <td align="center" rowspan=4 id="15">云计算与数据中心(1)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center">2</td>
          
          <td id="22">&nbsp;</td>
          
          <td id="24">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center">3</td>
          
          <td align="center" rowspan=2 id="32">形势与政策（六）(6)班<br>[网络教学]</td>
          
          <td id="34">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center">4</td>
          
          <td id="44">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center">5</td>
          
          <td align="center" rowspan=2 id="51">软件工程(1)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="52">大数据应用开发(1)班<br>[网络教学]<br>大数据应用开发实践(1)班<br>[网络教学]<br>大数据应用开发实践(1)班<br>[网络教学]<br>[5~6节]<br>(17-17周)</td>
          
          <td align="center" rowspan=4 id="53">软件工程(1)班<br>[网络教学]<br>(05-08周)<br>软件工程(1)班<br>[网络教学]<br>(10-10周)<br>云计算与数据中心(1)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="54">大数据综合应用案例实训(1)班<br>[网络教学]<br>大数据综合应用案例实训(1)班<br>[网络教学]<br>[5~6节]<br>(13-13周)</td>
          
          <td id="55">&nbsp;</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center">6</td>
          
          <td id="65">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center">7</td>
          
          <td id="71">&nbsp;</td>
          
          <td id="75">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center">8</td>
          
          <td id="81">&nbsp;</td>
          
          <td id="85">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center">9</td>
          
          <td id="91">&nbsp;</td>
          
          <td id="92">&nbsp;</td>
          
          <td id="93">&nbsp;</td>
          
          <td id="94">&nbsp;</td>
          
          <td id="95">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center">10</td>
          
          <td id="101">&nbsp;</td>
          
          <td id="102">&nbsp;</td>
          
          <td id="103">&nbsp;</td>
          
          <td id="104">&nbsp;</td>
          
          <td id="105">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center">11</td>
          
          <td id="111">&nbsp;</td>
          
          <td id="112">&nbsp;</td>
          
          <td id="113">&nbsp;</td>
          
          <td id="114">&nbsp;</td>
          
          <td id="115">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>

"""

        /**
         * 计算机科学与技术完整课表 预期结果
         */
        val csCoursesExpected: String
            get() = "[Course{couID=8, onlyID=0, couName='中国古典诗词中的品格与修养 (121)班', couRoom='null', couTeacher='智慧树', couWeek=null, couStartNode=null, couEndNode=null, couWeekType=3, couStartWeek=null, couEndWeek=null, couColor=null}, " +
                    "Course{couID=1, onlyID=1, couName='高级数据库技术 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=1, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=14, couColor=null}, " +
                    "Course{couID=2, onlyID=2, couName='数据挖掘与分析 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                    "Course{couID=11, onlyID=3, couName='数据挖掘应用实践 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=9, couEndWeek=15, couColor=null}, " +
                    "Course{couID=11, onlyID=4, couName='数据挖掘应用实践 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=16, couEndWeek=16, couColor=null}, " +
                    "Course{couID=6, onlyID=5, couName='云计算与数据中心 (1)班', couRoom='网络教学', couTeacher='林庆新', couWeek=5, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                    "Course{couID=0, onlyID=6, couName='形势与政策（六） (6)班', couRoom='网络教学', couTeacher='韩晞婷', couWeek=2, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=11, couEndWeek=14, couColor=null}, " +
                    "Course{couID=4, onlyID=7, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=1, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=13, couColor=null}, " +
                    "Course{couID=3, onlyID=8, couName='大数据应用开发 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=2, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                    "Course{couID=9, onlyID=9, couName='大数据应用开发实践 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=2, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=9, couEndWeek=16, couColor=null}, " +
                    "Course{couID=9, onlyID=10, couName='大数据应用开发实践 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=2, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=17, couEndWeek=17, couColor=null}, " +
                    "Course{couID=4, onlyID=11, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=5, couEndWeek=8, couColor=null}, " +
                    "Course{couID=4, onlyID=12, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=10, couEndWeek=10, couColor=null}, " +
                    "Course{couID=6, onlyID=13, couName='云计算与数据中心 (1)班', couRoom='网络教学', couTeacher='林庆新', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                    "Course{couID=10, onlyID=14, couName='大数据综合应用案例实训 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=5, couEndWeek=11, couColor=null}, " +
                    "Course{couID=10, onlyID=15, couName='大数据综合应用案例实训 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=13, couEndWeek=13, couColor=null}]"

        /**
         * 汉语言完整课表
         */
        val chineseCourses: String
            get() = """<META NAME="ROBOTS" CONTENT="NOINDEX,NOFOLLOW">
<META HTTP-EQUIV="pragma" CONTENT="no-cache">
<META http-equiv="cache-control" content="no-cache">
<META HTTP-EQUIV="expires" CONTENT="0">
<META http-equiv="Content-Type" content="text/html; charset=UTF-8">
 

<html>
<head>
<title>福州大学至诚学院课程表</title>
<meta http-equiv="Content-Type" content="text/html; Charset=UTF-8">
<style media=print>
.Noprint{display:none;}
.PageNext{page-break-after: always;}
</style>

<style>
<!-- 
table {
	font-size: 10pt;
}
td {
	font-size: 9pt;
}
.button {font-family: "宋体";font-size: 9pt;color: #00006a; height: 19}
-->
</style>

<link href="../inc/style.css" rel="stylesheet" type="text/css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
  <table width="100%" border="0" cellspacing="0" id="w" class="Noprint">
  <tr><td align="center">
<form name="form" method="post" action="kb_xs.asp">
	 <input name="menu_no" type="hidden" value="">
	 
&nbsp;查询学期：<input name="xn" type="text" size="4" value="2019">学年 
		<select name="xq">
			<option value="下">下</option> 
			<option value=""></option>  	
			<option value="上">上</option>
			<option value="下">下</option>
		</select>
		学期 <input type="submit" name="Submit" value="查询" class="button">
		&nbsp;&nbsp;<input name="print" type="button" value=" 打印 " onClick="javascript:window.print();" class="button">			 
</form>
</td></tr></table>	

<div align="center"><strong>福州大学至诚学院 2019下学期小易同学课程表</strong>(2020-5-10 22:28:36)</div>
<table width="880" cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
<!--      <td valign="top"><table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">-->
    <td valign="top"><table width="100%" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">课程名称</td>
          <td align="center">大纲/进度表</td>
          <td align="center">任课教师</td>
		  <td align="center">选修类型</td>
		  <td align="center">考试类别</td>		  
		  <td align="center">班级</td>		  
		  <td align="center">学分</td>
          <td align="center">总<br>学<br>时 </td>
          <td align="center">周<br>学<br>时 </td>
          <td align="center">实<br>验<br>学<br>时 </td>
          <td align="center">起讫时间<br>周序<br>(星期)</td>
        </tr>
        
        <tr> 
          <td  >&nbsp;大学英语（四） (10)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06000108&kkhm=2019%E4%B8%8B06000108010" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06000108&kkhm=2019%E4%B8%8B06000108010" target="_blank">进度表</a></td>			
          <td align="center">刘伟</td>
		  <td align="center">通识必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">10班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">3</td>
          <td align="center"></td>
          <td align="center">01～17</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;毛泽东思想和中国特色社会主义理论体系概论 (19)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=11000101&kkhm=2019%E4%B8%8B11000101019" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=11000101&kkhm=2019%E4%B8%8B11000101019" target="_blank">进度表</a></td>			
          <td align="center">叶钦</td>
		  <td align="center">通识必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">19班</td>					  
		  <td align="center">4</td>
          <td align="center">64</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">01～16</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;体育（四）</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06000125&kkhm=2019%E4%B8%8B06000125017" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06000125&kkhm=2019%E4%B8%8B06000125017" target="_blank">进度表</a></td>			
          <td align="center">何语林</td>
		  <td align="center">通识必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018汉语言1</td>					  
		  <td align="center">1</td>
          <td align="center">36</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center">08～13</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;形势与政策（四） (2)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=08000106&kkhm=2019%E4%B8%8B08000106002" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=08000106&kkhm=2019%E4%B8%8B08000106002" target="_blank">进度表</a></td>			
          <td align="center">郑声文</td>
		  <td align="center">通识必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2班</td>					  
		  <td align="center">.5</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center">01～01<br>03～03</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;古代汉语（下） (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06502204&kkhm=2019%E4%B8%8B06502204001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06502204&kkhm=2019%E4%B8%8B06502204001" target="_blank">进度表</a></td>			
          <td align="center">宋铁全</td>
		  <td align="center">专业基础</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018级汉语言1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">3</td>
          <td align="center"></td>
          <td align="center">14～16</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;语言学概论 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06502207&kkhm=2019%E4%B8%8B06502207001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06502207&kkhm=2019%E4%B8%8B06502207001" target="_blank">进度表</a></td>			
          <td align="center">卓星友,韩晞婷</td>
		  <td align="center">专业基础</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018级汉语言1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;中国古代文学（四） (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06502213&kkhm=2019%E4%B8%8B06502213001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06502213&kkhm=2019%E4%B8%8B06502213001" target="_blank">进度表</a></td>			
          <td align="center">苗健青</td>
		  <td align="center">专业基础</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018级汉语言1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">3</td>
          <td align="center"></td>
          <td align="center">12～18</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;中国现当代文学（下） (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06502215&kkhm=2019%E4%B8%8B06502215001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06502215&kkhm=2019%E4%B8%8B06502215001" target="_blank">进度表</a></td>			
          <td align="center">牛康</td>
		  <td align="center">专业基础</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018级汉语言1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">3</td>
          <td align="center"></td>
          <td align="center">14～16</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;生命安全与救援 (114)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=80000112&kkhm=2019%E4%B8%8B80000112114" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=80000112&kkhm=2019%E4%B8%8B80000112114" target="_blank">进度表</a></td>			
          <td align="center"></td>
		  <td align="center">院选课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">院选课超星尔雅</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center"></td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：期末成绩=平时学习40%+学院组织的线下考试60%</td></tr>
       
        <tr> 
          <td  >&nbsp;思想政治理论课实践(二) (19)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=07004608&kkhm=2019%E4%B8%8B07004608019" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=07004608&kkhm=2019%E4%B8%8B07004608019" target="_blank">进度表</a></td>			
          <td align="center">叶钦</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">19班</td>					  
		  <td align="center">1</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center"></td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;学科实践（四） (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06502604&kkhm=2019%E4%B8%8B06502604001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06502604&kkhm=2019%E4%B8%8B06502604001" target="_blank">进度表</a></td>			
          <td align="center">牛康</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018级汉语言1</td>					  
		  <td align="center">2</td>
          <td align="center"></td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;学年论文（一） (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=07502608&kkhm=2019%E4%B8%8B07502608001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=07502608&kkhm=2019%E4%B8%8B07502608001" target="_blank">进度表</a></td>			
          <td align="center">牛康</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2018级汉语言1</td>					  
		  <td align="center">1.5</td>
          <td align="center"></td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">05～07</td>	
        </tr>
       
      </table><font color="#CC3333">
	  </font>
	  </td>
    <td valign="top">
	
	<table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">
            星期<br>
            节次 </td>
          <td align="center">一</td>
          <td align="center">二</td>
          <td align="center">三</td>
          <td align="center">四</td>
          <td align="center">五</td>
		  
          <td align="center">六</td>
		  
          <td align="center">日</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center">1</td>
          
          <td id="11">&nbsp;</td>
          
          <td align="center" rowspan=2 id="12">毛泽东思想和中国特色社会主义理论体系概论(19)班<br>[网络教学]</td>
          
          <td id="13">&nbsp;</td>
          
          <td id="14">&nbsp;</td>
          
          <td id="15">&nbsp;</td>
          
          <td id="16">&nbsp;</td>
          
          <td align="center" rowspan=2 id="17">形势与政策（四）(2)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center">2</td>
          
          <td id="21">&nbsp;</td>
          
          <td align="center" rowspan=3 id="23">古代汉语（下）(1)班<br>[机北406]<br>古代汉语（下）(1)班<br>[网络教学]<br>(01-16周)</td>
          
          <td id="24">&nbsp;</td>
          
          <td align="center" rowspan=3 id="25">学年论文（一）(1)班<br>[网络教学]</td>
          
          <td id="26">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center">3</td>
          
          <td align="center" rowspan=2 id="31">语言学概论(1)班<br>[网络教学]<br>(08-15周)</td>
          
          <td id="32">&nbsp;</td>
          
          <td align="center" rowspan=2 id="34">大学英语（四）(10)班<br>[单][网络教学]</td>
          
          <td align="center" rowspan=2 id="36">形势与政策（四）(2)班<br>[网络教学]</td>
          
          <td id="37">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center">4</td>
          
          <td id="42">&nbsp;</td>
          
          <td id="47">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center">5</td>
          
          <td align="center" rowspan=2 id="51">大学英语（四）(10)班<br>[网络教学]</td>
          
          <td align="center" rowspan=2 id="52">语言学概论(1)班<br>[网络教学]<br>(08-15周)</td>
          
          <td id="53">&nbsp;</td>
          
          <td align="center" rowspan=2 id="54">毛泽东思想和中国特色社会主义理论体系概论(19)班<br>[网络教学]</td>
          
          <td id="55">&nbsp;</td>
          
          <td id="56">&nbsp;</td>
          
          <td id="57">&nbsp;</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center">6</td>
          
          <td id="63">&nbsp;</td>
          
          <td id="65">&nbsp;</td>
          
          <td id="66">&nbsp;</td>
          
          <td id="67">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center">7</td>
          
          <td id="71">&nbsp;</td>
          
          <td id="72">&nbsp;</td>
          
          <td id="73">&nbsp;</td>
          
          <td id="74">&nbsp;</td>
          
          <td id="75">&nbsp;</td>
          
          <td id="76">&nbsp;</td>
          
          <td id="77">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center">8</td>
          
          <td id="81">&nbsp;</td>
          
          <td id="82">&nbsp;</td>
          
          <td id="83">&nbsp;</td>
          
          <td id="84">&nbsp;</td>
          
          <td id="85">&nbsp;</td>
          
          <td id="86">&nbsp;</td>
          
          <td id="87">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center">9</td>
          
          <td align="center" rowspan=3 id="91">中国现当代文学（下）(1)班<br>[机北406]<br>中国现当代文学（下）(1)班<br>[网络教学]<br>(01-16周)</td>
          
          <td id="92">&nbsp;</td>
          
          <td align="center" rowspan=3 id="93">中国古代文学（四）(1)班<br>[机北407]</td>
          
          <td id="94">&nbsp;</td>
          
          <td id="95">&nbsp;</td>
          
          <td id="96">&nbsp;</td>
          
          <td id="97">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center">10</td>
          
          <td id="102">&nbsp;</td>
          
          <td id="104">&nbsp;</td>
          
          <td id="105">&nbsp;</td>
          
          <td id="106">&nbsp;</td>
          
          <td id="107">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center">11</td>
          
          <td id="112">&nbsp;</td>
          
          <td id="114">&nbsp;</td>
          
          <td id="115">&nbsp;</td>
          
          <td id="116">&nbsp;</td>
          
          <td id="117">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>
"""

        /**
         * 汉语言完整课表 预期结果
         */
        val chineseCoursesExpected: String
            get() = "[Course{couID=9, onlyID=0, couName='生命安全与救援 (114)班', couRoom='null', couTeacher='超星尔雅', couWeek=null, couStartNode=null, couEndNode=null, couWeekType=3, couStartWeek=null, couEndWeek=null, couColor=null}, " +
                    "Course{couID=1, onlyID=1, couName='毛泽东思想和中国特色社会主义理论体系概论 (19)班', couRoom='网络教学', couTeacher='叶钦', couWeek=2, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=3, onlyID=3, couName='形势与政策（四） (2)班', couRoom='网络教学', couTeacher='郑声文', couWeek=7, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=3, couEndWeek=3, couColor=null}, " +
                    "Course{couID=4, onlyID=4, couName='古代汉语（下） (1)班', couRoom='机北406', couTeacher='宋铁全', couWeek=3, couStartNode=2, couEndNode=4, couWeekType=0, couStartWeek=14, couEndWeek=16, couColor=null}, " +
                    "Course{couID=4, onlyID=5, couName='古代汉语（下） (1)班', couRoom='网络教学', couTeacher='宋铁全', couWeek=3, couStartNode=2, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=12, onlyID=6, couName='学年论文（一） (1)班', couRoom='网络教学', couTeacher='牛康', couWeek=5, couStartNode=2, couEndNode=4, couWeekType=0, couStartWeek=5, couEndWeek=7, couColor=null}, " +
                    "Course{couID=5, onlyID=7, couName='语言学概论 (1)班', couRoom='网络教学', couTeacher='卓星友,韩晞婷', couWeek=1, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=8, couEndWeek=15, couColor=null}, " +
                    "Course{couID=0, onlyID=8, couName='大学英语（四） (10)班', couRoom='网络教学', couTeacher='刘伟', couWeek=4, couStartNode=3, couEndNode=4, couWeekType=1, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=3, onlyID=10, couName='形势与政策（四） (2)班', couRoom='网络教学', couTeacher='郑声文', couWeek=6, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=3, couEndWeek=3, couColor=null}, " +
                    "Course{couID=0, onlyID=11, couName='大学英语（四） (10)班', couRoom='网络教学', couTeacher='刘伟', couWeek=1, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=5, onlyID=12, couName='语言学概论 (1)班', couRoom='网络教学', couTeacher='卓星友,韩晞婷', couWeek=2, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=8, couEndWeek=15, couColor=null}, " +
                    "Course{couID=1, onlyID=13, couName='毛泽东思想和中国特色社会主义理论体系概论 (19)班', couRoom='网络教学', couTeacher='叶钦', couWeek=4, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=7, onlyID=14, couName='中国现当代文学（下） (1)班', couRoom='机北406', couTeacher='牛康', couWeek=1, couStartNode=9, couEndNode=11, couWeekType=0, couStartWeek=14, couEndWeek=16, couColor=null}, " +
                    "Course{couID=7, onlyID=15, couName='中国现当代文学（下） (1)班', couRoom='网络教学', couTeacher='牛康', couWeek=1, couStartNode=9, couEndNode=11, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=6, onlyID=16, couName='中国古代文学（四） (1)班', couRoom='机北407', couTeacher='苗健青', couWeek=3, couStartNode=9, couEndNode=11, couWeekType=0, couStartWeek=12, couEndWeek=18, couColor=null}]"

        /**
         * 2017 计科完整课表
         */
        val cs2017Courses: String
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
  <style media=print>
  .Noprint{display:none;}
  .PageNext{page-break-after: always;}
  </style>
  
  <style>
  <!-- 
  table {
    font-size: 10pt;
  }
  td {
    font-size: 9pt;
  }
  .button {font-family: "宋体";font-size: 9pt;color: #00006a; height: 19}
  -->
  </style>
  
  <link href="../inc/style.css" rel="stylesheet" type="text/css">
  </head>
  
  <BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
    <table width="100%" border="0" cellspacing="0" id="w" class="Noprint">
    <tr><td align="center">
  <form name="form" method="post" action="kb_xs.asp">
     <input name="menu_no" type="hidden" value="">
     
  &nbsp;查询学期：<input name="xn" type="text" size="4" value="2017">学年 
      <select name="xq">
        <option value="下">下</option> 
        <option value=""></option>  	
        <option value="上">上</option>
        <option value="下">下</option>
      </select>
      学期 <input type="submit" name="Submit" value="查询" class="button">
      &nbsp;&nbsp;<input name="print" type="button" value=" 打印 " onClick="javascript:window.print();" class="button">			 
  </form>
  </td></tr></table>	
  
  <div align="center"><strong>福州大学至诚学院 2017下学期张三同学课程表</strong>(2020-5-28 10:17:40)</div>
  <table width="880" cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
    <tr> 
  <!--      <td valign="top"><table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">-->
      <td valign="top"><table width="100%" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
          <tr  height="30"> 
            <td align="center">课程名称</td>
            <td align="center">大纲/进度表</td>
            <td align="center">任课教师</td>
        <td align="center">选修类型</td>
        <td align="center">考试类别</td>		  
        <td align="center">班级</td>		  
        <td align="center">学分</td>
            <td align="center">总<br>学<br>时 </td>
            <td align="center">周<br>学<br>时 </td>
            <td align="center">实<br>验<br>学<br>时 </td>
            <td align="center">起讫时间<br>周序<br>(星期)</td>
          </tr>
          
          <tr> 
            <td  >&nbsp;大学物理（上） (9)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=06000118&kkhm=2017%E4%B8%8B06000118009" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=06000118&kkhm=2017%E4%B8%8B06000118009" target="_blank">进度表</a></td>			
            <td align="center">孙磊</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">9班</td>					  
        <td align="center">1.5</td>
            <td align="center">30</td>
            <td align="center">2</td>
            <td align="center"></td>
            <td align="center">02～17</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;大学英语（二） (20)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=08000104&kkhm=2017%E4%B8%8B08000104020" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=08000104&kkhm=2017%E4%B8%8B08000104020" target="_blank">进度表</a></td>			
            <td align="center">庄星来</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">20班</td>					  
        <td align="center">3</td>
            <td align="center">48</td>
            <td align="center">3</td>
            <td align="center"></td>
            <td align="center">01～17</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;高等数学（一）下 (7)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=08000102&kkhm=2017%E4%B8%8B08000102007" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=08000102&kkhm=2017%E4%B8%8B08000102007" target="_blank">进度表</a></td>			
            <td align="center">侯远</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">7班</td>					  
        <td align="center">4</td>
            <td align="center">80</td>
            <td align="center">5</td>
            <td align="center"></td>
            <td align="center">01～17</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;高级语言程序设计(C语言) (1)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=14000101&kkhm=2017%E4%B8%8B14000101001" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=14000101&kkhm=2017%E4%B8%8B14000101001" target="_blank">进度表</a></td>			
            <td align="center">冯新</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">1班</td>					  
        <td align="center">2.5</td>
            <td align="center">44</td>
            <td align="center">6</td>
            <td align="center"></td>
            <td align="center">01～16</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;体育（二） (16)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=06000123&kkhm=2017%E4%B8%8B06000123016" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=06000123&kkhm=2017%E4%B8%8B06000123016" target="_blank">进度表</a></td>			
            <td align="center">卞贞坤</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">16班,周二5、6节  男</td>					  
        <td align="center">1</td>
            <td align="center">36</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center">02～15</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;形势与政策（上） (16)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=10000103&kkhm=2017%E4%B8%8B10000103016" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=10000103&kkhm=2017%E4%B8%8B10000103016" target="_blank">进度表</a></td>			
            <td align="center">陈文福,魏渊,林筠颖,吴迪</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">16班,周四9,10节</td>					  
        <td align="center">1</td>
            <td align="center">16</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center">04～10</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;中国近现代史纲要 (4)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=07004110&kkhm=2017%E4%B8%8B07004110004" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=07004110&kkhm=2017%E4%B8%8B07004110004" target="_blank">进度表</a></td>			
            <td align="center">郑恒鑫</td>
        <td align="center">公共必修</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">4班,周1:9-10节</td>					  
        <td align="center">2</td>
            <td align="center">32</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center">01～13</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;数字电路与逻辑设计 (1)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=06104205&kkhm=2017%E4%B8%8B06104205001" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=06104205&kkhm=2017%E4%B8%8B06104205001" target="_blank">进度表</a></td>			
            <td align="center">阴爱英</td>
        <td align="center">专业基础</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">2017级计算机1</td>					  
        <td align="center">3</td>
            <td align="center">48</td>
            <td align="center">3</td>
            <td align="center">*</td>
            <td align="center">01～13</td>	
          </tr>
         
          <tr> 
            <td rowspan="2"  >&nbsp;大学英语四级考试辅导 (30)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=16000508&kkhm=2017%E4%B8%8B16000508030" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=16000508&kkhm=2017%E4%B8%8B16000508030" target="_blank">进度表</a></td>			
            <td align="center">谢强英</td>
        <td align="center">院选课</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">院选课</td>					  
        <td align="center">2</td>
            <td align="center">36</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center">03～15</td>	
          </tr>
         
          <tr height="25"><td align="left" colspan="10">★备注：非英语专业；四级未通过；英语不能有不及格记录</td></tr>
         
          <tr> 
            <td rowspan="2"  >&nbsp;中国现代文学经典作品鉴赏 (154)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=80000098&kkhm=2017%E4%B8%8B80000098154" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=80000098&kkhm=2017%E4%B8%8B80000098154" target="_blank">进度表</a></td>			
            <td align="center"></td>
        <td align="center">院选课</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">院选课超星尔雅（联盟课程）</td>					  
        <td align="center">2</td>
            <td align="center">32</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>	
          </tr>
         
          <tr height="25"><td align="left" colspan="10">★备注：第4周上平台注册学习第14周完成在线学习</td></tr>
         
          <tr> 
            <td  >&nbsp;大学物理实验（上） (3)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=06000162&kkhm=2017%E4%B8%8B06000162003" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=06000162&kkhm=2017%E4%B8%8B06000162003" target="_blank">进度表</a></td>			
            <td align="center">物理实验室</td>
        <td align="center">实践环节</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">3班 周1 7、8节(单)</td>					  
        <td align="center">.5</td>
            <td align="center">15</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center">03～14</td>	
          </tr>
         
          <tr> 
            <td  >&nbsp;高级语言程序设计(C语言)实验 (1)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=16999604&kkhm=2017%E4%B8%8B16999604001" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=16999604&kkhm=2017%E4%B8%8B16999604001" target="_blank">进度表</a></td>			
            <td align="center">冯新</td>
        <td align="center">实践环节</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">1班</td>					  
        <td align="center">2.5</td>
            <td align="center">44</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>	
          </tr>
         
          <tr> 
            <td rowspan="2"  >&nbsp;数字电路与逻辑设计实验 (1)班</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=10111603&kkhm=2017%E4%B8%8B10111603001" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=10111603&kkhm=2017%E4%B8%8B10111603001" target="_blank">进度表</a></td>			
            <td align="center">阴爱英</td>
        <td align="center">实践环节</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">2017级计算机1</td>					  
        <td align="center">1.5</td>
            <td align="center"></td>
            <td align="center">√</td>
            <td align="center"></td>
            <td align="center">10～18</td>	
          </tr>
         
          <tr height="25"><td align="left" colspan="10">★备注：必修，具体时间由任课教师安排</td></tr>
         
          <tr> 
            <td  >&nbsp;思想政治理论课实践(一)</td>
            <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2017%E4%B8%8B&kcdm=07004607&kkhm=2017%E4%B8%8B07004607021" target="_blank">大纲</a>
        /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2017%E4%B8%8B&kcdm=07004607&kkhm=2017%E4%B8%8B07004607021" target="_blank">进度表</a></td>			
            <td align="center">王海霞</td>
        <td align="center">实践环节</td>		  
        <td align="center">正常考考试</td>					  
        <td align="center">2017计算机</td>					  
        <td align="center">1</td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>
            <td align="center"></td>	
          </tr>
         
        </table><font color="#CC3333">
      </font>
      </td>
      <td valign="top">
    
    <table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
          <tr  height="30"> 
            <td align="center">
              星期<br>
              节次 </td>
            <td align="center">一</td>
            <td align="center">二</td>
            <td align="center">三</td>
            <td align="center">四</td>
            <td align="center">五</td>
        
          </tr>
          
          
          <tr id="tr1"> 
            <td align="center">1</td>
            
            <td align="center" rowspan=2 id="11">大学英语（二）(20)班<br>[双][电机楼502]</td>
            
            <td align="center" rowspan=2 id="12">高级语言程序设计(C语言)(1)班<br>[电机楼601]</td>
            
            <td align="center" rowspan=2 id="13">高等数学（一）下(7)班<br>[东教101]</td>
            
            <td align="center" rowspan=2 id="14">高等数学（一）下(7)班<br>[双][化工316]</td>
            
            <td id="15">&nbsp;</td>
            
          </tr>
          
          <tr id="tr2"> 
            <td align="center">2</td>
            
            <td id="25">&nbsp;</td>
            
          </tr>
          
          <tr id="tr3"> 
            <td align="center">3</td>
            
            <td align="center" rowspan=2 id="31">高等数学（一）下(7)班<br>[东教101]</td>
            
            <td align="center" rowspan=2 id="32">大学物理（上）(9)班<br>[机北104]</td>
            
            <td align="center" rowspan=2 id="33">数字电路与逻辑设计(1)班<br>[化工317]</td>
            
            <td id="34">&nbsp;</td>
            
            <td id="35">&nbsp;</td>
            
          </tr>
          
          <tr id="tr4"> 
            <td align="center">4</td>
            
            <td id="44">&nbsp;</td>
            
            <td id="45">&nbsp;</td>
            
          </tr>
          
          <tr id="tr5"> 
            <td align="center">5</td>
            
            <td align="center" rowspan=2 id="51">数字电路与逻辑设计(1)班<br>[化工314]</td>
            
            <td align="center" rowspan=2 id="52">体育（二）(16)班<br>[体育场]</td>
            
            <td id="53">&nbsp;</td>
            
            <td align="center" rowspan=2 id="54">大学英语（二）(20)班<br>[地矿206]</td>
            
            <td align="center" rowspan=2 id="55">高级语言程序设计(C语言)(1)班<br>[化工316]</td>
            
          </tr>
          
          <tr id="tr6"> 
            <td align="center">6</td>
            
            <td id="63">&nbsp;</td>
            
          </tr>
          
          <tr id="tr7"> 
            <td align="center">7</td>
            
            <td align="center" rowspan=2 id="71">大学物理实验（上）(3)班<br>[单][电机楼四楼大厅]</td>
            
            <td id="72">&nbsp;</td>
            
            <td align="center" rowspan=2 id="73">高级语言程序设计(C语言)(1)班<br>[双][电机楼601]<br>高级语言程序设计(C语言)(1)班<br>[单][创意101]</td>
            
            <td id="74">&nbsp;</td>
            
            <td id="75">&nbsp;</td>
            
          </tr>
          
          <tr id="tr8"> 
            <td align="center">8</td>
            
            <td id="82">&nbsp;</td>
            
            <td id="84">&nbsp;</td>
            
            <td id="85">&nbsp;</td>
            
          </tr>
          
          <tr id="tr9"> 
            <td align="center">9</td>
            
            <td align="center" rowspan=2 id="91">中国近现代史纲要(4)班<br>[机北406]</td>
            
            <td id="92">&nbsp;</td>
            
            <td align="center" rowspan=3 id="93">大学英语四级考试辅导(30)班<br>[东教201]</td>
            
            <td align="center" rowspan=2 id="94">形势与政策（上）(16)班<br>[东教406]</td>
            
            <td id="95">&nbsp;</td>
            
          </tr>
          
          <tr id="tr10"> 
            <td align="center">10</td>
            
            <td id="102">&nbsp;</td>
            
            <td id="105">&nbsp;</td>
            
          </tr>
          
          <tr id="tr11"> 
            <td align="center">11</td>
            
            <td id="111">&nbsp;</td>
            
            <td id="112">&nbsp;</td>
            
            <td id="114">&nbsp;</td>
            
            <td id="115">&nbsp;</td>
            
          </tr>
          
        </table></td>
    </tr>
  </table>
    
  </body>
  </html>
  """

        /**
         * 2017 计科完整课表 预期结果
         */
        val cs2017CoursesExpected: String
            get() = "[Course{couID=10, onlyID=0, couName='中国现代文学经典作品鉴赏 (154)班', couRoom='null', couTeacher='超星尔雅（联盟课程）', couWeek=null, couStartNode=null, couEndNode=null, couWeekType=3, couStartWeek=null, couEndWeek=null, couColor=null}, " +
                    "Course{couID=1, onlyID=1, couName='大学英语（二） (20)班', couRoom='电机楼502', couTeacher='庄星来', couWeek=1, couStartNode=1, couEndNode=2, couWeekType=2, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=3, onlyID=2, couName='高级语言程序设计(C语言) (1)班', couRoom='电机楼601', couTeacher='冯新', couWeek=2, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=2, onlyID=3, couName='高等数学（一）下 (7)班', couRoom='东教101', couTeacher='侯远', couWeek=3, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=2, onlyID=4, couName='高等数学（一）下 (7)班', couRoom='化工316', couTeacher='侯远', couWeek=4, couStartNode=1, couEndNode=2, couWeekType=2, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=2, onlyID=5, couName='高等数学（一）下 (7)班', couRoom='东教101', couTeacher='侯远', couWeek=1, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=0, onlyID=6, couName='大学物理（上） (9)班', couRoom='机北104', couTeacher='孙磊', couWeek=2, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=2, couEndWeek=17, couColor=null}, " +
                    "Course{couID=7, onlyID=7, couName='数字电路与逻辑设计 (1)班', couRoom='化工317', couTeacher='阴爱英', couWeek=3, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=13, couColor=null}, " +
                    "Course{couID=7, onlyID=8, couName='数字电路与逻辑设计 (1)班', couRoom='化工314', couTeacher='阴爱英', couWeek=1, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=13, couColor=null}, " +
                    "Course{couID=4, onlyID=9, couName='体育（二） (16)班', couRoom='体育场', couTeacher='卞贞坤', couWeek=2, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=2, couEndWeek=15, couColor=null}, " +
                    "Course{couID=1, onlyID=10, couName='大学英语（二） (20)班', couRoom='地矿206', couTeacher='庄星来', couWeek=4, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                    "Course{couID=3, onlyID=11, couName='高级语言程序设计(C语言) (1)班', couRoom='化工316', couTeacher='冯新', couWeek=5, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=11, onlyID=12, couName='大学物理实验（上） (3)班', couRoom='电机楼四楼大厅', couTeacher='物理实验室', couWeek=1, couStartNode=7, couEndNode=8, couWeekType=1, couStartWeek=3, couEndWeek=14, couColor=null}, " +
                    "Course{couID=3, onlyID=13, couName='高级语言程序设计(C语言) (1)班', couRoom='电机楼601', couTeacher='冯新', couWeek=3, couStartNode=7, couEndNode=8, couWeekType=2, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=3, onlyID=14, couName='高级语言程序设计(C语言) (1)班', couRoom='创意101', couTeacher='冯新', couWeek=3, couStartNode=7, couEndNode=8, couWeekType=1, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=6, onlyID=15, couName='中国近现代史纲要 (4)班', couRoom='机北406', couTeacher='郑恒鑫', couWeek=1, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=1, couEndWeek=13, couColor=null}, " +
                    "Course{couID=8, onlyID=16, couName='大学英语四级考试辅导 (30)班', couRoom='东教201', couTeacher='谢强英', couWeek=3, couStartNode=9, couEndNode=11, couWeekType=0, couStartWeek=3, couEndWeek=15, couColor=null}, " +
                    "Course{couID=5, onlyID=17, couName='形势与政策（上） (16)班', couRoom='东教406', couTeacher='陈文福,魏渊,林筠颖,吴迪', couWeek=4, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=4, couEndWeek=10, couColor=null}]"

        /**
         * 2019 计科实验班完整课表
         */
        val experimentalCourses: String
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
<style media=print>
.Noprint{display:none;}
.PageNext{page-break-after: always;}
</style>

<style>
<!-- 
table {
	font-size: 10pt;
}
td {
	font-size: 9pt;
}
.button {font-family: "宋体";font-size: 9pt;color: #00006a; height: 19}
-->
</style>

<link href="../inc/style.css" rel="stylesheet" type="text/css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
  <table width="100%" border="0" cellspacing="0" id="w" class="Noprint">
  <tr><td align="center">
<form name="form" method="post" action="kb_xs.asp">
	 <input name="menu_no" type="hidden" value="">
	 
&nbsp;查询学期：<input name="xn" type="text" size="4" value="2019">学年 
		<select name="xq">
			<option value="下">下</option> 
			<option value=""></option>  	
			<option value="上">上</option>
			<option value="下">下</option>
		</select>
		学期 <input type="submit" name="Submit" value="查询" class="button">
		&nbsp;&nbsp;<input name="print" type="button" value=" 打印 " onClick="javascript:window.print();" class="button">			 
</form>
</td></tr></table>	

<div align="center"><strong>福州大学至诚学院 2019下学期实验班同学课程表</strong>(2020-5-28 10:52:09)</div>
<table width="880" cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
<!--      <td valign="top"><table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">-->
    <td valign="top"><table width="100%" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">课程名称</td>
          <td align="center">大纲/进度表</td>
          <td align="center">任课教师</td>
		  <td align="center">选修类型</td>
		  <td align="center">考试类别</td>		  
		  <td align="center">班级</td>		  
		  <td align="center">学分</td>
          <td align="center">总<br>学<br>时 </td>
          <td align="center">周<br>学<br>时 </td>
          <td align="center">实<br>验<br>学<br>时 </td>
          <td align="center">起讫时间<br>周序<br>(星期)</td>
        </tr>
        
        <tr> 
          <td  >&nbsp;形势与政策（六） (9)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106013" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106013" target="_blank">进度表</a></td>			
          <td align="center">潘曦</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">9班</td>					  
		  <td align="center">.5</td>
          <td align="center">8</td>
          <td align="center">2</td>
          <td align="center"></td>
          <td align="center">11～14</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;计算机网络 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922214&kkhm=2019%E4%B8%8B17922214001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922214&kkhm=2019%E4%B8%8B17922214001" target="_blank">进度表</a></td>			
          <td align="center">黄巧云</td>
		  <td align="center">专业基础</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3.5</td>
          <td align="center">56</td>
          <td align="center">4</td>
          <td align="center">8</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：8学时实践课需去大学城</td></tr>
       
        <tr> 
          <td  >&nbsp;高级数据库技术 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922305&kkhm=2019%E4%B8%8B17922305001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922305&kkhm=2019%E4%B8%8B17922305001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向1</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">4</td>
          <td align="center">24</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;数据挖掘与分析 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922306&kkhm=2019%E4%B8%8B17922306001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922306&kkhm=2019%E4%B8%8B17922306001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向1</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">10</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;证券投资学 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922312&kkhm=2019%E4%B8%8B17922312001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922312&kkhm=2019%E4%B8%8B17922312001" target="_blank">进度表</a></td>			
          <td align="center">冯玮</td>
		  <td align="center">专业方向2</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">4</td>
          <td align="center">18</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;大数据计算 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18111406&kkhm=2019%E4%B8%8B18111406001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18111406&kkhm=2019%E4%B8%8B18111406001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">16</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;金融风控与大数据 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922425&kkhm=2019%E4%B8%8B17922425001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922425&kkhm=2019%E4%B8%8B17922425001" target="_blank">进度表</a></td>			
          <td align="center">张希君</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2.5</td>
          <td align="center">40</td>
          <td align="center">3</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;软件工程 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922414&kkhm=2019%E4%B8%8B17922414001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922414&kkhm=2019%E4%B8%8B17922414001" target="_blank">进度表</a></td>			
          <td align="center">张栋</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">3</td>
          <td align="center">18</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;数据可视化与可视分析 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922404&kkhm=2019%E4%B8%8B17922404001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922404&kkhm=2019%E4%B8%8B17922404001" target="_blank">进度表</a></td>			
          <td align="center">沈炎斌</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">16</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;云计算与数据中心 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922405&kkhm=2019%E4%B8%8B17922405001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922405&kkhm=2019%E4%B8%8B17922405001" target="_blank">进度表</a></td>			
          <td align="center">林庆新</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">12</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;大数据计算实践 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18922602&kkhm=2019%E4%B8%8B18922602001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18922602&kkhm=2019%E4%B8%8B18922602001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;大数据综合应用案例实训 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922662&kkhm=2019%E4%B8%8B17922662001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922662&kkhm=2019%E4%B8%8B17922662001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;互联网金融产品运营实践 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922640&kkhm=2019%E4%B8%8B17922640001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922640&kkhm=2019%E4%B8%8B17922640001" target="_blank">进度表</a></td>			
          <td align="center">洪防璇</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">48</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;金融仿真模拟交易系统 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922639&kkhm=2019%E4%B8%8B17922639001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922639&kkhm=2019%E4%B8%8B17922639001" target="_blank">进度表</a></td>			
          <td align="center">张希君,郭鸿琼</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">48</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数据挖掘应用实践 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922661&kkhm=2019%E4%B8%8B17922661001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922661&kkhm=2019%E4%B8%8B17922661001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：差4学时另补</td></tr>
       
        <tr> 
          <td  >&nbsp;证券投资模拟实验 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922638&kkhm=2019%E4%B8%8B17922638001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922638&kkhm=2019%E4%B8%8B17922638001" target="_blank">进度表</a></td>			
          <td align="center">冯玮</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">48</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
      </table><font color="#CC3333">
	  </font>
	  </td>
    <td valign="top">
	
	<table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">
            星期<br>
            节次 </td>
          <td align="center">一</td>
          <td align="center">二</td>
          <td align="center">三</td>
          <td align="center">四</td>
          <td align="center">五</td>
		  
          <td align="center">六</td>
		  
          <td align="center">日</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center">1</td>
          
          <td align="center" rowspan=4 id="11">高级数据库技术(实验班)班<br>[网络教学]<br>(01-12周)</td>
          
          <td align="center" rowspan=2 id="12">证券投资学(实验班)班<br>[网络教学]<br>(01-12周)<br>证券投资模拟实验(实验班)班<br>[网络教学]<br>[1~4节]<br>(13-18周)</td>
          
          <td align="center" rowspan=4 id="13">数据挖掘与分析(实验班)班<br>[网络教学]<br>(01-08周)<br>数据挖掘应用实践(实验班)班<br>[网络教学]<br>(09-15周)<br>数据挖掘应用实践(实验班)班<br>[网络教学]<br>(16-16周)</td>
          
          <td align="center" rowspan=4 id="14">大数据计算(实验班)班<br>[网络教学]<br>(01-08周)<br>大数据计算实践(实验班)班<br>[网络教学]<br>(09-15周)<br>大数据计算实践(实验班)班<br>[网络教学]<br>[1~2节]<br>(16-16周)</td>
          
          <td align="center" rowspan=4 id="15">云计算与数据中心(实验班)班<br>[网络教学]<br>(01-04周)<br>大数据综合应用案例实训(实验班)班<br>[网络教学]<br>(05-12周)<br>大数据综合应用案例实训(实验班)班<br>[3~4节]<br>[网络教学]<br>(14-14周)</td>
          
          <td align="center" rowspan=2 id="16">数据可视化与可视分析(实验班)班<br>[网络教学]<br>(15-18周)</td>
          
          <td id="17">&nbsp;</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center">2</td>
          
          <td id="27">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center">3</td>
          
          <td align="center" rowspan=2 id="32">证券投资模拟实验(实验班)班<br>[网络教学]<br>(01-12周)</td>
          
          <td id="36">&nbsp;</td>
          
          <td align="center" rowspan=2 id="37">形势与政策（六）(9)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center">4</td>
          
          <td id="46">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center">5</td>
          
          <td align="center" rowspan=2 id="51">软件工程(实验班)班<br>[网络教学]<br>(01-12周)<br>数据可视化与可视分析(实验班)班<br>[网络教学]<br>[5~8节]<br>(15-18周)</td>
          
          <td align="center" rowspan=3 id="52">计算机网络(实验班)班<br>[网络教学]<br>(01-06周)<br>计算机网络(实验班)班<br>[网络教学]<br>[5~8节]<br>(07-08周)<br>计算机网络(实验班)班<br>[网络教学]<br>[5~6节]<br>(09-13周)</td>
          
          <td align="center" rowspan=4 id="53">软件工程(实验班)班<br>[网络教学]<br>(05-08周)<br>软件工程(实验班)班<br>[网络教学]<br>(10-10周)<br>软件工程(实验班)班<br>[网络教学]<br>(13-13周)<br>云计算与数据中心(实验班)班<br>[网络教学]<br>(01-04周)</td>
          
          <td align="center" rowspan=2 id="54">金融风控与大数据(实验班)班<br>[网络教学]<br>(01-09周)<br>金融风控与大数据(实验班)班<br>[网络教学]<br>[5~8节]<br>(10-14周)</td>
          
          <td align="center" rowspan=2 id="55">证券投资学(实验班)班<br>[网络教学]<br>(01-12周)</td>
          
          <td align="center" rowspan=4 id="56">互联网金融产品运营实践(实验班)班<br>[网络教学]<br>(11-20周)</td>
          
          <td id="57">&nbsp;</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center">6</td>
          
          <td id="67">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center">7</td>
          
          <td id="71">&nbsp;</td>
          
          <td id="74">&nbsp;</td>
          
          <td align="center" rowspan=2 id="75">计算机网络(实验班)班<br>[网络教学]<br>(09-12周)</td>
          
          <td id="77">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center">8</td>
          
          <td id="81">&nbsp;</td>
          
          <td id="82">&nbsp;</td>
          
          <td id="84">&nbsp;</td>
          
          <td id="87">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center">9</td>
          
          <td id="91">&nbsp;</td>
          
          <td align="center" rowspan=3 id="92">金融仿真模拟交易系统(实验班)班<br>[网络教学]<br>(01-16周)</td>
          
          <td id="93">&nbsp;</td>
          
          <td align="center" rowspan=2 id="94">计算机网络(实验班)班<br>[网络教学]<br>(07-12周)</td>
          
          <td id="95">&nbsp;</td>
          
          <td id="96">&nbsp;</td>
          
          <td id="97">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center">10</td>
          
          <td id="101">&nbsp;</td>
          
          <td id="103">&nbsp;</td>
          
          <td id="105">&nbsp;</td>
          
          <td id="106">&nbsp;</td>
          
          <td id="107">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center">11</td>
          
          <td id="111">&nbsp;</td>
          
          <td id="113">&nbsp;</td>
          
          <td id="114">&nbsp;</td>
          
          <td id="115">&nbsp;</td>
          
          <td id="116">&nbsp;</td>
          
          <td id="117">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>
"""

        /**
         * 2019 计科实验班完整课表 预期结果
         */
        val experimentalCoursesExpected: String
            get() = "[Course{couID=2, onlyID=0, couName='高级数据库技术 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=1, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                    "Course{couID=4, onlyID=1, couName='证券投资学 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=2, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                    "Course{couID=15, onlyID=2, couName='证券投资模拟实验 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=2, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=13, couEndWeek=18, couColor=null}, " +
                    "Course{couID=3, onlyID=3, couName='数据挖掘与分析 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                    "Course{couID=14, onlyID=4, couName='数据挖掘应用实践 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=9, couEndWeek=15, couColor=null}, " +
                    "Course{couID=14, onlyID=5, couName='数据挖掘应用实践 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=16, couEndWeek=16, couColor=null}, " +
                    "Course{couID=5, onlyID=6, couName='大数据计算 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                    "Course{couID=10, onlyID=7, couName='大数据计算实践 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=9, couEndWeek=15, couColor=null}, " +
                    "Course{couID=10, onlyID=8, couName='大数据计算实践 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=16, couEndWeek=16, couColor=null}, " +
                    "Course{couID=9, onlyID=9, couName='云计算与数据中心 (实验班)班', couRoom='网络教学', couTeacher='林庆新', couWeek=5, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                    "Course{couID=11, onlyID=10, couName='大数据综合应用案例实训 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=5, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=5, couEndWeek=12, couColor=null}, " +
                    "Course{couID=11, onlyID=11, couName='大数据综合应用案例实训 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=5, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=14, couEndWeek=14, couColor=null}, " +
                    "Course{couID=8, onlyID=12, couName='数据可视化与可视分析 (实验班)班', couRoom='网络教学', couTeacher='沈炎斌', couWeek=6, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=15, couEndWeek=18, couColor=null}, " +
                    "Course{couID=15, onlyID=13, couName='证券投资模拟实验 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=2, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                    "Course{couID=0, onlyID=14, couName='形势与政策（六） (9)班', couRoom='网络教学', couTeacher='潘曦', couWeek=7, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=11, couEndWeek=14, couColor=null}, " +
                    "Course{couID=7, onlyID=15, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=1, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                    "Course{couID=8, onlyID=16, couName='数据可视化与可视分析 (实验班)班', couRoom='网络教学', couTeacher='沈炎斌', couWeek=1, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=15, couEndWeek=18, couColor=null}, " +
                    "Course{couID=1, onlyID=17, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=2, couStartNode=5, couEndNode=7, couWeekType=0, couStartWeek=1, couEndWeek=6, couColor=null}, " +
                    "Course{couID=1, onlyID=18, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=2, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=7, couEndWeek=8, couColor=null}, " +
                    "Course{couID=1, onlyID=19, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=2, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=9, couEndWeek=13, couColor=null}, " +
                    "Course{couID=7, onlyID=20, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=5, couEndWeek=8, couColor=null}, " +
                    "Course{couID=7, onlyID=21, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=10, couEndWeek=10, couColor=null}, " +
                    "Course{couID=7, onlyID=22, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=13, couEndWeek=13, couColor=null}, " +
                    "Course{couID=9, onlyID=23, couName='云计算与数据中心 (实验班)班', couRoom='网络教学', couTeacher='林庆新', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                    "Course{couID=6, onlyID=24, couName='金融风控与大数据 (实验班)班', couRoom='网络教学', couTeacher='张希君', couWeek=4, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=9, couColor=null}, " +
                    "Course{couID=6, onlyID=25, couName='金融风控与大数据 (实验班)班', couRoom='网络教学', couTeacher='张希君', couWeek=4, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=10, couEndWeek=14, couColor=null}, " +
                    "Course{couID=4, onlyID=26, couName='证券投资学 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=5, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                    "Course{couID=12, onlyID=27, couName='互联网金融产品运营实践 (实验班)班', couRoom='网络教学', couTeacher='洪防璇', couWeek=6, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=11, couEndWeek=20, couColor=null}, " +
                    "Course{couID=1, onlyID=28, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=5, couStartNode=7, couEndNode=8, couWeekType=0, couStartWeek=9, couEndWeek=12, couColor=null}, " +
                    "Course{couID=13, onlyID=29, couName='金融仿真模拟交易系统 (实验班)班', couRoom='网络教学', couTeacher='张希君,郭鸿琼', couWeek=2, couStartNode=9, couEndNode=11, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                    "Course{couID=1, onlyID=30, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=4, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=7, couEndWeek=12, couColor=null}]"
    }

    /**
     * 马同学完整课表
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
<style media=print>
.Noprint{display:none;}
.PageNext{page-break-after: always;}
</style>

<style>
<!-- 
table {
	font-size: 10pt;
}
td {
	font-size: 9pt;
}
.button {font-family: "宋体";font-size: 9pt;color: #00006a; height: 19}
-->
</style>

<link href="../inc/style.css" rel="stylesheet" type="text/css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
  <table width="100%" border="0" cellspacing="0" id="w" class="Noprint">
  <tr><td align="center">
<form name="form" method="post" action="kb_xs.asp">
	 <input name="menu_no" type="hidden" value="">
	 
&nbsp;查询学期：<input name="xn" type="text" size="4" value="2019">学年 
		<select name="xq">
			<option value="下">下</option> 
			<option value=""></option>  	
			<option value="上">上</option>
			<option value="下">下</option>
		</select>
		学期 <input type="submit" name="Submit" value="查询" class="button">
		&nbsp;&nbsp;<input name="print" type="button" value=" 打印 " onClick="javascript:window.print();" class="button">			 
</form>
</td></tr></table>	

<div align="center"><strong>福州大学至诚学院 2019下学期马同学课程表</strong>(2020-5-28 20:10:38)</div>
<table width="880" cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
<!--      <td valign="top"><table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">-->
    <td valign="top"><table width="100%" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">课程名称</td>
          <td align="center">大纲/进度表</td>
          <td align="center">任课教师</td>
		  <td align="center">选修类型</td>
		  <td align="center">考试类别</td>		  
		  <td align="center">班级</td>		  
		  <td align="center">学分</td>
          <td align="center">总<br>学<br>时 </td>
          <td align="center">周<br>学<br>时 </td>
          <td align="center">实<br>验<br>学<br>时 </td>
          <td align="center">起讫时间<br>周序<br>(星期)</td>
        </tr>
        
        <tr> 
          <td  >&nbsp;大学物理（上） (15)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06000118&kkhm=2019%E4%B8%8B06000118015" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06000118&kkhm=2019%E4%B8%8B06000118015" target="_blank">进度表</a></td>			
          <td align="center">孙钦钦</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">第一次重修</td>					  
		  <td align="center">15班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">2</td>
          <td align="center"></td>
          <td align="center">01～17</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;概率论与数理统计 (普10)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=09000102&kkhm=2019%E4%B8%8B09000102010" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=09000102&kkhm=2019%E4%B8%8B09000102010" target="_blank">进度表</a></td>			
          <td align="center">杨培鉴</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">第一次重修</td>					  
		  <td align="center">普10</td>					  
		  <td align="center">3</td>
          <td align="center">54</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">01～15</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：周三晚答疑时间18:30~20:00</td></tr>
       
        <tr> 
          <td  >&nbsp;形势与政策（六） (6)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106010" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106010" target="_blank">进度表</a></td>			
          <td align="center">韩晞婷</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">6班</td>					  
		  <td align="center">.5</td>
          <td align="center">8</td>
          <td align="center">2</td>
          <td align="center"></td>
          <td align="center">11～14</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;高级数据库技术 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111306&kkhm=2019%E4%B8%8B16111306001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111306&kkhm=2019%E4%B8%8B16111306001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向2</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">4</td>
          <td align="center">24</td>
          <td align="center">01～13</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：022</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数据挖掘与分析 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111405&kkhm=2019%E4%B8%8B16111405001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111405&kkhm=2019%E4%B8%8B16111405001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向2</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">4</td>
          <td align="center">10</td>
          <td align="center">01～08</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：022</td></tr>
       
        <tr> 
          <td  >&nbsp;大数据应用开发 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111308&kkhm=2019%E4%B8%8B16111308001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111308&kkhm=2019%E4%B8%8B16111308001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">4</td>
          <td align="center">16</td>
          <td align="center">01～08</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;软件工程 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=06111303&kkhm=2019%E4%B8%8B06111303001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=06111303&kkhm=2019%E4%B8%8B06111303001" target="_blank">进度表</a></td>			
          <td align="center">张栋</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">2</td>
          <td align="center">18</td>
          <td align="center">01～12</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：留两学时线下</td></tr>
       
        <tr> 
          <td  >&nbsp;数据可视化与可视分析 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17111403&kkhm=2019%E4%B8%8B17111403001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17111403&kkhm=2019%E4%B8%8B17111403001" target="_blank">进度表</a></td>			
          <td align="center">沈炎斌</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">16</td>
          <td align="center">15～18</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;云计算与数据中心 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111407&kkhm=2019%E4%B8%8B16111407002" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111407&kkhm=2019%E4%B8%8B16111407002" target="_blank">进度表</a></td>			
          <td align="center">林庆新</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">8</td>
          <td align="center">12</td>
          <td align="center">01～04</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;大数据应用开发实践 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=16111603&kkhm=2019%E4%B8%8B16111603001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=16111603&kkhm=2019%E4%B8%8B16111603001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">09～16</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：选修</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;大数据综合应用案例实训 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17111607&kkhm=2019%E4%B8%8B17111607001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17111607&kkhm=2019%E4%B8%8B17111607001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">05～11</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：选修</td></tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数据挖掘应用实践 (1)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17111606&kkhm=2019%E4%B8%8B17111606001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17111606&kkhm=2019%E4%B8%8B17111606001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级计算机1</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">√</td>
          <td align="center">4</td>
          <td align="center">09～15</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：选修</td></tr>
       
      </table><font color="#CC3333">
	  </font>
	  </td>
    <td valign="top">
	
	<table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">
            星期<br>
            节次 </td>
          <td align="center">一</td>
          <td align="center">二</td>
          <td align="center">三</td>
          <td align="center">四</td>
          <td align="center">五</td>
		  
          <td align="center">六</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center">1</td>
          
          <td align="center" rowspan=4 id="11">高级数据库技术(1)班<br>[网络教学]</td>
          
          <td id="12">&nbsp;</td>
          
          <td align="center" rowspan=4 id="13">数据挖掘与分析(1)班<br>[网络教学]<br>数据挖掘应用实践(1)班<br>[网络教学]<br>数据挖掘应用实践(1)班<br>[网络教学]<br>[1~2节]<br>(16-16周)</td>
          
          <td id="14">&nbsp;</td>
          
          <td align="center" rowspan=4 id="15">云计算与数据中心(1)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="16">数据可视化与可视分析(1)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center">2</td>
          
          <td id="22">&nbsp;</td>
          
          <td id="24">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center">3</td>
          
          <td align="center" rowspan=2 id="32">大学物理（上）(15)班<br>[网络教学]<br>形势与政策（六）(6)班<br>[网络教学]</td>
          
          <td id="34">&nbsp;</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center">4</td>
          
          <td id="44">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center">5</td>
          
          <td align="center" rowspan=2 id="51">软件工程(1)班<br>[网络教学]<br>数据可视化与可视分析(1)班<br>[网络教学]<br>[5~8节]</td>
          
          <td align="center" rowspan=4 id="52">大数据应用开发(1)班<br>[网络教学]<br>大数据应用开发实践(1)班<br>[网络教学]<br>大数据应用开发实践(1)班<br>[网络教学]<br>[5~6节]<br>(17-17周)</td>
          
          <td align="center" rowspan=4 id="53">软件工程(1)班<br>[网络教学]<br>(05-08周)<br>软件工程(1)班<br>[网络教学]<br>(10-10周)<br>软件工程(1)班<br>[网络教学]<br>(13-13周)<br>云计算与数据中心(1)班<br>[网络教学]</td>
          
          <td align="center" rowspan=4 id="54">大数据综合应用案例实训(1)班<br>[网络教学]<br>大数据综合应用案例实训(1)班<br>[网络教学]<br>[5~6节]<br>(12-12周)</td>
          
          <td id="55">&nbsp;</td>
          
          <td align="center" rowspan=2 id="56">概率论与数理统计(普10)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center">6</td>
          
          <td id="65">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center">7</td>
          
          <td id="71">&nbsp;</td>
          
          <td id="75">&nbsp;</td>
          
          <td id="76">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center">8</td>
          
          <td id="81">&nbsp;</td>
          
          <td id="85">&nbsp;</td>
          
          <td id="86">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center">9</td>
          
          <td id="91">&nbsp;</td>
          
          <td id="92">&nbsp;</td>
          
          <td align="center" rowspan=2 id="93">概率论与数理统计(普10)班<br>[网络教学]</td>
          
          <td id="94">&nbsp;</td>
          
          <td id="95">&nbsp;</td>
          
          <td id="96">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center">10</td>
          
          <td id="101">&nbsp;</td>
          
          <td id="102">&nbsp;</td>
          
          <td id="104">&nbsp;</td>
          
          <td id="105">&nbsp;</td>
          
          <td id="106">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center">11</td>
          
          <td id="111">&nbsp;</td>
          
          <td id="112">&nbsp;</td>
          
          <td id="113">&nbsp;</td>
          
          <td id="114">&nbsp;</td>
          
          <td id="115">&nbsp;</td>
          
          <td id="116">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>
"""

    /**
     * 马同学完整课表 预期结果
     */
    private val maCoursesExpected: String
        get() = "[Course{couID=3, onlyID=0, couName='高级数据库技术 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=1, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=13, couColor=null}, " +
                "Course{couID=4, onlyID=1, couName='数据挖掘与分析 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                "Course{couID=11, onlyID=2, couName='数据挖掘应用实践 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=9, couEndWeek=15, couColor=null}, " +
                "Course{couID=11, onlyID=3, couName='数据挖掘应用实践 (1)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=16, couEndWeek=16, couColor=null}, " +
                "Course{couID=8, onlyID=4, couName='云计算与数据中心 (1)班', couRoom='网络教学', couTeacher='林庆新', couWeek=5, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                "Course{couID=7, onlyID=5, couName='数据可视化与可视分析 (1)班', couRoom='网络教学', couTeacher='沈炎斌', couWeek=6, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=15, couEndWeek=18, couColor=null}, " +
                "Course{couID=0, onlyID=6, couName='大学物理（上） (15)班', couRoom='网络教学', couTeacher='孙钦钦', couWeek=2, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=17, couColor=null}, " +
                "Course{couID=2, onlyID=7, couName='形势与政策（六） (6)班', couRoom='网络教学', couTeacher='韩晞婷', couWeek=2, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=11, couEndWeek=14, couColor=null}, " +
                "Course{couID=6, onlyID=8, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=1, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                "Course{couID=7, onlyID=9, couName='数据可视化与可视分析 (1)班', couRoom='网络教学', couTeacher='沈炎斌', couWeek=1, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=15, couEndWeek=18, couColor=null}, " +
                "Course{couID=5, onlyID=10, couName='大数据应用开发 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=2, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                "Course{couID=9, onlyID=11, couName='大数据应用开发实践 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=2, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=9, couEndWeek=16, couColor=null}, " +
                "Course{couID=9, onlyID=12, couName='大数据应用开发实践 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=2, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=17, couEndWeek=17, couColor=null}, " +
                "Course{couID=6, onlyID=13, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=5, couEndWeek=8, couColor=null}, " +
                "Course{couID=6, onlyID=14, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=10, couEndWeek=10, couColor=null}, " +
                "Course{couID=6, onlyID=15, couName='软件工程 (1)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=13, couEndWeek=13, couColor=null}, " +
                "Course{couID=8, onlyID=16, couName='云计算与数据中心 (1)班', couRoom='网络教学', couTeacher='林庆新', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                "Course{couID=10, onlyID=17, couName='大数据综合应用案例实训 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=5, couEndWeek=11, couColor=null}, " +
                "Course{couID=10, onlyID=18, couName='大数据综合应用案例实训 (1)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=12, couEndWeek=12, couColor=null}, " +
                "Course{couID=1, onlyID=19, couName='概率论与数理统计 (普10)班', couRoom='网络教学', couTeacher='杨培鉴', couWeek=6, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=15, couColor=null}, " +
                "Course{couID=1, onlyID=20, couName='概率论与数理统计 (普10)班', couRoom='网络教学', couTeacher='杨培鉴', couWeek=3, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=1, couEndWeek=15, couColor=null}]"

    /**
     * 有重修课程的实验班
     */
    private val relearnCourses: String
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
<style media=print>
.Noprint{display:none;}
.PageNext{page-break-after: always;}
</style>

<style>
<!-- 
table {
	font-size: 10pt;
}
td {
	font-size: 9pt;
}
.button {font-family: "宋体";font-size: 9pt;color: #00006a; height: 19}
-->
</style>

<link href="../inc/style.css" rel="stylesheet" type="text/css">
</head>

<BODY onbeforeprint="w.style.display='none';"  onafterprint="w.style.display='';">
  <table width="100%" border="0" cellspacing="0" id="w" class="Noprint">
  <tr><td align="center">
<form name="form" method="post" action="kb_xs.asp">
	 <input name="menu_no" type="hidden" value="">
	 
&nbsp;查询学期：<input name="xn" type="text" size="4" value="2019">学年 
		<select name="xq">
			<option value="下">下</option> 
			<option value=""></option>  	
			<option value="上">上</option>
			<option value="下">下</option>
		</select>
		学期 <input type="submit" name="Submit" value="查询" class="button">
		&nbsp;&nbsp;<input name="print" type="button" value=" 打印 " onClick="javascript:window.print();" class="button">			 
</form>
</td></tr></table>	

<div align="center"><strong>福州大学至诚学院 2019下学期吴同学课程表</strong>(2020-5-28 21:24:59)</div>
<table width="880" cellspacing="0" cellpadding="0" align="center" border="0" bordercolor="#111111">
  <tr> 
<!--      <td valign="top"><table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">-->
    <td valign="top"><table width="100%" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">课程名称</td>
          <td align="center">大纲/进度表</td>
          <td align="center">任课教师</td>
		  <td align="center">选修类型</td>
		  <td align="center">考试类别</td>		  
		  <td align="center">班级</td>		  
		  <td align="center">学分</td>
          <td align="center">总<br>学<br>时 </td>
          <td align="center">周<br>学<br>时 </td>
          <td align="center">实<br>验<br>学<br>时 </td>
          <td align="center">起讫时间<br>周序<br>(星期)</td>
        </tr>
        
        <tr> 
          <td rowspan="2"  >&nbsp;概率论与数理统计 (普6)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=09000102&kkhm=2019%E4%B8%8B09000102006" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=09000102&kkhm=2019%E4%B8%8B09000102006" target="_blank">进度表</a></td>			
          <td align="center">项景华</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">第一次重修</td>					  
		  <td align="center">普6</td>					  
		  <td align="center">3</td>
          <td align="center">54</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">01～15</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：周三晚答疑时间18:30~20:00</td></tr>
       
        <tr> 
          <td  >&nbsp;高等数学（一）下 (实验)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=08000102&kkhm=2019%E4%B8%8B08000102001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=08000102&kkhm=2019%E4%B8%8B08000102001" target="_blank">进度表</a></td>			
          <td align="center">陈育栎</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">第二次重修</td>					  
		  <td align="center">2019级综合实验班</td>					  
		  <td align="center">4</td>
          <td align="center">90</td>
          <td align="center">6</td>
          <td align="center"></td>
          <td align="center">01～16</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;线性代数 (6)班<font color='#FF0000'>（替代重修:线性代数（一））</font></td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=15000101&kkhm=2019%E4%B8%8B15000101006" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=15000101&kkhm=2019%E4%B8%8B15000101006" target="_blank">进度表</a></td>			
          <td align="center">郑达艺,曾怀杰</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">第一次重修</td>					  
		  <td align="center">6班</td>					  
		  <td align="center">2</td>
          <td align="center">40</td>
          <td align="center">4</td>
          <td align="center"></td>
          <td align="center">04～13</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;形势与政策（六） (9)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106013" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18000106&kkhm=2019%E4%B8%8B18000106013" target="_blank">进度表</a></td>			
          <td align="center">潘曦</td>
		  <td align="center">公共必修</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">9班</td>					  
		  <td align="center">.5</td>
          <td align="center">8</td>
          <td align="center">2</td>
          <td align="center"></td>
          <td align="center">11～14</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;计算机网络 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922214&kkhm=2019%E4%B8%8B17922214001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922214&kkhm=2019%E4%B8%8B17922214001" target="_blank">进度表</a></td>			
          <td align="center">黄巧云</td>
		  <td align="center">专业基础</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3.5</td>
          <td align="center">56</td>
          <td align="center">4</td>
          <td align="center">8</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：8学时实践课需去大学城</td></tr>
       
        <tr> 
          <td  >&nbsp;高级数据库技术 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922305&kkhm=2019%E4%B8%8B17922305001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922305&kkhm=2019%E4%B8%8B17922305001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向1</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">4</td>
          <td align="center">24</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;数据挖掘与分析 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922306&kkhm=2019%E4%B8%8B17922306001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922306&kkhm=2019%E4%B8%8B17922306001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">专业方向1</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">10</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数字逻辑与计算机组成 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922301&kkhm=2019%E4%B8%8B17922301001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922301&kkhm=2019%E4%B8%8B17922301001" target="_blank">进度表</a></td>			
          <td align="center">黄福明</td>
		  <td align="center">专业方向1</td>		  
		  <td align="center">第一次重修</td>					  
		  <td align="center">2018级综合实验班</td>					  
		  <td align="center">4</td>
          <td align="center">56</td>
          <td align="center">4</td>
          <td align="center">*</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：专业应用方向必修课（计算机科学与技术专业）</td></tr>
       
        <tr> 
          <td  >&nbsp;证券投资学 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922312&kkhm=2019%E4%B8%8B17922312001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922312&kkhm=2019%E4%B8%8B17922312001" target="_blank">进度表</a></td>			
          <td align="center">冯玮</td>
		  <td align="center">专业方向2</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">4</td>
          <td align="center">18</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;大数据计算 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18111406&kkhm=2019%E4%B8%8B18111406001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18111406&kkhm=2019%E4%B8%8B18111406001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">16</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;金融风控与大数据 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922425&kkhm=2019%E4%B8%8B17922425001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922425&kkhm=2019%E4%B8%8B17922425001" target="_blank">进度表</a></td>			
          <td align="center">张希君</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2.5</td>
          <td align="center">40</td>
          <td align="center">3</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;软件工程 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922414&kkhm=2019%E4%B8%8B17922414001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922414&kkhm=2019%E4%B8%8B17922414001" target="_blank">进度表</a></td>			
          <td align="center">张栋</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">3</td>
          <td align="center">48</td>
          <td align="center">3</td>
          <td align="center">18</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;数据可视化与可视分析 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922404&kkhm=2019%E4%B8%8B17922404001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922404&kkhm=2019%E4%B8%8B17922404001" target="_blank">进度表</a></td>			
          <td align="center">沈炎斌</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">16</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;云计算与数据中心 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922405&kkhm=2019%E4%B8%8B17922405001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922405&kkhm=2019%E4%B8%8B17922405001" target="_blank">进度表</a></td>			
          <td align="center">林庆新</td>
		  <td align="center">专业素质课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center">2</td>
          <td align="center">12</td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;艺术哲学：美是如何诞生的 (111)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=80000236&kkhm=2019%E4%B8%8B80000236111" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=80000236&kkhm=2019%E4%B8%8B80000236111" target="_blank">进度表</a></td>			
          <td align="center"></td>
		  <td align="center">院选课</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">院选课超星尔雅</td>					  
		  <td align="center">2</td>
          <td align="center">32</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center"></td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：期末成绩=平时学习40%+学院组织的线下考试60%</td></tr>
       
        <tr> 
          <td  >&nbsp;大数据计算实践 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=18922602&kkhm=2019%E4%B8%8B18922602001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=18922602&kkhm=2019%E4%B8%8B18922602001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center"></td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td  >&nbsp;大数据综合应用案例实训 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922662&kkhm=2019%E4%B8%8B17922662001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922662&kkhm=2019%E4%B8%8B17922662001" target="_blank">进度表</a></td>			
          <td align="center">马云莺</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr> 
          <td rowspan="2"  >&nbsp;数据挖掘应用实践 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922661&kkhm=2019%E4%B8%8B17922661001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922661&kkhm=2019%E4%B8%8B17922661001" target="_blank">进度表</a></td>			
          <td align="center">杨雄</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">1.5</td>
          <td align="center">30</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
        <tr height="25"><td align="left" colspan="10">★备注：差4学时另补</td></tr>
       
        <tr> 
          <td  >&nbsp;证券投资模拟实验 (实验班)班</td>
          <td align="center"><a href="../kkgl/kcjd/dgjdb.asp?lx=dg&kkxq=2019%E4%B8%8B&kcdm=17922638&kkhm=2019%E4%B8%8B17922638001" target="_blank">大纲</a>
		  /<a href="../kkgl/kcjd/dgjdb.asp?lx=jdb&kkxq=2019%E4%B8%8B&kcdm=17922638&kkhm=2019%E4%B8%8B17922638001" target="_blank">进度表</a></td>			
          <td align="center">冯玮</td>
		  <td align="center">实践环节</td>		  
		  <td align="center">正常考考试</td>					  
		  <td align="center">2017级综合实验班</td>					  
		  <td align="center">2</td>
          <td align="center">48</td>
          <td align="center">√</td>
          <td align="center"></td>
          <td align="center">00～00</td>	
        </tr>
       
      </table><font color="#CC3333">
	  </font>
	  </td>
    <td valign="top">
	
	<table width="440" height="400" cellspacing="0" cellpadding="1" align="center" style="border-collapse: collapse" border="1" bordercolor="#111111">
        <tr  height="30"> 
          <td align="center">
            星期<br>
            节次 </td>
          <td align="center">一</td>
          <td align="center">二</td>
          <td align="center">三</td>
          <td align="center">四</td>
          <td align="center">五</td>
		  
          <td align="center">六</td>
		  
          <td align="center">日</td>
		  
        </tr>
        
        
        <tr id="tr1"> 
          <td align="center">1</td>
          
          <td align="center" rowspan=2 id="11">高等数学（一）下(实验)班<br>[网络教学]<br>高级数据库技术(实验班)班<br>[网络教学]<br>[1~4节]<br>(01-12周)<br>数字逻辑与计算机组成(实验班)班<br>[网络教学]<br>[1~4节]<br>(01-02周)<br>数字逻辑与计算机组成(实验班)班<br>[网络教学]<br>(03-14周)</td>
          
          <td align="center" rowspan=2 id="12">证券投资学(实验班)班<br>[网络教学]<br>(01-12周)<br>证券投资模拟实验(实验班)班<br>[网络教学]<br>[1~4节]<br>(13-18周)</td>
          
          <td align="center" rowspan=2 id="13">高等数学（一）下(实验)班<br>[网络教学]<br>线性代数(6)班<br>[网络教学]<br>数据挖掘与分析(实验班)班<br>[网络教学]<br>[1~4节]<br>(01-08周)<br>数据挖掘应用实践(实验班)班<br>[网络教学]<br>[1~4节]<br>(09-15周)<br>数据挖掘应用实践(实验班)班<br>[网络教学]<br>[1~4节]<br>(16-16周)</td>
          
          <td align="center" rowspan=4 id="14">大数据计算(实验班)班<br>[网络教学]<br>(01-08周)<br>大数据计算实践(实验班)班<br>[网络教学]<br>(09-15周)<br>大数据计算实践(实验班)班<br>[网络教学]<br>[1~2节]<br>(16-16周)</td>
          
          <td align="center" rowspan=4 id="15">云计算与数据中心(实验班)班<br>[网络教学]<br>(01-04周)<br>高等数学（一）下(实验)班<br>[网络教学]<br>[3~4节]<br>大数据综合应用案例实训(实验班)班<br>[网络教学]<br>(05-12周)<br>大数据综合应用案例实训(实验班)班<br>[3~4节]<br>[网络教学]<br>(14-14周)</td>
          
          <td align="center" rowspan=2 id="16">数据可视化与可视分析(实验班)班<br>[网络教学]<br>(15-18周)</td>
          
          <td id="17">&nbsp;</td>
          
        </tr>
        
        <tr id="tr2"> 
          <td align="center">2</td>
          
          <td id="27">&nbsp;</td>
          
        </tr>
        
        <tr id="tr3"> 
          <td align="center">3</td>
          
          <td id="31">&nbsp;</td>
          
          <td align="center" rowspan=2 id="32">证券投资模拟实验(实验班)班<br>[网络教学]<br>(01-12周)</td>
          
          <td id="33">&nbsp;</td>
          
          <td id="36">&nbsp;</td>
          
          <td align="center" rowspan=2 id="37">形势与政策（六）(9)班<br>[网络教学]</td>
          
        </tr>
        
        <tr id="tr4"> 
          <td align="center">4</td>
          
          <td id="41">&nbsp;</td>
          
          <td id="43">&nbsp;</td>
          
          <td id="46">&nbsp;</td>
          
        </tr>
        
        <tr id="tr5"> 
          <td align="center">5</td>
          
          <td align="center" rowspan=2 id="51">软件工程(实验班)班<br>[网络教学]<br>(01-12周)<br>数据可视化与可视分析(实验班)班<br>[网络教学]<br>[5~8节]<br>(15-18周)</td>
          
          <td align="center" rowspan=3 id="52">计算机网络(实验班)班<br>[网络教学]<br>(01-06周)<br>计算机网络(实验班)班<br>[网络教学]<br>[5~8节]<br>(07-08周)<br>计算机网络(实验班)班<br>[网络教学]<br>[5~6节]<br>(09-13周)</td>
          
          <td align="center" rowspan=4 id="53">软件工程(实验班)班<br>[网络教学]<br>(05-08周)<br>软件工程(实验班)班<br>[网络教学]<br>(10-10周)<br>软件工程(实验班)班<br>[网络教学]<br>(13-13周)<br>云计算与数据中心(实验班)班<br>[网络教学]<br>(01-04周)</td>
          
          <td align="center" rowspan=2 id="54">金融风控与大数据(实验班)班<br>[网络教学]<br>(01-09周)<br>金融风控与大数据(实验班)班<br>[网络教学]<br>[5~8节]<br>(10-14周)</td>
          
          <td align="center" rowspan=2 id="55">线性代数(6)班<br>[网络教学]<br>证券投资学(实验班)班<br>[网络教学]<br>(01-12周)</td>
          
          <td align="center" rowspan=2 id="56">概率论与数理统计(普6)班<br>[网络教学]</td>
          
          <td id="57">&nbsp;</td>
          
        </tr>
        
        <tr id="tr6"> 
          <td align="center">6</td>
          
          <td id="67">&nbsp;</td>
          
        </tr>
        
        <tr id="tr7"> 
          <td align="center">7</td>
          
          <td id="71">&nbsp;</td>
          
          <td id="74">&nbsp;</td>
          
          <td align="center" rowspan=2 id="75">计算机网络(实验班)班<br>[网络教学]<br>(09-12周)</td>
          
          <td id="76">&nbsp;</td>
          
          <td id="77">&nbsp;</td>
          
        </tr>
        
        <tr id="tr8"> 
          <td align="center">8</td>
          
          <td id="81">&nbsp;</td>
          
          <td id="82">&nbsp;</td>
          
          <td id="84">&nbsp;</td>
          
          <td id="86">&nbsp;</td>
          
          <td id="87">&nbsp;</td>
          
        </tr>
        
        <tr id="tr9"> 
          <td align="center">9</td>
          
          <td id="91">&nbsp;</td>
          
          <td id="92">&nbsp;</td>
          
          <td align="center" rowspan=2 id="93">概率论与数理统计(普6)班<br>[网络教学]<br>数字逻辑与计算机组成(实验班)班<br>[网络教学]<br>(03-14周)</td>
          
          <td align="center" rowspan=2 id="94">计算机网络(实验班)班<br>[网络教学]<br>(07-12周)</td>
          
          <td id="95">&nbsp;</td>
          
          <td id="96">&nbsp;</td>
          
          <td id="97">&nbsp;</td>
          
        </tr>
        
        <tr id="tr10"> 
          <td align="center">10</td>
          
          <td id="101">&nbsp;</td>
          
          <td id="102">&nbsp;</td>
          
          <td id="105">&nbsp;</td>
          
          <td id="106">&nbsp;</td>
          
          <td id="107">&nbsp;</td>
          
        </tr>
        
        <tr id="tr11"> 
          <td align="center">11</td>
          
          <td id="111">&nbsp;</td>
          
          <td id="112">&nbsp;</td>
          
          <td id="113">&nbsp;</td>
          
          <td id="114">&nbsp;</td>
          
          <td id="115">&nbsp;</td>
          
          <td id="116">&nbsp;</td>
          
          <td id="117">&nbsp;</td>
          
        </tr>
        
      </table></td>
  </tr>
</table>
	
</body>
</html>
"""

    /**
     * 有重修课程的实验班 预期结果
     */
    private val relearnCoursesExpected: String
        get() = "[Course{couID=15, onlyID=0, couName='艺术哲学：美是如何诞生的 (111)班', couRoom='null', couTeacher='超星尔雅', couWeek=null, couStartNode=null, couEndNode=null, couWeekType=3, couStartWeek=null, couEndWeek=null, couColor=null}, " +
                "Course{couID=1, onlyID=1, couName='高等数学（一）下 (实验)班', couRoom='网络教学', couTeacher='陈育栎', couWeek=1, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                "Course{couID=5, onlyID=2, couName='高级数据库技术 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=1, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                "Course{couID=7, onlyID=3, couName='数字逻辑与计算机组成 (实验班)班', couRoom='网络教学', couTeacher='黄福明', couWeek=1, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=2, couColor=null}, " +
                "Course{couID=7, onlyID=4, couName='数字逻辑与计算机组成 (实验班)班', couRoom='网络教学', couTeacher='黄福明', couWeek=1, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=3, couEndWeek=14, couColor=null}, " +
                "Course{couID=8, onlyID=5, couName='证券投资学 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=2, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                "Course{couID=19, onlyID=6, couName='证券投资模拟实验 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=2, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=13, couEndWeek=18, couColor=null}, " +
                "Course{couID=1, onlyID=7, couName='高等数学（一）下 (实验)班', couRoom='网络教学', couTeacher='陈育栎', couWeek=3, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                "Course{couID=2, onlyID=8, couName='线性代数 (6)班', couRoom='网络教学', couTeacher='郑达艺,曾怀杰', couWeek=3, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=4, couEndWeek=13, couColor=null}, " +
                "Course{couID=6, onlyID=9, couName='数据挖掘与分析 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                "Course{couID=18, onlyID=10, couName='数据挖掘应用实践 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=9, couEndWeek=15, couColor=null}, " +
                "Course{couID=18, onlyID=11, couName='数据挖掘应用实践 (实验班)班', couRoom='网络教学', couTeacher='杨雄', couWeek=3, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=16, couEndWeek=16, couColor=null}, " +
                "Course{couID=9, onlyID=12, couName='大数据计算 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=8, couColor=null}, " +
                "Course{couID=16, onlyID=13, couName='大数据计算实践 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=9, couEndWeek=15, couColor=null}, " +
                "Course{couID=16, onlyID=14, couName='大数据计算实践 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=4, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=16, couEndWeek=16, couColor=null}, " +
                "Course{couID=13, onlyID=15, couName='云计算与数据中心 (实验班)班', couRoom='网络教学', couTeacher='林庆新', couWeek=5, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                "Course{couID=1, onlyID=16, couName='高等数学（一）下 (实验)班', couRoom='网络教学', couTeacher='陈育栎', couWeek=5, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=16, couColor=null}, " +
                "Course{couID=17, onlyID=17, couName='大数据综合应用案例实训 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=5, couStartNode=1, couEndNode=4, couWeekType=0, couStartWeek=5, couEndWeek=12, couColor=null}, " +
                "Course{couID=17, onlyID=18, couName='大数据综合应用案例实训 (实验班)班', couRoom='网络教学', couTeacher='马云莺', couWeek=5, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=14, couEndWeek=14, couColor=null}, " +
                "Course{couID=12, onlyID=19, couName='数据可视化与可视分析 (实验班)班', couRoom='网络教学', couTeacher='沈炎斌', couWeek=6, couStartNode=1, couEndNode=2, couWeekType=0, couStartWeek=15, couEndWeek=18, couColor=null}, " +
                "Course{couID=19, onlyID=20, couName='证券投资模拟实验 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=2, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                "Course{couID=3, onlyID=21, couName='形势与政策（六） (9)班', couRoom='网络教学', couTeacher='潘曦', couWeek=7, couStartNode=3, couEndNode=4, couWeekType=0, couStartWeek=11, couEndWeek=14, couColor=null}, " +
                "Course{couID=11, onlyID=22, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=1, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                "Course{couID=12, onlyID=23, couName='数据可视化与可视分析 (实验班)班', couRoom='网络教学', couTeacher='沈炎斌', couWeek=1, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=15, couEndWeek=18, couColor=null}, " +
                "Course{couID=4, onlyID=24, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=2, couStartNode=5, couEndNode=7, couWeekType=0, couStartWeek=1, couEndWeek=6, couColor=null}, " +
                "Course{couID=4, onlyID=25, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=2, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=7, couEndWeek=8, couColor=null}, " +
                "Course{couID=4, onlyID=26, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=2, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=9, couEndWeek=13, couColor=null}, " +
                "Course{couID=11, onlyID=27, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=5, couEndWeek=8, couColor=null}, " +
                "Course{couID=11, onlyID=28, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=10, couEndWeek=10, couColor=null}, " +
                "Course{couID=11, onlyID=29, couName='软件工程 (实验班)班', couRoom='网络教学', couTeacher='张栋', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=13, couEndWeek=13, couColor=null}, " +
                "Course{couID=13, onlyID=30, couName='云计算与数据中心 (实验班)班', couRoom='网络教学', couTeacher='林庆新', couWeek=3, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=1, couEndWeek=4, couColor=null}, " +
                "Course{couID=10, onlyID=31, couName='金融风控与大数据 (实验班)班', couRoom='网络教学', couTeacher='张希君', couWeek=4, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=9, couColor=null}, " +
                "Course{couID=10, onlyID=32, couName='金融风控与大数据 (实验班)班', couRoom='网络教学', couTeacher='张希君', couWeek=4, couStartNode=5, couEndNode=8, couWeekType=0, couStartWeek=10, couEndWeek=14, couColor=null}, " +
                "Course{couID=2, onlyID=33, couName='线性代数 (6)班', couRoom='网络教学', couTeacher='郑达艺,曾怀杰', couWeek=5, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=4, couEndWeek=13, couColor=null}, " +
                "Course{couID=8, onlyID=34, couName='证券投资学 (实验班)班', couRoom='网络教学', couTeacher='冯玮', couWeek=5, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=12, couColor=null}, " +
                "Course{couID=0, onlyID=35, couName='概率论与数理统计 (普6)班', couRoom='网络教学', couTeacher='项景华', couWeek=6, couStartNode=5, couEndNode=6, couWeekType=0, couStartWeek=1, couEndWeek=15, couColor=null}, " +
                "Course{couID=4, onlyID=36, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=5, couStartNode=7, couEndNode=8, couWeekType=0, couStartWeek=9, couEndWeek=12, couColor=null}, " +
                "Course{couID=0, onlyID=37, couName='概率论与数理统计 (普6)班', couRoom='网络教学', couTeacher='项景华', couWeek=3, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=1, couEndWeek=15, couColor=null}, " +
                "Course{couID=7, onlyID=38, couName='数字逻辑与计算机组成 (实验班)班', couRoom='网络教学', couTeacher='黄福明', couWeek=3, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=3, couEndWeek=14, couColor=null}, " +
                "Course{couID=4, onlyID=39, couName='计算机网络 (实验班)班', couRoom='网络教学', couTeacher='黄巧云', couWeek=4, couStartNode=9, couEndNode=10, couWeekType=0, couStartWeek=7, couEndWeek=12, couColor=null}]"
}