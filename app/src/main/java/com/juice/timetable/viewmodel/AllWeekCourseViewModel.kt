package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.AllWeekCourseRepository
import kotlinx.coroutines.launch

class AllWeekCourseViewModel(val app: Application) : ViewModel() {
    private var allWeekCourseRepository: AllWeekCourseRepository =
        AllWeekCourseRepository(JuiceDatabase.getDatabase(app))

    val allWeekCourse = allWeekCourseRepository.getLiveData()

    fun deleteAll() {
        viewModelScope.launch {
            allWeekCourseRepository.deleteAll()
        }
    }
}