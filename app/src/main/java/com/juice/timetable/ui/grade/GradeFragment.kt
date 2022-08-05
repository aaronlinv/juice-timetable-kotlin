package com.juice.timetable.ui.grade

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.juice.timetable.databinding.FragmentGradeBinding


class GradeFragment : Fragment() {
    private var _binding: FragmentGradeBinding? = null
    private val binding get() = _binding!!
    private val titleList = mutableListOf<String>("综合成绩", "统考成绩", "学分")
    private val fragmentList = mutableListOf<Fragment>(
        SynGradeFragment(), UniGradeFragment(),CreditFragment()
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGradeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val adapter = GradeFragmentAdapter(requireActivity(), fragmentList, titleList)
        binding.vpGrade.adapter = adapter

        TabLayoutMediator(
            binding.tabgrade, binding.vpGrade
        ) { tab, position -> tab.text = titleList[position] }.attach()

        return root
    }

}