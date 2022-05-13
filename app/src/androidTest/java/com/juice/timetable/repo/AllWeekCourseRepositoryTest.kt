package com.juice.timetable.repo

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.juice.timetable.data.parse.ParseAllWeek
import com.juice.timetable.data.parse.ParseAllWeekTest
import com.juice.timetable.data.source.local.AllWeekCourseDao
import com.juice.timetable.data.source.local.JuiceDatabase
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
class AllWeekCourseRepositoryTest {
    private lateinit var db: JuiceDatabase
    private lateinit var allWeekCourseDao: AllWeekCourseDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            JuiceDatabase::class.java
        ).build()

        allWeekCourseDao = db.allWeekCourseDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun allWeekCourseDaoTest() {
        val courses = ParseAllWeek.parseCourse(ParseAllWeekTest.csCourses)

        allWeekCourseDao.insertAllWeekCourse(courses)
        val actualList = allWeekCourseDao.allWeekCourse()

        Assert.assertEquals(actualList.toString(), ParseAllWeekTest.csCoursesExpected)
    }
}