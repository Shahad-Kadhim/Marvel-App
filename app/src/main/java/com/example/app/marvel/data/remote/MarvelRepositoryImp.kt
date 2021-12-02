package com.example.app.marvel.data.remote


import com.example.app.marvel.data.domain.MarvelRepository
import com.example.app.marvel.data.local.MarvelDao
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val marvelDao: MarvelDao,
    private val apiService: MarvelService
): MarvelRepository{



}
