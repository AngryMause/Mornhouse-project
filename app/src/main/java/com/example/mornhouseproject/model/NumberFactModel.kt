package com.example.mornhouseproject.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize

@Parcelize
data class NumberFactModel(
    var id: Long,
    var number: Long,
    var fact: String,
) : Parcelable {
    object ResponseDifUtil : DiffUtil.ItemCallback<NumberFactModel>() {
        override fun areItemsTheSame(oldItem: NumberFactModel, newItem: NumberFactModel): Boolean {
            return oldItem.fact.hashCode() == newItem.fact.hashCode()
        }

        override fun areContentsTheSame(
            oldItem: NumberFactModel,
            newItem: NumberFactModel,
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

}
