package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.StuInfoRepository
import kotlinx.coroutines.launch

class StuInfoViewModel(val app: Application) : ViewModel() {
    private var stuInfoRepository: StuInfoRepository =
        StuInfoRepository(JuiceDatabase.getDatabase(app))

    val stuInfo = stuInfoRepository.getLiveData()

    // val dataLoading: LiveData<Boolean> = _dataLoading
    //
    // fun refresh() {
    //     _dataLoading.value = true
    //     viewModelScope.launch {
    //         tasksRepository.refreshTasks()
    //         _dataLoading.value = false
    //     }
    // }


    fun getStuInfo(): StuInfo? {
        var result: StuInfo? = null
        viewModelScope.launch {
            val data = stuInfoRepository.get()
            if (data != null) {
                result = data
            }
        }
        return result
    }
}