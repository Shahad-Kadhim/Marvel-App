package com.example.app.marvel.data.local.mappers

import com.example.app.marvel.data.local.entities.CreatorEntity
import com.example.app.marvel.data.remote.response.CreatorDto
import com.example.app.marvel.util.Mapper

class CreatorEntityMapper: Mapper<CreatorDto, CreatorEntity> {

    override fun map(input: CreatorDto): CreatorEntity =
        CreatorEntity(
            id = input.id,
            name =input.fullName,
            imageUrl = "${input.thumbnail?.path}.${input.thumbnail?.extension}",
            lastModify = input.modified
        )

}