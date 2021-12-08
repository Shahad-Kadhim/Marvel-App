package com.example.app.marvel.data.local.entities

import androidx.room.*

@Entity
data class EventEntity(
    @PrimaryKey val id: Int,
    var title: String,
    var description: String?,
    val imageUrl: String,
    val dataModify: String
)
