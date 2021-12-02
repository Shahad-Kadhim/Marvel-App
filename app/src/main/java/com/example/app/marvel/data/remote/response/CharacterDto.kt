package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("comics")
    val comics: Comics? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("events")
    val events: Events? = null,
    @SerializedName("id")
    val id: Int ,
    @SerializedName("modified")
    val modified: String ,
    @SerializedName("name")
    val name: String ,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Series? = null,
    @SerializedName("stories")
    val stories: Stories? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null
)