package com.example.app.marvel.data.remote.response


import com.google.gson.annotations.SerializedName

data class ComicsDto(
    @SerializedName("characters")
    val characters: Details? = null,
    @SerializedName("collectedIssues")
    val collectedIssues: List<Summary>? = null,
    @SerializedName("collections")
    val collections: List<Any>? = null,
    @SerializedName("creators")
    val creators: Creators? = null,
    @SerializedName("dates")
    val dates: List<Date>? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("diamondCode")
    val diamondCode: String? = null,
    @SerializedName("digitalId")
    val digitalId: Int? = null,
    @SerializedName("ean")
    val ean: String? = null,
    @SerializedName("events")
    val events: Details? = null,
    @SerializedName("format")
    val format: String? = null,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<Thumbnail>? = null,
    @SerializedName("isbn")
    val isbn: String? = null,
    @SerializedName("issn")
    val issn: String? = null,
    @SerializedName("issueNumber")
    val issueNumber: Int? = null,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("pageCount")
    val pageCount: Int? = null,
    @SerializedName("prices")
    val prices: List<Price>? = null,
    @SerializedName("resourceURI")
    val resourceURI: String? = null,
    @SerializedName("series")
    val series: Summary? = null,
    @SerializedName("stories")
    val stories: Stories? = null,
    @SerializedName("textObjects")
    val textObjects: List<TextObject>? = null,
    @SerializedName("thumbnail")
    val thumbnail: Thumbnail? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("upc")
    val upc: String? = null,
    @SerializedName("urls")
    val urls: List<Url>? = null,
    @SerializedName("variantDescription")
    val variantDescription: String? = null,
    @SerializedName("variants")
    val variants: List<Summary>? = null
)