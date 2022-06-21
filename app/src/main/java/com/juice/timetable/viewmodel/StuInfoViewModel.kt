package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.StuInfoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class StuInfoViewModel(val app: Application) : ViewModel() {
    private var stuInfoRepository: StuInfoRepository =
        StuInfoRepository(JuiceDatabase.getDatabase(app))

    val stuInfo = stuInfoRepository.getLiveData()

    suspend fun getStuInfo(): StuInfo? {
        return withContext(Dispatchers.IO) {
            stuInfoRepository.get()
        }
    }

    suspend fun add(stuInfo: StuInfo) {
        return withContext(Dispatchers.IO) {
            stuInfoRepository.add(stuInfo)
        }
    }

    suspend fun deleteAll() {
        withContext(Dispatchers.IO) {
            stuInfoRepository.deleteAll()
        }
    }
}