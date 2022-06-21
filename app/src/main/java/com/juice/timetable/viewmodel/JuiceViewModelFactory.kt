package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/05/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class JuiceViewModelFactory(val app: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StuInfoViewModel::class.java)) {
            return StuInfoViewModel(app) as T
        } else if (modelClass.isAssignableFrom(SingleWeekCourseViewModel::class.java)) {
            return SingleWeekCourseViewModel(app) as T
        } else if (modelClass.isAssignableFrom(AllWeekCourseViewModel::class.java)) {
            return AllWeekCourseViewModel(app) as T
        }

        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}