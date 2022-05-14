package com.juice.timetable.repo

import androidx.lifecycle.LiveData
import com.juice.timetable.data.source.Course
import com.juice.timetable.data.source.local.JuiceDatabase

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/05/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class AllWeekCourseRepository(private val db: JuiceDatabase) {
    fun add(courses: List<Course>) {
        db.allWeekCourseDao().insertAllWeekCourse(courses)
    }

    // 每个 Repository 只实例化一个 LiveData，这样外界就可以观察它
    // 使用 lazy 保证只实例化一次
    private val allWeekCourse: LiveData<List<Course>> by lazy {
        db.allWeekCourseDao().allWeekCourseLive()
    }

    // 暴露获得 LiveData 的方法
    fun getLiveData(): LiveData<List<Course>> {
        return allWeekCourse
    }

    fun getAll(): List<Course> {
        return db.allWeekCourseDao().allWeekCourse()
    }

    fun deleteAll() {
        return db.allWeekCourseDao().deleteAllWeekCourse()
    }
}