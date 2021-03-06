package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class StoryItem(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("type")
    val type: String? = null
)