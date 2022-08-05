package com.juice.timetable.ui.grade

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.juice.timetable.R
import com.juice.timetable.data.source.Credit

class CreditRecycleViewAdapter :
    RecyclerView.Adapter<CreditRecycleViewAdapter.CreditGradeViewHolder>() {
    var creditArrayList: List<Credit> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CreditGradeViewHolder {
        return CreditGradeViewHolder.from(parent, viewType)
    }

    override fun onBindViewHolder(holder: CreditGradeViewHolder, position: Int) {
        if (creditArrayList.isNotEmpty()) {
            val optionalCourseTypeCredits: TextView = holder.itemView.findViewById(R.id.tv_type_credits)
            val coursesCompletedCredits: TextView = holder.itemView.findViewById(R.id.tv_completed_credits)
            val takeHomeCredits: TextView = holder.itemView.findViewById(R.id.tv_take_credits)
            holder.bind(
                optionalCourseTypeCredits,
                coursesCompletedCredits,
                takeHomeCredits,
                creditArrayList[position]
            )
        }
    }

    override fun getItemCount(): Int {
        return if (creditArrayList.isEmpty()) {
            1
        } else creditArrayList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (creditArrayList.isEmpty()) {
            0
        } else 1
    }

    class CreditGradeViewHolder private constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        fun bind(
            optionalCourseTypeCredits: TextView,
            coursesCompletedCredits: TextView,
            takeHomeCredits: TextView,
            cre: Credit
        ) {
            optionalCourseTypeCredits.text = cre.optionalCourseTypeCredits
            coursesCompletedCredits.text = cre.coursesCompletedCredits
            takeHomeCredits.text = cre.takeHomeCredits
        }

        companion object {
            fun from(parent: ViewGroup, viewType: Int): CreditGradeViewHolder {
                val layoutInflate = LayoutInflater.from(parent.context)
                val layoutNumber: Int = if (viewType == 0) {
                    R.layout.empty_recyclerview
                } else {
                    R.layout.cell_credit
                }
                val root = layoutInflate.inflate(layoutNumber, parent, false)
                return CreditGradeViewHolder(root)
            }
        }

    }

}