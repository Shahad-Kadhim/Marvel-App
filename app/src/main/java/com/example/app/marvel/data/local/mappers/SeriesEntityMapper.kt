package com.example.app.marvel.data.local.mappers

import com.example.app.marvel.data.local.entities.SeriesEntity
import com.example.app.marvel.data.remote.response.SeriesDto
import com.example.app.marvel.util.*
import javax.inject.Inject

class SeriesEntityMapper @Inject constructor(): Mapper<SeriesDto, SeriesEntity> {

    override fun map(input: SeriesDto): SeriesEntity =
        SeriesEntity(
            id = input.id,
            rating = input.rating,
            title = input.title,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}".replaceHttpWithHttps(),
            lastDateModify = input.modified
        )

}