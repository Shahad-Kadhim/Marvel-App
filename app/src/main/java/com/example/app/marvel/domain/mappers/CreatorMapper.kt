package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.CreatorEntity
import com.example.app.marvel.domain.models.Creator
import com.example.app.marvel.util.Mapper

class CreatorMapper: Mapper<CreatorEntity,Creator> {

    override fun map(input: CreatorEntity): Creator =
        Creator(
            id = input.id,
            name = input.name,
            imageUrl = input.imageUrl
        )
}