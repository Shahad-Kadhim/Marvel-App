package com.example.app.marvel.data.local

import androidx.room.*
import com.example.app.marvel.data.local.entities.CharacterEntity
import com.example.app.marvel.data.local.entities.ComicEntity
import com.example.app.marvel.data.local.entities.CreatorEntity
import com.example.app.marvel.data.local.entities.SearchesEntity

@TypeConverters(Convertor::class)
@Database(
    entities = [CharacterEntity::class, ComicEntity::class, CreatorEntity::class, SearchesEntity::class],
    version = 1
)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun productsDao(): MarvelDao

}