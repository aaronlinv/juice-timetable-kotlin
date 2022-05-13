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

    @Query("Delete from Course")
    fun deleteAllWeekCourse()

    @Query("Select * from Course")
    fun allWeekCourseLive(): LiveData<List<Course>>

    @Query("Select * from Course")
    fun allWeekCourse(): List<Course>
}