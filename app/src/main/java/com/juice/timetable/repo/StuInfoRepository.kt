package com.juice.timetable.repo

import androidx.lifecycle.LiveData
import com.juice.timetable.data.source.StuInfo
import com.juice.timetable.data.source.local.JuiceDatabase

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/17
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class StuInfoRepository(private val db: JuiceDatabase) {
    fun add(stuInfo: StuInfo) {
        db.stuInfoDao().insertStuInfo(stuInfo)
    }

    // 每个 Repository 只实例化一个 LiveData，这样外界就可以观察它
    // 使用 lazy 保证只实例化一次
    private val stuInfo: LiveData<StuInfo> by lazy {
        db.stuInfoDao().getStuInfoLiveData()
    }

    // 暴露获得 LiveData 的方法
    fun getLiveData(): LiveData<StuInfo> {
        return stuInfo
    }

    fun get(): StuInfo? {
        return db.stuInfoDao().getStuInfo()
    }

    fun deleteAll() {
        return db.stuInfoDao().deleteStuInfo()
    }

    fun update(stuInfo: StuInfo) {
        return db.stuInfoDao().updateStuInfo(stuInfo)
    }
}