package com.example.app.marvel.data.remote

import com.example.app.marvel.data.remote.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.*


interface MarvelService{

    @GET("characters")
    suspend fun getCharacters(
        @Query("limit") numberOfCharacters: Int = 20
    ): Response<CharacterResponse>


}