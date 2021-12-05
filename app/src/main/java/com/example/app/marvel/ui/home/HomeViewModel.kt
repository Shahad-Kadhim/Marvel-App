package com.example.app.marvel.ui.home

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository
): BaseViewModel(){
    val characters = repository.getAllCharacters().asLiveData()
    val creator = repository.getAllCreators().asLiveData()
    val comic = repository.getAllComics().asLiveData()
    val searches = repository.getRecentSearches().asLiveData()
    init {
        viewModelScope.launch {
                repository.refreshCreators()
                repository.refreshComics()
                repository.refreshCharacters()

        }
    }
}