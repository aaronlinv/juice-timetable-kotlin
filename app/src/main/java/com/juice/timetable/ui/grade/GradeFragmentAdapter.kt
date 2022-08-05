package com.juice.timetable.ui.grade

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class GradeFragmentAdapter(
    fa: FragmentActivity,
    private val fragmentList: List<Fragment>,
    private val CharSequence: List<String>
): FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}