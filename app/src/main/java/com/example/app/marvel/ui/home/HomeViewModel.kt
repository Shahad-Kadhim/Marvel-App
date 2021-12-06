package com.example.app.marvel.ui.home

import android.util.Log
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
): BaseViewModel(), HomeInteractionListener{
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

    override fun onClickCharacter(characterId: Int) {
        Log.i("HOME_VIEW_MODEL","$characterId clickME")
    }

    override fun onclickSeeMoreCharacter() {
        Log.i("HOME_VIEW_MODEL","Click see more characters")
    }

    override fun onClickCreator(creatorId: Int) {
        Log.i("HOME_VIEW_MODEL","$creatorId clickME Creator")

    }

    override fun onclickSeeMoreCreators() {
        Log.i("HOME_VIEW_MODEL","Click see more creator")
    }
}