package com.example.app.marvel.data.local

import androidx.room.*


@Database(entities = [CharacterEntity::class], version = 1)
abstract class MarvelDatabase: RoomDatabase() {

    abstract fun productsDao(): MarvelDao

}