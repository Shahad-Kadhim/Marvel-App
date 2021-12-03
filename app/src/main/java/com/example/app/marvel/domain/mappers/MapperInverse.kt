package com.example.app.marvel.domain.mappers

interface MapperInverse<I,O> {
    fun mapInverse(input :I): O
}