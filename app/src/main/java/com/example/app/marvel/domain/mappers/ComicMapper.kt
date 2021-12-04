package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.ComicEntity
import com.example.app.marvel.domain.models.Comic
import com.example.app.marvel.util.Mapper
import javax.inject.Inject

class ComicMapper @Inject constructor(): Mapper<ComicEntity, Comic> {

    override fun map(input: ComicEntity): Comic =
        Comic(
            id = input.id,
            title = input.title ?:"",
            description = input.description ?:"",
            imageUrl = input.imageUrl
        )

}