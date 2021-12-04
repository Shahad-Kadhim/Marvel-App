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
        localMappers: LocalMappers,
        domainMapper: DomainMapper
    ) :MarvelRepository = MarvelRepositoryImp(
        dao,
        apiService,
        localMappers,
        domainMapper
    )

}