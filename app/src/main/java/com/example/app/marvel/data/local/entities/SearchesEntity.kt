package com.example.app.marvel.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class SearchesEntity (
    @PrimaryKey val id: Int,
    val imageUrl: String,
    val date: Date,
    val type: String
)