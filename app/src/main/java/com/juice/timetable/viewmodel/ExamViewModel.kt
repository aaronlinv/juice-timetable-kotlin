package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juice.timetable.data.source.Exam
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.ExamRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ExamViewModel(val app: Application) : ViewModel() {
    private var examRepository: ExamRepository = ExamRepository(JuiceDatabase.getDatabase(app))

    val examLive = examRepository.getLiveData()

    suspend fun addAllExam(exams: List<Exam>) {
        withContext(Dispatchers.IO) {
            examRepository.add(exams)
        }
    }

    suspend fun deleteAllExam() {
        withContext(Dispatchers.IO) {
            examRepository.deleteAllExam()
        }
    }

    suspend fun findNameWithPattern(pattern: String): LiveData<List<Exam>> {
        return withContext(Dispatchers.IO) {
            examRepository.findNameWithPattern(pattern)
        }
    }


}