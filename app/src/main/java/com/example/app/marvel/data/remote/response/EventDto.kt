package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class EventDto(
    @SerializedName("characters")
    val characters: Details? = null,
    @SerializedName("comics")
    val comics: Details? = null,
    @SerializedName("creators")
    val creators: Creators? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("end")
    val end: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("next")
    val next: Next? = null,
    @SerializedName("previous")
    val previous: Previous? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Details? = null,
    @SerializedName("start")
    val start: String? = null,
    @SerializedName("stories")
    val stories: Stories? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String,
    @SerializedName("urls")
    val urls: List<Url>? = null
)