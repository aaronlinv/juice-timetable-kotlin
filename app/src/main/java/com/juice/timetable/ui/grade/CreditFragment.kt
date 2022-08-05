package com.juice.timetable.ui.grade

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.juice.timetable.data.source.local.JuiceDatabase
import com.juice.timetable.databinding.FragmentCreditBinding
import com.juice.timetable.repo.GradeRepository
import com.juice.timetable.viewmodel.GradeViewModel
import com.juice.timetable.viewmodel.JuiceViewModelFactory


class CreditFragment : Fragment() {
    private var _binding: FragmentCreditBinding? = null
    private val binding get() = _binding!!
    private lateinit var gradeRepository: GradeRepository
    private lateinit var creditRecycleViewAdapter: CreditRecycleViewAdapter

    private val gradeViewModel: GradeViewModel by activityViewModels {
        JuiceViewModelFactory(
            requireActivity().application
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreditBinding.inflate(inflater, container, false)
        val root: View = binding.root
        gradeRepository = GradeRepository(JuiceDatabase.getDatabase(requireActivity()))

        binding.rwCredit.layoutManager = LinearLayoutManager(requireContext())
        creditRecycleViewAdapter = CreditRecycleViewAdapter()
        binding.rwCredit.adapter = creditRecycleViewAdapter
        getCreditData()

        return root
    }

    private fun getCreditData() {
        gradeViewModel.creditLive.observe(viewLifecycleOwner) {
            creditRecycleViewAdapter.creditArrayList = it
            creditRecycleViewAdapter.notifyDataSetChanged()
        }


    }


}