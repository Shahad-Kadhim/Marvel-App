package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class CharacterDataContainer(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("limit")
    val limit: Int? = null,
    @SerializedName("offset")
    val offset: Int? = null,
    @SerializedName("results")
    val character: List<CharacterDto>? = null,
    @SerializedName("total")
    val total: Int? = null
)