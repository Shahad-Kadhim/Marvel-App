package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class Summary(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null
)