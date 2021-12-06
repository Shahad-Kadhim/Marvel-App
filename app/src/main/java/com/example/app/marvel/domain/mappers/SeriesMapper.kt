package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.SeriesEntity
import com.example.app.marvel.domain.models.Series
import com.example.app.marvel.util.Mapper
import javax.inject.Inject

class SeriesMapper @Inject constructor(): Mapper<SeriesEntity,Series> {

    override fun map(input: SeriesEntity): Series =
        Series(
            input.id,
            input.rating,
            input.title,
            input.imageUrl,
        )

}