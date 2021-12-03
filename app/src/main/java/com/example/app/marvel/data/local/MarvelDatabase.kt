package com.example.app.marvel.data.local

import androidx.room.*
import com.example.app.marvel.data.local.entities.CharacterEntity
import com.example.app.marvel.data.local.entities.ComicEntity


@Database(entities = [CharacterEntity::class, ComicEntity::class], version = 1)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun productsDao(): MarvelDao

}