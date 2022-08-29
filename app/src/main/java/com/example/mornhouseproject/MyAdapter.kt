package com.example.mornhouseproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mornhouseproject.databinding.ItemAdapterBinding
import com.example.mornhouseproject.model.ResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.runInterruptible
import kotlinx.coroutines.withContext

class MyAdapter : ListAdapter<ResponseModel, MyAdapter.MyHolder>(ResponseModel.ResponseDifUtil) {

    class MyHolder(private val binding: ItemAdapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fact: String) {
            binding.factTv.text = fact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAdapterBinding.inflate(inflater, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(getItem(position).number)

    }


}