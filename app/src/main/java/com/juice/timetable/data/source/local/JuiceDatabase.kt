package com.juice.timetable.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.juice.timetable.data.source.StuInfo

/**
 * <pre>
 *     author : Aaron
 *     time   : 2022/04/16
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@Database(
    // 表明数据库中有几张表
    entities = [StuInfo::class],
    // 数据库版本
    version = 1
)
abstract class JuiceDatabase : RoomDatabase() {
    abstract fun stuInfoDao(): StuInfoDao

    companion object {
        @Volatile
        private var INSTANCE: JuiceDatabase? = null
        fun getDatabase(context: Context): JuiceDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    JuiceDatabase::class.java,
                    "juice.db"
                ).build()
                INSTANCE = instance
                // 返回实例
                instance
            }
        }
    }
}