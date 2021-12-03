package com.example.app.marvel.di

import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.data.local.MarvelDao
import com.example.app.marvel.data.local.mappers.*
import com.example.app.marvel.data.remote.*
import com.example.app.marvel.domain.mappers.*
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
        characterMapper: CharacterMapper,
        comicEntityMapper: ComicEntityMapper,
        comicMapper: ComicMapper,
        creatorEntityMapper: CreatorEntityMapper,
        creatorMapper: CreatorMapper,
        searchesMapper: SearchesMapper
    ) :MarvelRepository = MarvelRepositoryImp(
        dao,
        apiService,
        characterEntityMapper,
        characterMapper,
        comicEntityMapper,
        comicMapper,
        creatorEntityMapper,
        creatorMapper,
        searchesMapper
    )


    @Singleton
    @Provides
    fun provideCharacterEntityMapper(): CharacterEntityMapper = CharacterEntityMapper()

    @Singleton
    @Provides
    fun provideCharacterMapper(): CharacterMapper = CharacterMapper()

    @Singleton
    @Provides
    fun provideComicEntityMapper(): ComicEntityMapper = ComicEntityMapper()

    @Singleton
    @Provides
    fun provideComicMapper(): ComicMapper = ComicMapper()

    @Singleton
    @Provides
    fun provideCreatorEntityMapper(): CreatorEntityMapper = CreatorEntityMapper()

    @Singleton
    @Provides
    fun provideCreatorMapper(): CreatorMapper = CreatorMapper()

    @Singleton
    @Provides
    fun provideSearchesMapper(): SearchesMapper = SearchesMapper()

}