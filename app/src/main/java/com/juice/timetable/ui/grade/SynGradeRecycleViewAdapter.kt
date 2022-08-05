package com.juice.timetable.ui.grade

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.juice.timetable.R
import com.juice.timetable.data.source.SynGrade
import java.util.regex.Pattern

class SynGradeRecycleViewAdapter() : RecyclerView.Adapter<SynGradeRecycleViewAdapter.SynGradeViewHolder>() {
    var synArrayList: List<SynGrade> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SynGradeViewHolder {
        return SynGradeViewHolder.from(parent, viewType)
    }

    override fun onBindViewHolder(holder: SynGradeViewHolder, position: Int) {
        if (synArrayList.isNotEmpty()) {
            val year: TextView = holder.itemView.findViewById(R.id.tv_syn_year)
            val gradeName: TextView = holder.itemView.findViewById(R.id.tv_syn_grade_name)
            val grade: TextView = holder.itemView.findViewById(R.id.tv_syn_grade)
            holder.bind(year, gradeName, grade, synArrayList[position])
        }
    }

    override fun getItemCount(): Int {
        return if (synArrayList.isEmpty()) {
            1
        } else synArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (synArrayList.isEmpty()) {
            0
        } else 1
    }

    class SynGradeViewHolder private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(
            year: TextView,
            gradeName: TextView,
            grade: TextView,
            syn: SynGrade
        ) {
            year.text = syn.couYear
            gradeName.text = syn.couName
            grade.text = syn.couGrade

            if (!isContainChinese(syn.couGrade)) {
                if (syn.couGrade!!.toInt() < 60) {
                    grade.setTextColor(Color.RED)
                } else if (syn.couGrade!!.toInt() < 90) {
                    grade.setTextColor(Color.BLUE)
                }
            }

            // 点击显示完成信息
            itemView.setOnClickListener {
                SweetAlertDialog(itemView.context, SweetAlertDialog.NORMAL_TYPE)
                    .setTitleText(syn.couName)
                    .setTitleText(syn.couName)
                    .setContentText(
                        "学期：" + syn.couYear
                                + "<br>课程学分：" + syn.courseCredit
                                + "<br>成绩：" + syn.couGrade
                                + "<br>绩点：" + syn.gradePoint
                                + "<br>获得学分：" + syn.obtainCredit
                                + "<br>考试类型：" + syn.examType
                                + "<br>选修类型：" + syn.optionalCourseType
                    )
                    .hideConfirmButton()
                    .show()
            }
        }

        fun isContainChinese(str: String?): Boolean {
            val p = Pattern.compile("[\u4e00-\u9fa5]")
            val m = p.matcher(str)
            return m.find()
        }

        companion object {
            fun from(parent: ViewGroup, viewType: Int): SynGradeViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val layoutNumber: Int = if (viewType == 0) {
                    R.layout.empty_recyclerview
                } else {
                    R.layout.cell_syngrade
                }
                val root = layoutInflate.inflate(layoutNumber, parent, false)
                return SynGradeViewHolder(root)
            }
        }
    }
}