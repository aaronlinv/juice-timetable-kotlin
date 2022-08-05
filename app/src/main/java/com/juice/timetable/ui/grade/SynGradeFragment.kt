package com.juice.timetable.ui.grade

import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.juice.timetable.R
import com.juice.timetable.api.URI_SYNGRADE
import com.juice.timetable.data.parse.ParseGrade
import com.juice.timetable.data.source.SynGrade
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.databinding.FragmentSynGradeBinding
import com.juice.timetable.repo.GradeRepository
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.viewmodel.GradeViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SynGradeFragment : Fragment() {
    private var _binding: FragmentSynGradeBinding? = null
    private val binding get() = _binding!!
    private lateinit var gradeRepository: GradeRepository
    private lateinit var synGradeRecycleViewAdapter: SynGradeRecycleViewAdapter
    private var filterSynList: LiveData<List<SynGrade>>? = null


    private val gradeViewModel: GradeViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSynGradeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        gradeRepository = GradeRepository(JuiceDatabase.getDatabase(requireActivity()))

        binding.synRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        synGradeRecycleViewAdapter = SynGradeRecycleViewAdapter()
        binding.synRecyclerView.adapter = synGradeRecycleViewAdapter

        //获取数据
        getSynGradeData()
        initSearchView()

        return root
    }

    private fun getSynGradeData() {
        CoroutineScope(Dispatchers.Main).launch {
            binding.synRefresh.isRefreshing = true
            try {
                //先清空表
                gradeViewModel.deleteAllSyn()
                gradeViewModel.deleteAllCredit()
                val source = gradeRepository.getGradeInfo(URI_SYNGRADE)
                if (source.contains(resources.getString(R.string.need_evaluation))) {
                    binding.synRefresh.isRefreshing = false
                    ToastyUtils.warn(
                        requireActivity(),
                        resources.getString(R.string.need_evaluation)
                    )
                    return@launch
                }

                val synArrayList = ParseGrade.parseSynGrade(source)
                val creditArrayList = ParseGrade.parseCredits(source)
                LogUtils.d("synArrayList--> $synArrayList")
                LogUtils.d("creditArrayList--> $creditArrayList")

                gradeViewModel.addAllSyn(synArrayList)
                gradeViewModel.addAllCredit(creditArrayList)
                LogUtils.d("gradeViewModel插入数据成功")


                gradeViewModel.synGradeLive.observe(viewLifecycleOwner) {
                    synGradeRecycleViewAdapter.synArrayList = it
                    synGradeRecycleViewAdapter.notifyDataSetChanged()
                }
            } catch (e: Exception) {
                val message: String = e.message.toString()
                ToastyUtils.warn(requireActivity(), message)
                return@launch
            }
            binding.synRefresh.isRefreshing = false
        }

    }

    private fun initSearchView() {
        binding.swSyn.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            //确定时候改变
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(pattern: String): Boolean {
                gradeViewModel.viewModelScope.launch {
                    filterSynList = gradeViewModel.findNameWithPattern(pattern)
                    filterSynList?.observe(viewLifecycleOwner) {
                        synGradeRecycleViewAdapter.synArrayList = it
                        synGradeRecycleViewAdapter.notifyDataSetChanged()
                    }
                }
                return false
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        refresh()
    }

    private fun refresh() {
        // 下拉刷新监听
        binding.synRefresh.setOnRefreshListener() {
            getSynGradeData()
            ToastyUtils.s(requireActivity(), resources.getString(R.string.refresh_success))
        }
    }

}