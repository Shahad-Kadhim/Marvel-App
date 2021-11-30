package com.example.app.marvel.di

import android.content.Context
import androidx.room.Room
import com.example.app.marvel.data.local.MarvelDao
import com.example.app.marvel.data.local.MarvelDatabase
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.*

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDao(database: MarvelDatabase): MarvelDao =
        database.productsDao()


    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context ,
        @Named("databaseName") databaseName :String
    ): MarvelDatabase =
        Room.databaseBuilder(
            context,
            MarvelDatabase::class.java,
            databaseName
        ).build()

    @Provides
    @Named("databaseName")
    fun provideDataBaseName(): String = "MarvelDataBase"

}