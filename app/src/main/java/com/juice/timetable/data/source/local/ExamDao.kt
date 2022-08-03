package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juice.timetable.data.source.Exam

@Dao
interface ExamDao {
    @Insert//增加
    fun insertExam(exams: List<Exam>)

    @Query("DELETE FROM Exam")//删除
    fun deleteAllExam()

    @Query("SELECT * FROM Exam")//查询全表
    fun getAllExamLive(): LiveData<List<Exam>>

    @Query("SELECT * FROM Exam WHERE courseName LIKE '%' || :pattern || '%'")
    fun findNameWithPattern(pattern: String): LiveData<List<Exam>>
}