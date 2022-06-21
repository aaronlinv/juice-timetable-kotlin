package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.juice.timetable.data.source.Course
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.AllWeekCourseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AllWeekCourseViewModel(val app: Application) : ViewModel() {
    private var allWeekCourseRepository: AllWeekCourseRepository =
        AllWeekCourseRepository(JuiceDatabase.getDatabase(app))

    val allWeekCourse = allWeekCourseRepository.getLiveData()

    suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            allWeekCourseRepository.deleteAll()
        }
    }

    suspend fun getAll(): List<Course> {
        return withContext(Dispatchers.IO) {
            allWeekCourseRepository.getAll()
        }
    }

    suspend fun addAll(courses: List<Course>) {
        withContext(Dispatchers.IO) {
            allWeekCourseRepository.add(courses)
        }
    }
}