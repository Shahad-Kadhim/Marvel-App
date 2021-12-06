package com.example.app.marvel.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import com.example.app.marvel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    repository: MarvelRepository
): BaseViewModel(), HomeInteractionListener{

    private val _clickSearchEvent = MutableLiveData<Event<Boolean>>()
    val clickSearchEvent: LiveData<Event<Boolean>> = _clickSearchEvent

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

    fun onClickSearch(){
        _clickSearchEvent.postValue(Event(true))
    }


    override fun onClickCharacter(characterId: Int) {
        Log.i("HOME_VIEW_MODEL","$characterId clickME")
    }

    override fun onClickCreator(creatorId: Int) {
        Log.i("HOME_VIEW_MODEL","$creatorId clickME Creator")

    }

    override fun onClickComic(comicId: Int) {
        Log.i("HOME_VIEW_MODEL","$comicId clickME Comic")
    }

    override fun onClickItemSearch(searchId: Int) {
        Log.i("HOME_VIEW_MODEL","$searchId clickME searches")
    }


    override fun onclickSeeMoreCharacter() {
        Log.i("HOME_VIEW_MODEL","Click see more characters")
    }

    override fun onclickSeeMoreCreators() {
        Log.i("HOME_VIEW_MODEL","Click see more creator")
    }

    override fun onclickSeeMoreComics() {
        Log.i("HOME_VIEW_MODEL","Click see more comics")
    }

    override fun onclickSeeMoreSearches() {
        Log.i("HOME_VIEW_MODEL","Click see more searches")
    }

}