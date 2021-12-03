package com.example.app.marvel.di

import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.data.local.MarvelDao
import com.example.app.marvel.data.local.mappers.CharacterEntityMapper
import com.example.app.marvel.data.remote.*
import com.example.app.marvel.domain.mappers.CharacterMapper
import dagger.*
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        apiService: MarvelService,
        dao: MarvelDao,
        characterEntityMapper: CharacterEntityMapper,
        characterMapper: CharacterMapper
    ) :MarvelRepository = MarvelRepositoryImp(dao,apiService,characterEntityMapper,characterMapper)


    @Singleton
    @Provides
    fun provideCharacterEntityMapper(): CharacterEntityMapper = CharacterEntityMapper()

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

}