package com.example.calculatorassignment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.calculatorassignment.R
import com.example.calculatorassignment.databinding.FragmentHistoryListBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HistoryListFragment : BottomSheetDialogFragment() {

    companion object {
        fun createInstance(historyList: ArrayList<String>) = HistoryListFragment().apply {
            arguments = Bundle().apply {
                putStringArrayList("historyList", historyList)
            }
        }
    }

    @Inject
    lateinit var adapter: HistoryAdapter

    private lateinit var binding: FragmentHistoryListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_history_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvHistory.adapter = adapter
        adapter.historyList = arguments?.getStringArrayList("historyList")!!
    }
}