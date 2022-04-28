package com.juice.timetable.data.source.local

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.juice.timetable.data.source.StuInfo
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * <pre>
 * author : Aaron
 * time   : 2022/04/28
 * desc   :
 * version: 1.0
</pre> *
 */
@RunWith(AndroidJUnit4::class)
class JuiceDatabaseTest {
    private lateinit var db: JuiceDatabase
    private lateinit var stuInfoDao: StuInfoDao

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context,
            JuiceDatabase::class.java
        ).build()

        stuInfoDao = db.stuInfoDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun addTest() {
        val stuInfo = StuInfo(211700000, "testPassword", "")

        stuInfoDao.insertStuInfo(stuInfo)

        val queryStuInfo = stuInfoDao.getStuInfo()
        println(stuInfo)
        println(queryStuInfo)
        Assert.assertEquals(stuInfo, queryStuInfo)
    }
}