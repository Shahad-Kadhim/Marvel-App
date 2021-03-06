package com.example.app.marvel.data.local.mappers

import com.example.app.marvel.data.local.entities.CharacterEntity
import com.example.app.marvel.data.remote.response.CharacterDto
import com.example.app.marvel.data.remote.response.Thumbnail
import com.example.app.marvel.util.*
import javax.inject.Inject

class CharacterEntityMapper @Inject constructor(): Mapper<CharacterDto, CharacterEntity> {

    override fun map(input: CharacterDto): CharacterEntity =
        CharacterEntity(
            id = input.id,
            name = input.name,
            imageUrl = input.thumbnail.toImageUrl(),
            dataModify = input.modified
        )

}

