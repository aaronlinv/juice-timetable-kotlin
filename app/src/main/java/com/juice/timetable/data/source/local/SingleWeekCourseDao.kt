package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juice.timetable.data.source.SingleWeekCourse

@Dao
interface SingleWeekCourseDao {
    @Insert
    fun insertCourse(courses: List<SingleWeekCourse>)

    @Query("Delete From single_week_course")
    fun deleteCourse()

    @Query("Select * From single_week_course")
    fun singleWeekCourseLive(): LiveData<List<SingleWeekCourse>>

    @Query("Select * From single_week_course")
    fun singleWeekCourse(): List<SingleWeekCourse>

    @Query("Select inWeek from single_week_course")
    fun inWeekLive(): LiveData<List<Int>>

    @Query("Select inWeek from single_week_course")
    fun inWeek(): List<Int>

    // 删除指定周的课程信息
    @Query("DELETE FROM single_week_course  WHERE inWeek IN (:week)")
    fun deleteCourseByWeek(week: ArrayList<Int>)
}