package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stu_info")
data class StuInfo(
    @PrimaryKey var stuID: Int,
    var eduPassword: String,
    var cookies: String
)