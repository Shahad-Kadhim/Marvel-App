package com.example.app.marvel.domain.mappers

import javax.inject.Inject

class DomainMapper @Inject constructor(
     val characterMapper: CharacterMapper,
     val comicMapper: ComicMapper,
     val creatorMapper: CreatorMapper,
     val searchesMapper: SearchesMapper,
)


