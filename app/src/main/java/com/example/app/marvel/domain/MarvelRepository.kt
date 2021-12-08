package com.example.app.marvel.domain

import com.example.app.marvel.data.State
import com.example.app.marvel.data.remote.response.CharacterDto
import com.example.app.marvel.data.remote.response.ComicsDto
import com.example.app.marvel.data.remote.response.CreatorDto
import com.example.app.marvel.domain.models.*
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

    fun getAllCharacters(): Flow<List<Character>>

    suspend fun refreshCharacters()

    fun getAllComics(): Flow<List<Comic>>

    suspend fun refreshComics()

    fun getAllCreators(): Flow<List<Creator>>

    suspend fun refreshCreators()

    fun getRecentSearches(): Flow<List<Searches>>

    suspend fun addSearch(search: Searches)

    fun getSeries(): Flow<List<Series>>

    suspend fun refersSeries(limit: Int = 20)

    fun getEvents(): Flow<List<Event>>

    suspend fun refersEvents(limit: Int = 20)

    fun searchCreator(searchKeyWord: String): Flow<State<List<Searches?>>>

    fun searchCharacter(searchKeyWord: String): Flow<State<List<Searches?>>>

    suspend fun getSearchesItemById(searchesId: Int): Searches

    fun getCharacterById(characterId: Int): Flow<State<List<CharacterDto>?>>

    fun getComicById(comicId: Int): Flow<State<List<ComicsDto>?>>

    fun getCreatorById(creatorId: Int): Flow<State<List<CreatorDto>?>>

}