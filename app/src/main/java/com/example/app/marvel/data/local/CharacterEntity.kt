package com.example.app.marvel.data.local

import androidx.room.*

@Entity
data class CharacterEntity(
    @PrimaryKey val id: String,
    val imageUrl: String,
    val name: String,
)
