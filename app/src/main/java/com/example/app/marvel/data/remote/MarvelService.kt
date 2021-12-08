package com.example.app.marvel.data.remote

import com.example.app.marvel.data.remote.response.*
import retrofit2.Response
import retrofit2.http.*


interface MarvelService{

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") numberOfCharacters: Int = 20,
        @Query("nameStartsWith") searchKeyWord: String = " ",

    ): Response<MarvelResponse<CharacterDto>>


    @GET("comics")
    suspend fun getComics(
        @Query("limit") numberOfCharacters: Int = 20,
        ): Response<MarvelResponse<ComicsDto>>


    @GET("creators")
    suspend fun getCreators(
        @Query("limit") numberOfCharacters: Int = 20,
        @Query("nameStartsWith") searchKeyWord: String = " ",
        ): Response<MarvelResponse<CreatorDto>>


    @GET("series")
    suspend fun getSeries(
        @Query("limit") numberOfCharacters: Int = 20,
        ): Response<MarvelResponse<SeriesDto>>


    @GET("events")
    suspend fun getEvent(
        @Query("limit") numberOfCharacters: Int = 20,
        @Query("name") searchKeyWord: String = " ",
        ): Response<MarvelResponse<EventDto>>


}