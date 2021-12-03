package com.example.app.marvel.domain

import com.example.app.marvel.domain.models.*
import kotlinx.coroutines.flow.Flow

interface MarvelRepository{

     fun getAllCharacters(): Flow<List<Character>>

    suspend fun refreshCharacters()

     fun getAllComics(): Flow<List<Comic>>

    suspend fun refreshComics()

    fun getAllCreators(): Flow<List<Creator>>

    suspend fun refreshCreators()

    fun getRecentSearches(): Flow<List<Searches>>

    suspend fun addSearch(search:Searches)
}
