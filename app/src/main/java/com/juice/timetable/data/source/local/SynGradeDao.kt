package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juice.timetable.data.source.SynGrade

@Dao
interface SynGradeDao {
    @Insert//增加
    fun insertSynGrade(synGrades: List<SynGrade>)

    @Query("DELETE FROM SynGrade")//删除
    fun deleteAllSynGrade()

    @Query("SELECT * FROM SynGrade") //查询全表
    fun getAllSynGradeLive(): LiveData<List<SynGrade>>

    @Query("SELECT * FROM SynGrade WHERE couName LIKE '%' || :pattern || '%'")
    fun findNameWithPattern(pattern: String?): LiveData<List<SynGrade>>

}