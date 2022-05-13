package com.juice.timetable.utils

import android.util.Log

object LogUtils {
    //打印调试开关
    private const val IS_DEBUG = true

    //Log 单词打印的最大长度
    private const val MAX_LENGTH = 3 * 1024

    /**
     * 获取 TAG 信息：文件名以及行数
     *
     * @return TAG 信息
     */
    @get:Synchronized
    private val tAG: String
        get() {
            val tag = StringBuilder()
            val sts = Thread.currentThread().stackTrace ?: return ""
            for (st in sts) {
                //筛选获取需要打印的TAG
                if (!st.isNativeMethod && st.className != Thread::class.java.name && st.className != this.javaClass.name) {
                    //获取文件名以及打印的行数
                    tag.append("(").append(st.fileName).append(":").append(st.lineNumber)
                        .append(")")
                    return tag.toString()
                }
            }
            return ""
        }

    /**
     * Log.e 打印
     *
     * @param text 需要打印的内容
     */
    @Synchronized
    fun e(text: String) {
        if (IS_DEBUG) {
            for (str in splitStr(text)) {
                Log.e(tAG, str!!)
            }
        }
    }

    /**
     * Log.d 打印
     *
     * @param text 需要打印的内容
     */
    @Synchronized
    fun d(text: String) {
        if (IS_DEBUG) {
            for (str in splitStr(text)) {
                Log.d(tAG, str!!)
            }
        }
    }

    /**
     * Log.w 打印
     *
     * @param text 需要打印的内容
     */
    @Synchronized
    fun w(text: String) {
        if (IS_DEBUG) {
            for (str in splitStr(text)) {
                Log.w(tAG, str!!)
            }
        }
    }

    /**
     * Log.i 打印
     *
     * @param text 需要打印的内容
     */
    @Synchronized
    fun i(text: String) {
        if (IS_DEBUG) {
            for (str in splitStr(text)) {
                Log.i(tAG, str!!)
            }
        }
    }

    /**
     * Log.e 打印格式化后的JSON数据
     *
     * @param json 需要打印的内容
     */
    @Synchronized
    fun json(json: String?) {
        if (IS_DEBUG) {
            val tag = tAG
            try {
                //转化后的数据
                val logStr = formatJson(json)
                for (str in splitStr(logStr)) {
                    Log.e(tAG, str!!)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e(tag, e.toString())
            }
        }
    }

    /**
     * 数据分割成不超过 MAX_LENGTH的数据
     *
     * @param str 需要分割的数据
     * @return 分割后的数组
     */
    private fun splitStr(str: String): Array<String?> {
        //字符串长度
        val length = str.length
        //返回的数组
        val strs = arrayOfNulls<String>(length / MAX_LENGTH + 1)
        //
        var start = 0
        for (i in strs.indices) {
            //判断是否达到最大长度
            if (start + MAX_LENGTH < length) {
                strs[i] = str.substring(start, start + MAX_LENGTH)
                start += MAX_LENGTH
            } else {
                strs[i] = str.substring(start, length)
                start = length
            }
        }
        return strs
    }

    /**
     * 格式化
     *
     * @param jsonStr json数据
     * @return 格式化后的json数据
     * @author lizhgb
     * @link https://my.oschina.net/jasonli0102/blog/517052
     */
    private fun formatJson(jsonStr: String?): String {
        if (null == jsonStr || "" == jsonStr) return ""
        val sb = StringBuilder()
        var last: Char
        var current = '\u0000'
        var indent = 0
        var isInQuotationMarks = false
        for (i in 0 until jsonStr.length) {
            last = current
            current = jsonStr[i]
            when (current) {
                '"' -> {
                    if (last != '\\') {
                        isInQuotationMarks = !isInQuotationMarks
                    }
                    sb.append(current)
                }
                '{', '[' -> {
                    sb.append(current)
                    if (!isInQuotationMarks) {
                        sb.append('\n')
                        indent++
                        addIndentBlank(sb, indent)
                    }
                }
                '}', ']' -> {
                    if (!isInQuotationMarks) {
                        sb.append('\n')
                        indent--
                        addIndentBlank(sb, indent)
                    }
                    sb.append(current)
                }
                ',' -> {
                    sb.append(current)
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n')
                        addIndentBlank(sb, indent)
                    }
                }
                else -> sb.append(current)
            }
        }
        return sb.toString()
    }

    /**
     * 在 StringBuilder指定位置添加 space
     *
     * @param sb     字符集
     * @param indent 添加位置
     * @author lizhgb
     * @link https://my.oschina.net/jasonli0102/blog/517052
     */
    private fun addIndentBlank(sb: StringBuilder, indent: Int) {
        for (i in 0 until indent) {
            sb.append('\t')
        }
    }
}