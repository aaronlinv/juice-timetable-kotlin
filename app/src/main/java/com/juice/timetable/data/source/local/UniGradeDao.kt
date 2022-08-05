package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.juice.timetable.data.source.UniGrade

@Dao
interface UniGradeDao {
    @Insert//增加
    fun insertUniGrade(uniGrades: List<UniGrade>)

    @Query("DELETE FROM UniGrade")//删除
    fun deleteAllUniGrade()

    @Query("SELECT * FROM UniGrade")//查询全表
    fun getAllUniGradeLive(): LiveData<List<UniGrade>>
}