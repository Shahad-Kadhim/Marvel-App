package com.example.app.marvel.data.remote

import com.example.app.marvel.data.remote.response.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET


interface MarvelService{

    @GET("characters")
    suspend fun getCharacters(): Response<CharacterResponse>


}