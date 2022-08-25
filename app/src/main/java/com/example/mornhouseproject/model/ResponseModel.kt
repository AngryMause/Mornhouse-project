package com.example.mornhouseproject.model

import androidx.recyclerview.widget.DiffUtil


data class ResponseModel(var number: String) {

    object ResponseDifUtil : DiffUtil.ItemCallback<ResponseModel>() {
        override fun areItemsTheSame(oldItem: ResponseModel, newItem: ResponseModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ResponseModel, newItem: ResponseModel): Boolean {
            return oldItem == newItem
        }
    }
}
