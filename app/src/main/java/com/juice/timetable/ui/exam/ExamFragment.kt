package com.juice.timetable.ui.exam

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.juice.timetable.CUR_SEMESTER
import com.juice.timetable.R
import com.juice.timetable.api.URI_EXAM
import com.juice.timetable.data.parse.ParseExam
import com.juice.timetable.data.source.Exam
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.dataStore
import com.juice.timetable.databinding.FragmentExamBinding
import com.juice.timetable.repo.ExamRepository
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.utils.ToastyUtils
import com.juice.timetable.viewmodel.ExamViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory
import com.juice.timetable.viewmodel.StuInfoViewModel
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*


class ExamFragment : Fragment() {
    private var _binding: FragmentExamBinding? = null
    private val binding get() = _binding!!
    private val mItemsYear = arrayOfNulls<String>(4)
    private val mItemsType = arrayOf("上", "下")
    private var year: String = ""
    private var type: String = ""
    private var stuIDStr: String = ""
    private var stuID: Int = 0
    private var filterExamList: LiveData<List<Exam>>? = null
    private lateinit var examRepository: ExamRepository
    private lateinit var examRecycleViewAdapter: ExamRecycleViewAdapter

    private val examViewModel: ExamViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }
    private val stuInfoViewModel: StuInfoViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Refresh()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExamBinding.inflate(inflater, container, false)
        val root: View = binding.root
        examRepository = ExamRepository(JuiceDatabase.getDatabase(requireActivity()))

        //布局管理器
        binding.examRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        examRecycleViewAdapter = ExamRecycleViewAdapter()
        binding.examRecyclerView.adapter = examRecycleViewAdapter

        initSpinner()
        shiftSemester()

        //开启搜索
        setHasOptionsMenu(true)

        return root
    }

    override fun onStart() {
        super.onStart()
        filterExamList = examViewModel.examLive
        LogUtils.d("onStart,filterExamList--> $filterExamList")

        filterExamList?.observe(viewLifecycleOwner) {
            LogUtils.d("onStart,exams--> $it")
            examRecycleViewAdapter.examArrayList = it
            examRecycleViewAdapter.notifyDataSetChanged()
        }
        binding.examRefresh.isRefreshing = false
    }

    private fun getExamInfo(year: String, type: String) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                //先清空表
                examViewModel.deleteAllExam()
                val source = examRepository.getExamInfo(URI_EXAM, year, type)
                val examArrayList = ParseExam.parseExam(source)
                //调转
                Collections.reverse(examArrayList)
                //再插入数据库
                examViewModel.addAllExam(examArrayList)
                LogUtils.d("examArrayList--> $examArrayList")

            } catch (e: Exception) {
                val message: String = e.message.toString()
                ToastyUtils.warn(requireActivity(), message)
                return@launch
            }

            binding.examRefresh.isRefreshing = false
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(com.juice.timetable.R.menu.exam_bar, menu)
        val searchView =
            menu.findItem(com.juice.timetable.R.id.app_bar_exam_search).actionView as SearchView
        searchView.maxWidth = 1000
        searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener {
                //确定时候改变
                override fun onQueryTextSubmit(query: String): Boolean {
                    return false
                }

                override fun onQueryTextChange(pattern: String): Boolean {
                    filterExamList?.removeObservers(requireActivity())
                    examViewModel.viewModelScope.launch {
                        filterExamList = examViewModel.findNameWithPattern(pattern)
                        filterExamList?.observe(requireActivity()) {
                            LogUtils.d("onQueryTextChange,exams--> $it")
                            examRecycleViewAdapter.examArrayList = it
                            examRecycleViewAdapter.notifyDataSetChanged()
                        }
                    }
                    return true
                }
            })
    }

    private fun Refresh() {
        binding.examRefresh.isRefreshing = true
        // 下拉刷新监听
        binding.examRefresh.setOnRefreshListener() {
            getExamInfo(year, type)
            ToastyUtils.s(
                requireActivity(), resources.getString(R.string.refresh_success)
            )
        }

    }

    private fun initSpinner() {
        CoroutineScope(Dispatchers.Main).launch {
            withContext(Dispatchers.IO) {
                //获取学号
                stuIDStr = stuInfoViewModel.getStuInfo()!!.stuID.toString().substring(2, 4)
                stuID = stuIDStr.toInt()
                //初始化year、type
                requireActivity().dataStore.data.map {
                    year = it[CUR_SEMESTER] ?: "20$stuIDStr"
                    type = it[CUR_SEMESTER] ?: ""
                    year = year.substring(9, 13)
                    type = type.substring(13, 14)
                }.firstOrNull()

                LogUtils.d("stuIDStr--> $stuIDStr")
                LogUtils.d("year--> $year")
                LogUtils.d("type--> $type")

                for (i in 0..3) {
                    mItemsYear[i] = "20$stuID"
                    stuID++
                }
            }
            val adapterYear: ArrayAdapter<String> =
                ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    mItemsYear
                )
            adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            val adapterType: ArrayAdapter<String> =
                ArrayAdapter<String>(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    mItemsType
                )
            adapterYear.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spExamYear.adapter = adapterYear
            binding.spExamType.adapter = adapterType

            //初始化时间为当前学期
            var location = 0
            for (i in 0..3) {
                if (mItemsYear[i] == year) {
                    location = i
                }
            }
            binding.spExamYear.setSelection(location)
            for (i in 0..1) {
                if (mItemsType[i] == type) {
                    location = i
                }
            }
            binding.spExamType.setSelection(location)
        }
    }

    // 学期学年切换
    private fun shiftSemester() {
        binding.spExamYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                val tv = view as TextView
                tv.textSize = 16f
                year = mItemsYear[position].toString()
                binding.examRefresh.isRefreshing = true

                getExamInfo(year, type)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        binding.spExamType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View,
                position: Int,
                id: Long
            ) {
                val tv = view as TextView
                tv.textSize = 16f
                type = mItemsType[position]
                binding.examRefresh.isRefreshing = true
                getExamInfo(year, type)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {}

        }
    }
}


