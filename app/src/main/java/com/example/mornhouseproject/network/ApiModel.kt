package com.example.mornhouseproject.network

import com.google.gson.annotations.SerializedName

data class ApiModel(
    @SerializedName("text")
    val text: String,
    @SerializedName("number")
    val number: Long,
    @SerializedName("found")
    val found: Boolean,
    @SerializedName("type")
    val trivial: String,
)



