package com.example.app.marvel.data.local

import androidx.room.*
import com.example.app.marvel.data.local.entities.*
import com.example.app.marvel.domain.models.Searches
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(items: List<CharacterEntity>)

    @Query("SELECT * FROM CharacterEntity")
    fun getAllCharacter(): Flow<List<CharacterEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addComic(items: List<ComicEntity>)

    @Query("SELECT * FROM ComicEntity")
    fun getAllComic(): Flow<List<ComicEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCreators(items: List<CreatorEntity>)

    @Query("SELECT * FROM CreatorEntity")
    fun getCreators(): Flow<List<CreatorEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSearch(search: SearchesEntity)

    @Query("SELECT * FROM SearchesEntity ORDER BY date DESC")
    fun getRecentSearches(): Flow<List<SearchesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSeries(series: List<SeriesEntity>)

    @Query("SELECT * FROM SeriesEntity ORDER BY lastDateModify DESC")
    fun getSeries(): Flow<List<SeriesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addEvent(series: List<EventEntity>)

    @Query("SELECT * FROM EventEntity ORDER BY dataModify DESC")
    fun getEvent(): Flow<List<EventEntity>>

    @Query("SELECT * FROM SearchesEntity WHERE id == :searchesId")
    suspend fun getSearchesById(searchesId: Int): SearchesEntity

}