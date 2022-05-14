package com.juice.timetable.repo

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.juice.timetable.data.parse.ParseSingleWeek
import com.juice.timetable.data.parse.ParseSingleWeekTest
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.data.source.local.SingleWeekCourseDao
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * <pre>
 * author : Aaron
 * time   : 2022/05/11
 * desc   :
 * version: 1.0
</pre> *
 */
@RunWith(AndroidJUnit4::class)
class SingleWeekCourseRepositoryTest {
    private lateinit var db: JuiceDatabase
    private lateinit var singleWeekCourseDao: SingleWeekCourseDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            JuiceDatabase::class.java
        ).build()

        singleWeekCourseDao = db.singleWeekCourseDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun addTest() {
        val singleWeekCourseRepository = SingleWeekCourseRepository(db)
        val courses = ParseSingleWeek.parseCourse(ParseSingleWeekTest.csCourses)
        singleWeekCourseRepository.add(courses)
        val actualList = singleWeekCourseRepository.getAll()
        val expected = csCoursesExpected

        Assert.assertEquals(actualList.toString(), expected)
    }

    private val csCoursesExpected: String
        get() = "[SingleWeekCourse{onlyID=1, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=1, endNode=4, InWeek=11, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=2, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=3, startNode=1, endNode=4, InWeek=11, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=3, couID=null, couName='高级数据库技术(1)班', couRoom='[网络教学]', dayOfWeek=2, startNode=3, endNode=4, InWeek=11, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=4, couID=null, couName='软件工程(1)班', couRoom='[网络教学]', dayOfWeek=1, startNode=5, endNode=6, InWeek=11, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=5, couID=null, couName='大数据应用开发实践(1)班', couRoom='[网络教学]', dayOfWeek=2, startNode=5, endNode=8, InWeek=11, CourseType=0, Color=null}, " +
                "SingleWeekCourse{onlyID=6, couID=null, couName='大数据综合应用案例实训(1)班', couRoom='[网络教学]', dayOfWeek=4, startNode=5, endNode=8, InWeek=11, CourseType=0, Color=null}]"
}