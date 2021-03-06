package com.example.app.marvel.data.local.mappers

import com.example.app.marvel.data.local.entities.ComicEntity
import com.example.app.marvel.data.remote.response.ComicsDto
import com.example.app.marvel.util.*
import javax.inject.Inject

class ComicEntityMapper @Inject constructor(): Mapper<ComicsDto,ComicEntity> {

    override fun map(input: ComicsDto): ComicEntity =
        ComicEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            imageUrl = input.thumbnail.toImageUrl(),
            lastDateModify = input.modified
        )

}