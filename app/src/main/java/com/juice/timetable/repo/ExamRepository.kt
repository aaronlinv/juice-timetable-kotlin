package com.juice.timetable.repo

import androidx.lifecycle.LiveData
import com.juice.timetable.api.ExamService
import com.juice.timetable.data.source.Exam
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.utils.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class ExamRepository(private val db: JuiceDatabase) {
    private var examService: ExamService = ExamService.create()

    fun addAllExam(exams: List<Exam>) {
        db.examDao().insertExam(exams)
    }

    private val allExam: LiveData<List<Exam>> by lazy {
        db.examDao().getAllExamLive()
    }

    // 暴露获得 LiveData 的方法
    fun getExamLiveData(): LiveData<List<Exam>> {
        return allExam
    }

    fun deleteAllExam() {
        return db.examDao().deleteAllExam()
    }

    fun findNameWithPattern(pattern: String): LiveData<List<Exam>> {
        return db.examDao().findNameWithPattern(pattern)
    }


    suspend fun getExamInfo(url: String, year: String, type: String): String {
        return withContext(Dispatchers.IO) {
            val data = hashMapOf(
                "xn" to year,
                "xq" to type,
            )
            val cookies = db.stuInfoDao().getStuInfo()?.cookies
            LogUtils.d("从数据库中提取cookies--> $cookies")

            try {
                val response = examService.examUrl(url, cookies, data)
                if (response.isSuccessful) {
                    if (response.body() == null) {
                        throw Exception("登录响应体为 null")
                    }
                }
                return@withContext response.body()!!.string()
            } catch (e: UnknownHostException) {
                throw Exception("网络不太好，检查一下网络吧")
            }
        }
    }


}

