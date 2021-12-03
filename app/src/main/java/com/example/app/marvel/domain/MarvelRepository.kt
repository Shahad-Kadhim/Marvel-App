package com.example.app.marvel.domain

import com.example.app.marvel.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MarvelRepository{

     fun getAllCharacters(): Flow<List<Character>>

    suspend fun refreshCharacters()

}
