package com.example.app.marvel.data.local.entities

import androidx.room.*

@Entity
data class CharacterEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val dataModify: String
)
