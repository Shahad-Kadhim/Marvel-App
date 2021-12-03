package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class CreatorItem(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("role")
    val role: String? = null
)