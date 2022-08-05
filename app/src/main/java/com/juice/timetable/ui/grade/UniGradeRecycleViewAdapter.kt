package com.juice.timetable.ui.grade

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import cn.pedant.SweetAlert.SweetAlertDialog
import com.juice.timetable.R
import com.juice.timetable.data.source.UniGrade

class UniGradeRecycleViewAdapter :
    RecyclerView.Adapter<UniGradeRecycleViewAdapter.UniGradeViewHolder>() {
    var uniArrayList: List<UniGrade> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UniGradeViewHolder {
        return UniGradeViewHolder.from(parent, viewType)
    }

    override fun onBindViewHolder(holder: UniGradeViewHolder, position: Int) {
        if (uniArrayList.isNotEmpty()) {
            val year: TextView = holder.itemView.findViewById(R.id.tv_uni_year)
            val gradeName: TextView = holder.itemView.findViewById(R.id.tv_uni_name)
            val grade: TextView = holder.itemView.findViewById(R.id.tv_uni_grade)
            val remark: TextView = holder.itemView.findViewById(R.id.tv_uni_remark)
            holder.bind(year, gradeName, grade, remark, uniArrayList[position])
        }
    }

    override fun getItemCount(): Int {
        return if (uniArrayList.isEmpty()) {
            1
        } else uniArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (uniArrayList.isEmpty()) {
            0
        } else 1
    }

    class UniGradeViewHolder private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(
            year: TextView,
            gradeName: TextView,
            grade: TextView,
            remark: TextView,
            uni: UniGrade
        ) {
            year.text = uni.uYear
            gradeName.text = uni.uName
            grade.text = uni.uGrade
            remark.text = uni.uRemarks
            if (uni.uName.equals("cet4") || uni.uName.equals("cet6")) {
                if (uni.uGrade!!.substring(0, 3).toInt() < 425) {
                    grade.setTextColor(Color.RED)
                }
            }


            // 点击显示完成信息
            itemView.setOnClickListener {
                SweetAlertDialog(itemView.context, SweetAlertDialog.NORMAL_TYPE)
                    .setTitleText(uni.uName)
                    .setContentText(
                        "成绩：" + uni.uGrade
                            .toString() + "<br>备注：" + uni.uRemarks
                    )
                    .hideConfirmButton()
                    .show()
            }
        }

        companion object {
            fun from(parent: ViewGroup, viewType: Int): UniGradeViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val layoutNumber: Int = if (viewType == 0) {
                    R.layout.empty_recyclerview
                } else {
                    R.layout.cell_unigrade
                }
                val root = layoutInflate.inflate(layoutNumber, parent, false)
                return UniGradeViewHolder(root)
            }
        }
    }
}