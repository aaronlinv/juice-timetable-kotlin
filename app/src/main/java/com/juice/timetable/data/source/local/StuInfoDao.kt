package com.juice.timetable.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juice.timetable.data.source.StuInfo

@Dao
interface StuInfoDao {
    @Insert
    fun insertStuInfo(vararg stuInfo: StuInfo)

    @Query("Delete from stu_info")
    fun deleteStuInfo()

    // @Update
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateStuInfo(vararg stuInfo: StuInfo)

    @Query("Select * from stu_info")
    fun getStuInfoLiveData(): LiveData<StuInfo>

    @Query("Select * from stu_info")
    fun getStuInfo(): StuInfo?
}