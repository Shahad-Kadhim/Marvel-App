package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class Date(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("type")
    val type: String? = null
)