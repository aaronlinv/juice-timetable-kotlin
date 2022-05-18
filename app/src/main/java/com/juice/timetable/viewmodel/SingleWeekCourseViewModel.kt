package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.SingleWeekCourseRepository
import kotlinx.coroutines.launch

class SingleWeekCourseViewModel(val app: Application) : ViewModel() {
    private var singleWeekCourseRepository: SingleWeekCourseRepository =
        SingleWeekCourseRepository(JuiceDatabase.getDatabase(app))

    val singleWeekCourse = singleWeekCourseRepository.getLiveData()

    fun deleteAll() {
        viewModelScope.launch {
            singleWeekCourseRepository.deleteAll()
        }
    }
}