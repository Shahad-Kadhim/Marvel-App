package com.example.app.marvel.data.local

import androidx.room.*
import com.example.app.marvel.data.local.entities.*

@TypeConverters(Convertor::class)
@Database(
    entities = [
        CharacterEntity::class,
        ComicEntity::class,
        CreatorEntity::class,
        SearchesEntity::class,
        SeriesEntity::class,
        EventEntity::class
               ],
    version = 1
)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun productsDao(): MarvelDao

}