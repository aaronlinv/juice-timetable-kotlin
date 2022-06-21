package com.juice.timetable.utils

import android.content.Context
import android.content.pm.PackageManager

object VersionUtils {
    @JvmStatic
    fun getVersionCode(context: Context): String? {
        var versionCode: String? = null
        try {
            // 获取软件版本号，对应 build.gradle 下的 versionName
            versionCode = context.packageManager.getPackageInfo(context.packageName, 0).versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }
        return versionCode
    }
}