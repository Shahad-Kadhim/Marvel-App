package com.example.app.marvel.domain.mappers

import com.example.app.marvel.data.local.entities.SearchesEntity
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.util.Mapper
import com.example.app.marvel.util.toSearchType
import java.util.*
import javax.inject.Inject

class SearchesMapper @Inject constructor()
    : Mapper<SearchesEntity,Searches> ,
    MapperInverse<Searches,SearchesEntity>
{
    override fun map(input: SearchesEntity): Searches =
        Searches(
            id = input.id,
            imageUrl = input.imageUrl,
            name = input.name,
            type = input.type.toSearchType()
        )

    override fun mapInverse(input: Searches): SearchesEntity =
        SearchesEntity(
            id = input.id,
            imageUrl = input.imageUrl,
            type = input.type.toString(),
            name= input.name,
            date = Date()
        )
}