package com.example.app.marvel.data.remote

import com.example.app.marvel.data.remote.response.*
import retrofit2.Response
import retrofit2.http.*


interface MarvelService{

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") numberOfCharacters: Int = 20,
        @Query("nameStartsWith") searchKeyWord: String? = null,

    ): Response<MarvelResponse<CharacterDto>>


    @GET("comics")
    suspend fun getComics(
        @Query("limit") numberOfCharacters: Int = 20,
        ): Response<MarvelResponse<ComicsDto>>


    @GET("creators")
    suspend fun getCreators(
        @Query("limit") numberOfCharacters: Int = 20,
        @Query("nameStartsWith") searchKeyWord: String? = null,
        ): Response<MarvelResponse<CreatorDto>>


    @GET("series")
    suspend fun getSeries(
        @Query("limit") numberOfCharacters: Int = 20,
        ): Response<MarvelResponse<SeriesDto>>


    @GET("events")
    suspend fun getEvent(
        @Query("limit") numberOfCharacters: Int = 20,
        ): Response<MarvelResponse<EventDto>>

    @GET("characters/{characterId}")
    suspend fun getCharacterById(
        @Path("characterId") characterId: Int
        ): Response<MarvelResponse<CharacterDto>>


    @GET("creators/{creatorId}")
    suspend fun getCreatorById(
        @Path("creatorId") creatorId: Int
        ): Response<MarvelResponse<CreatorDto>>


    @GET("comics/{comicId}")
    suspend fun getComicById(
        @Path("comicId") comicId: Int
        ): Response<MarvelResponse<ComicsDto>>


}