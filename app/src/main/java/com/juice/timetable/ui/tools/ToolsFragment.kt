package com.juice.timetable.ui.tools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.juice.timetable.R
import com.juice.timetable.databinding.FragmentToolsBinding
import com.juice.timetable.utils.LogUtils

class ToolFragment : Fragment() {
    private var _binding: FragmentToolsBinding? = null
    private val binding get() = _binding!!
    private var toolsRecycleViewAdapter: ToolsRecycleViewAdapter? = null
    private var toolList: MutableList<Tool> = ArrayList()
    private var flag = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentToolsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.toolsRecyclerView.setLayoutManager(LinearLayoutManager(requireContext()))
        toolsRecycleViewAdapter = ToolsRecycleViewAdapter()
        binding.toolsRecyclerView.setAdapter(toolsRecycleViewAdapter)
        initToolsList()
        toolsRecycleViewAdapter!!.toolList = toolList

        return root
    }


    private fun initToolsList() {
        if (!flag) {
            val grade = Tool(resources.getString(R.string.menu_grade), R.drawable.ic_grade)
            val exam = Tool(resources.getString(R.string.menu_exam), R.drawable.ic_exam)
            val expect = Tool(resources.getString(R.string.menu_expect), R.drawable.ic_expect)
            toolList.add(grade)
            toolList.add(exam)
            toolList.add(expect)
            flag = true
        }
    }


}