package com.example.app.marvel.data.local.entities

import androidx.room.*
import java.util.*

@Entity
data class SearchesEntity (
    @PrimaryKey val id: Int,
    val imageUrl: String,
    val name: String,
    val date: Date,
    val type: String
)