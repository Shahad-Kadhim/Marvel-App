package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.SearchesEntity
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.util.Mapper
import java.util.*

class SearchesMapper: Mapper<SearchesEntity,Searches> ,MapperInverse<Searches,SearchesEntity>{

    override fun map(input: SearchesEntity): Searches =
        Searches(
            id = input.id,
            imageUrl = input.imageUrl,
            type = input.type
        )

    override fun mapInverse(input: Searches): SearchesEntity =
        SearchesEntity(
            id = input.id,
            imageUrl = input.imageUrl,
            type = input.type,
            date = Date()
        )
}