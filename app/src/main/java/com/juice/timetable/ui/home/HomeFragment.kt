package com.juice.timetable.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.juice.timetable.api.URL_ONE_WEEK
import com.juice.timetable.databinding.FragmentHomeBinding
import com.juice.timetable.repo.EduRepository
import com.juice.timetable.ui.login.LoginViewModel
import com.juice.timetable.utils.LogUtils
import com.juice.timetable.viewmodel.StuInfoViewModel
import com.juice.timetable.viewmodel.StuInfoViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val eduRepository = EduRepository()

    private val stuInfoViewModel: StuInfoViewModel by activityViewModels {
        StuInfoViewModelFactory(
            requireActivity().application
        )
    }

    private val TAG = "HomeFragment"

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(LoginViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textHome.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {

                try {
                    val queryMap = mapOf("week1" to "8")
                    val oneWeek = eduRepository.url(URL_ONE_WEEK, queryMap, requireContext());
                    println(oneWeek)
                } catch (e: Exception) {
                    println(e)
                }
                // val wholeWeek = eduRepository.wholeWeek()
                // println(wholeWeek)
            }
        }
        LogUtils.i("fragment stuInfoViewModel --> $stuInfoViewModel")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}