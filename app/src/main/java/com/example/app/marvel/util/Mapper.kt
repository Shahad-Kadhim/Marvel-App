package com.example.app.marvel.util

interface Mapper<I,O> {
    fun map(input :I): O
}