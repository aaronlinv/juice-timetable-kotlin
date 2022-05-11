package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juice.timetable.data.source.Course

@Dao
interface AllWeekCourseDao {
    @Insert
    fun insertAllWeekCourse(courses: List<Course>)

    @Query("Delete from course")
    fun deleteAllWeekCourse()

    @Query("Select * from course")
    fun allWeekCourseLive(): LiveData<List<Course>>

    @Query("Select * from course")
    fun allWeekCourse(): List<Course>
}