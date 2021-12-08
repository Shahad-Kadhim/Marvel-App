package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.EventEntity
import com.example.app.marvel.domain.models.Event
import com.example.app.marvel.util.Mapper
import javax.inject.Inject

class EventMapper @Inject constructor(): Mapper<EventEntity,Event> {

    override fun map(input: EventEntity): Event =
        Event(
            input.id,
            input.title,
            input.description ?: "",
            input.imageUrl,
        )

}