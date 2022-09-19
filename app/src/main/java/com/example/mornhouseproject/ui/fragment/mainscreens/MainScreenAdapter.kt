package com.example.mornhouseproject.ui.fragment.mainscreens

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mornhouseproject.databinding.ItemAdapterBinding
import com.example.mornhouseproject.model.NumberFactModel

class MainScreenAdapter() :
    ListAdapter<NumberFactModel, MainScreenAdapter.MyHolder>(NumberFactModel.ResponseDifUtil) {

    class MyHolder(private val binding: ItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fact: NumberFactModel) {
            binding.factTv.text = fact.fact
            binding.factTv.setOnClickListener {
                val action = MainScreenFragmentDirections.actionMainFragmentToSecondFragment(fact)
                itemView.findNavController().navigate(action)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAdapterBinding.inflate(inflater, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val numberFactList = getItem(position)
        holder.bind(numberFactList)
    }


}




