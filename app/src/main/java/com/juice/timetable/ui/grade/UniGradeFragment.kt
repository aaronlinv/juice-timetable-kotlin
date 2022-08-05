package com.juice.timetable.ui.grade

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.juice.timetable.R
import com.juice.timetable.api.URI_UNIGRADE
import com.juice.timetable.data.parse.ParseGrade
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.databinding.FragmentUniGradeBinding
import com.juice.timetable.repo.GradeRepository
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.viewmodel.GradeViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class UniGradeFragment : Fragment() {
    private var _binding: FragmentUniGradeBinding? = null
    private val binding get() = _binding!!
    private lateinit var gradeRepository: GradeRepository
    private lateinit var uniGradeRecycleViewAdapter: UniGradeRecycleViewAdapter

    private val gradeViewModel: GradeViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUniGradeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        gradeRepository = GradeRepository(JuiceDatabase.getDatabase(requireActivity()))

        binding.uniRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        uniGradeRecycleViewAdapter = UniGradeRecycleViewAdapter()
        binding.uniRecyclerView.adapter = uniGradeRecycleViewAdapter

        getUniGradeData()

        return root
    }

    private fun getUniGradeData() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.uniRefresh.isRefreshing = true
            try {
                //先清空表
                gradeViewModel.deleteAllUni()
                val source = gradeRepository.getGradeInfo(URI_UNIGRADE)
                val uniArrayList = ParseGrade.parseUniGrade(source)
                LogUtils.d("uniArrayList--> $uniArrayList")

                gradeViewModel.addAllUni(uniArrayList)
                LogUtils.d("gradeViewModel插入数据成功")

                gradeViewModel.uniGradeLive.observe(viewLifecycleOwner) {
                    uniGradeRecycleViewAdapter.uniArrayList = it
                    uniGradeRecycleViewAdapter.notifyDataSetChanged()
                }
            } catch (e: Exception) {
                val message: String = e.message.toString()
                ToastyUtils.warn(requireActivity(), message)
                return@launch
            }
            binding.uniRefresh.isRefreshing = false
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh()
    }

    private fun refresh() {
        // 下拉刷新监听
        binding.uniRefresh.setOnRefreshListener() {
            getUniGradeData()
            ToastyUtils.s(requireActivity(), resources.getString(R.string.refresh_success))
        }

    }

}