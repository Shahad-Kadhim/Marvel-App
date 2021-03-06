package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.CharacterEntity
import com.example.app.marvel.domain.models.Character
import com.example.app.marvel.util.Mapper
import javax.inject.Inject

class CharacterMapper @Inject constructor(): Mapper<CharacterEntity,Character> {

    override fun map(input: CharacterEntity): Character =
        Character(
            input.id,
            input.name,
            input.imageUrl
        )

}