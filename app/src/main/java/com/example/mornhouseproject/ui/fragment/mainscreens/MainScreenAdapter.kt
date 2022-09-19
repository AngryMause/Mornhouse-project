package com.example.mornhouseproject.ui.fragment.mainscreens

import android.view.LayoutInflater
import android.view.View
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
        fun bind(numberFact: NumberFactModel) {
            binding.factTv.text = numberFact.fact
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAdapterBinding.inflate(inflater, parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val numberFactList = getItem(position)
        with(holder) {
            bind(numberFactList)

        }
        holder.itemView.apply {
            setOnClickListener {
                myListener.let {
                    it?.invoke(numberFactList)
                }
            }
        }
    }


    private var myListener: ((NumberFactModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (NumberFactModel) -> Unit) {
        myListener = listener
    }


}






