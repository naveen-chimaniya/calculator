package com.example.calculatorassignment.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calculatorassignment.databinding.ItemHistoryBinding
import javax.inject.Inject

class HistoryAdapter @Inject constructor()  : RecyclerView.Adapter<HistoryAdapter.HistoryVH>() {

    var historyList = arrayListOf<String>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryVH {
        return HistoryVH(
            ItemHistoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryVH, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount(): Int {
        return historyList.size
    }


    class HistoryVH(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(history: String) {
            binding.tvLabelHistory.text = history
        }
    }
}