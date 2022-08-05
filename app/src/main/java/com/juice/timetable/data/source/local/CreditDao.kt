package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.juice.timetable.data.source.Credit

@Dao
interface CreditDao {

    @Insert
    fun insertCredit(credits: List<Credit>)//增加

    @Query("DELETE FROM Credit")//删除
    fun deleteAllCredits()

    @Query("SELECT * FROM Credit")//查询全表
    fun getALlCreditLive(): LiveData<List<Credit>>

    @Update
    fun updateCredit(credits: List<Credit>)
}