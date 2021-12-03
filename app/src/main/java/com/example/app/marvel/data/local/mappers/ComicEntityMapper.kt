package com.example.app.marvel.data.local.mappers

import com.example.app.marvel.data.local.entities.ComicEntity
import com.example.app.marvel.data.remote.response.ComicsDto
import com.example.app.marvel.util.Mapper

class ComicEntityMapper: Mapper<ComicsDto,ComicEntity> {

    override fun map(input: ComicsDto): ComicEntity =
        ComicEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            lastDateModify = input.modified
        )

}