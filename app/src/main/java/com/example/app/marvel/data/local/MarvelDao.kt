package com.example.app.marvel.data.local

import androidx.room.*
import com.example.app.marvel.data.local.entities.CharacterEntity
import com.example.app.marvel.data.local.entities.ComicEntity
import com.example.app.marvel.data.local.entities.CreatorEntity
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


}