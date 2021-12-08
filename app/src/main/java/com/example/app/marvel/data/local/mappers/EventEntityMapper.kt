package com.example.app.marvel.data.local.mappers

import com.example.app.marvel.data.local.entities.EventEntity
import com.example.app.marvel.data.remote.response.EventDto
import com.example.app.marvel.util.*
import javax.inject.Inject

class EventEntityMapper @Inject constructor(): Mapper<EventDto, EventEntity> {

    override fun map(input: EventDto): EventEntity =
        EventEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            imageUrl = input.thumbnail.toImageUrl(),
            dataModify = input.modified
        )

}