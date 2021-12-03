package com.example.app.marvel.data.local.entities

import androidx.room.*

@Entity
data class ComicEntity(
    @PrimaryKey val id: Int,
    var title: String?,
    var description: String?,
    var imageUrl: String,
    var lastDateModify: String
)
