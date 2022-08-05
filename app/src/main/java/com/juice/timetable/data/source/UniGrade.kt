package com.juice.timetable.data.source

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "uniGrade")
class UniGrade {
    @PrimaryKey
    var uniGradeId: Int? = null

    var uYear: String? = null
    var uName: String? = null
    var uGrade: String? = null
    var uRemarks: String? = null

    constructor(
        uniGradeId: Int?,
        uYear: String?,
        uName: String?,
        uGrade: String?,
        uRemarks: String?
    ) {
        this.uniGradeId = uniGradeId
        this.uYear = uYear
        this.uName = uName
        this.uGrade = uGrade
        this.uRemarks = uRemarks
    }

    override fun toString(): String {
        return "UniGrade(uniGradeId=$uniGradeId, " +
                "uYear=$uYear, " +
                "uName=$uName, " +
                "uGrade=$uGrade, " +
                "uRemarks=$uRemarks)"
    }

}