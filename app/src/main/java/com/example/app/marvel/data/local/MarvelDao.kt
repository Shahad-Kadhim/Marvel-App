package com.example.app.marvel.data.local

import androidx.room.*
import com.example.app.marvel.data.local.entities.CharacterEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MarvelDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCharacter(items: List<CharacterEntity>)

    @Query("SELECT * FROM CharacterEntity")
    fun getAllCharacter(): Flow<List<CharacterEntity>>
}