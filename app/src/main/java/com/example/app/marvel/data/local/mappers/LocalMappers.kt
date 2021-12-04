package com.example.app.marvel.data.local.mappers

import javax.inject.Inject

class LocalMappers @Inject constructor(
    val characterEntityMapper: CharacterEntityMapper,
    val comicEntityMapper: ComicEntityMapper,
    val creatorEntityMapper: CreatorEntityMapper,
)