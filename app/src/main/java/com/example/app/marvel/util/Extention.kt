package com.example.app.marvel.util

import android.view.View
import androidx.lifecycle.*
import androidx.navigation.*
import androidx.navigation.fragment.FragmentNavigator
import com.example.app.marvel.data.State
import com.example.app.marvel.data.remote.response.*
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
    Searches(id,thumbnail.toImageUrl(),name,SearchType.CREATORS)


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


fun View.goToFragmentWithTransition(navDir: NavDirections, extra: FragmentNavigator.Extras) {
    Navigation.findNavController(this).navigate(navDir,extra)
}


fun View.goToFragment(navDir: NavDirections) {
    Navigation.findNavController(this).navigate(navDir)
}
