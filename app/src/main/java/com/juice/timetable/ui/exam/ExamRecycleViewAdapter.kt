package com.juice.timetable.ui.exam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.juice.timetable.R
import com.juice.timetable.data.source.Exam


class ExamRecycleViewAdapter() : RecyclerView.Adapter<ExamRecycleViewAdapter.ExamViewHolder>() {
    var examArrayList: List<Exam> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamViewHolder {
        return ExamViewHolder.from(parent, viewType)
    }

    override fun onBindViewHolder(holder: ExamViewHolder, position: Int) {
        if (examArrayList.isNotEmpty()) {
            val examSemester: TextView = holder.itemView.findViewById(R.id.tv_exam_semester)
            val courseName: TextView = holder.itemView.findViewById(R.id.tv_course_name)
            val arrangement: TextView = holder.itemView.findViewById(R.id.tv_arrangement)
            val examTime: TextView = holder.itemView.findViewById(R.id.tv_exam_time)
            holder.bind(examSemester, courseName, arrangement, examTime, examArrayList[position])
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (examArrayList.isEmpty()) {
            0
        } else 1
    }

    override fun getItemCount(): Int {
        return if (examArrayList.isEmpty()) {
            1
        } else examArrayList.size
    }

    class ExamViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(
            examSemester: TextView,
            courseName: TextView,
            arrangement: TextView,
            examTime: TextView,
            exam: Exam
        ) {
            examSemester.text = exam.semester
            courseName.text = exam.courseName
            arrangement.text = exam.arrangement
            examTime.text = exam.examTime

            // 点击显示完成信息
            itemView.setOnClickListener {
                SweetAlertDialog(itemView.context, SweetAlertDialog.NORMAL_TYPE)
                    .setTitleText(exam.courseName)
                    .setContentText(
                        "开课学期：" + exam.semester
                            .toString() + "<br>考试类型：" + exam.examTime
                            .toString() + "<br>考试类别：" + exam.examCategory
                            .toString() + "<br>考试时间：" + exam.examTime
                            .toString() + "<br>考场安排：" + exam.arrangement
                            .toString() + "<br>班级：" + exam.classGrade
                    )
                    .hideConfirmButton()
                    .show()
            }
        }

        companion object {
            fun from(parent: ViewGroup, viewType: Int): ExamViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val layoutNumber: Int = if (viewType == 0) {
                    R.layout.empty_recyclerview
                } else {
                    R.layout.cell_exam
                }
                val root = layoutInflate.inflate(layoutNumber, parent, false)
                return ExamViewHolder(root)
            }
        }
    }
}

