package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.juice.timetable.data.source.SingleWeekCourse
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.SingleWeekCourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SingleWeekCourseViewModel(val app: Application) : ViewModel() {
    private var singleWeekCourseRepository: SingleWeekCourseRepository =
        SingleWeekCourseRepository(JuiceDatabase.getDatabase(app))

    val singleWeekCourse = singleWeekCourseRepository.getLiveData()

    suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            singleWeekCourseRepository.deleteAll()
        }
    }

    suspend fun getWeek(): List<Int> {
        return withContext(Dispatchers.IO) {
            singleWeekCourseRepository.getWeek()
        }
    }

    /**
     * 获取第几周，第几天的课程
     */
    suspend fun getSomeDay(dayOfWeek: Int, week: Int) {
        return withContext(Dispatchers.IO) {
            singleWeekCourseRepository.getSomeDay(dayOfWeek, week)
        }
    }

    suspend fun getAll(): List<SingleWeekCourse> {
        return withContext(Dispatchers.IO) {
            singleWeekCourseRepository.getAll()
        }
    }

    suspend fun addAll(courses: List<SingleWeekCourse>) {
        withContext(Dispatchers.IO) {
            singleWeekCourseRepository.add(courses)
        }
    }

    suspend fun deleteWeek(deleteWeek: Set<Int>) {
        withContext(Dispatchers.IO) {
            singleWeekCourseRepository.deleteCourseByWeek(deleteWeek)
        }
    }
}