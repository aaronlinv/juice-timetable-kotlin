package com.juice.timetable.repo

import androidx.lifecycle.LiveData
import com.juice.timetable.api.GradeService
import com.juice.timetable.data.source.Credit
import com.juice.timetable.data.source.SynGrade
import com.juice.timetable.data.source.UniGrade
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.utils.LogUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.UnknownHostException

class GradeRepository(private val db: JuiceDatabase) {
    private var gradeService: GradeService = GradeService.create()

    //增加
    fun addAllSyn(synGrades: List<SynGrade>) {
        db.synGradeDao().insertSynGrade(synGrades)
    }

    fun addAllUni(uniGrades: List<UniGrade>) {
        db.uniGradeDao().insertUniGrade(uniGrades)

    }

    fun addAllCredit(credits: List<Credit>) {
        db.creditDao().insertCredit(credits)
    }

    // 获得
    private val getAllSyn: LiveData<List<SynGrade>> by lazy {
        db.synGradeDao().getAllSynGradeLive()
    }
    private val getAllUni: LiveData<List<UniGrade>> by lazy {
        db.uniGradeDao().getAllUniGradeLive()
    }
    private val getAllCredit: LiveData<List<Credit>> by lazy {
        db.creditDao().getALlCreditLive()
    }

    // 暴露获得 LiveData 的方法
    fun getSynLiveData(): LiveData<List<SynGrade>> {
        return getAllSyn
    }

    fun getUniLiveData(): LiveData<List<UniGrade>> {
        return getAllUni
    }

    fun getCreditLiveData(): LiveData<List<Credit>> {
        return getAllCredit
    }

    // 删除
    fun deleteAllSyn() {
        return db.synGradeDao().deleteAllSynGrade()
    }

    fun deleteAllUni() {
        return db.uniGradeDao().deleteAllUniGrade()
    }

    fun deleteAllCredit() {
        return db.creditDao().deleteAllCredits()
    }

    // 模式匹配
    fun findNameWithPattern(pattern: String): LiveData<List<SynGrade>> {
        return db.synGradeDao().findNameWithPattern(pattern)
    }

    // 更新
    fun updateCredit(credits: List<Credit>) {
        return db.creditDao().updateCredit(credits)
    }

    // http请求
    suspend fun getGradeInfo(url: String): String {
        return withContext(Dispatchers.IO) {
            val cookies = db.stuInfoDao().getStuInfo()?.cookies

            LogUtils.d("从数据库中提取cookies--> $cookies")
            try {
                val response = cookies?.let { gradeService.gradeUrl(url, it) }
                if (response!!.isSuccessful) {
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