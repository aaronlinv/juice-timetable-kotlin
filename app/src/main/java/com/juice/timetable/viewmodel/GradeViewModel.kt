package com.juice.timetable.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.juice.timetable.data.source.Credit
import com.juice.timetable.data.source.SynGrade
import com.juice.timetable.data.source.UniGrade
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.repo.GradeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GradeViewModel(val app: Application) : ViewModel() {
    private var gradeRepository: GradeRepository = GradeRepository(JuiceDatabase.getDatabase(app))

    val synGradeLive = gradeRepository.getSynLiveData()
    val uniGradeLive = gradeRepository.getUniLiveData()
    val creditLive = gradeRepository.getCreditLiveData()

    suspend fun addAllSyn(synGrades: List<SynGrade>) {
        withContext(Dispatchers.IO) {
            gradeRepository.addAllSyn(synGrades)
        }
    }

    suspend fun addAllUni(uniGrade: List<UniGrade>) {
        withContext(Dispatchers.IO) {
            gradeRepository.addAllUni(uniGrade)
        }
    }

    suspend fun addAllCredit(credits: List<Credit>) {
        withContext(Dispatchers.IO) {
            gradeRepository.addAllCredit(credits)
        }
    }

    suspend fun deleteAllSyn() {
        withContext(Dispatchers.IO) {
            gradeRepository.deleteAllSyn()
        }
    }

    suspend fun deleteAllUni() {
        withContext(Dispatchers.IO) {
            gradeRepository.deleteAllUni()
        }
    }

    suspend fun deleteAllCredit() {
        withContext(Dispatchers.IO) {
            gradeRepository.deleteAllCredit()
        }

    }

    suspend fun findNameWithPattern(pattern: String): LiveData<List<SynGrade>> {
        return withContext(Dispatchers.IO) {
            gradeRepository.findNameWithPattern(pattern)
        }
    }

    suspend fun updateCredit(credits: List<Credit>) {
        withContext(Dispatchers.IO) {
            gradeRepository.updateCredit(credits)
        }
    }

}