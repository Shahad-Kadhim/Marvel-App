package com.example.app.marvel.util

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import com.example.app.marvel.data.State
import com.example.app.marvel.data.remote.response.CharacterDto
import com.example.app.marvel.data.remote.response.CreatorDto
import com.example.app.marvel.data.remote.response.Thumbnail
import com.example.app.marvel.domain.models.Character
import com.example.app.marvel.domain.models.Creator
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.ui.search.SearchType
import java.math.BigInteger
import java.security.MessageDigest

fun String.md5(): String {
    with(MessageDigest.getInstance("MD5")){
        return BigInteger(1, digest(toByteArray())).toString(16).padStart(32, '0')
    }
}


fun <T> LiveData<Event<T>>.observeEvent(owner: LifecycleOwner, function:(T) ->Unit){
    this.observe(owner, EventObserver{ it ->
        function(it)
    })
}

fun String.replaceHttpWithHttps() =
    this.replace("http","https")

fun String.getRate() =
    this.count { it == '+' }.toFloat() + 1


fun String.toSearchType(): SearchType =
    when(this){
        "Character" -> SearchType.CHARACTERS
        else -> SearchType.CREATORS
    }


fun State<List<CreatorDto>?>.creatorToSearches() =
    when(this){
        is State.Error -> State.Error(message)
        State.Loading -> State.Loading
        is State.Success -> {
            State.Success(toData()?.map {
                it.toSearchClass()
            })
        }
    }

fun CreatorDto.toSearchClass() =
    Searches(id,thumbnail.toImageUrl(),name,SearchType.CHARACTERS)


fun State<List<CharacterDto>?>.characterToSearches() =
    when(this){
        is State.Error -> State.Error(message)
        State.Loading -> State.Loading
        is State.Success -> {
            State.Success(toData()?.map {
                it.toSearchClass()
            })
        }
    }

fun CharacterDto.toSearchClass() =
    Searches(id,thumbnail.toImageUrl(),name,SearchType.CHARACTERS)


fun Thumbnail?.toImageUrl()=
    "${this?.path}.${this?.extension}".replaceHttpWithHttps()

