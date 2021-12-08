package com.example.app.marvel.ui.home

import android.util.Log
import androidx.lifecycle.*
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.ui.base.BaseViewModel
import com.example.app.marvel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), HomeInteractionListener{

    private val _clickSearchEvent = MutableLiveData<Event<Boolean>>()
    val clickSearchEvent: LiveData<Event<Boolean>> = _clickSearchEvent

    private val _clickSeeMoreCharacterEvent = MutableLiveData<Event<Boolean>>()
    val clickSeeMoreCharacterEvent: LiveData<Event<Boolean>> = _clickSeeMoreCharacterEvent

    private val _clickSeeMoreCreatorEvent = MutableLiveData<Event<Boolean>>()
    val clickSeeMoreCreatorEvent: LiveData<Event<Boolean>> = _clickSeeMoreCreatorEvent

    private val _clickSeeMoreComicEvent = MutableLiveData<Event<Boolean>>()
    val clickSeeMoreComicEvent: LiveData<Event<Boolean>> = _clickSeeMoreComicEvent

    private val _clickSeeMoreSearchesEvent = MutableLiveData<Event<Boolean>>()
    val clickSeeMoreSearchesEvent: LiveData<Event<Boolean>> = _clickSeeMoreSearchesEvent

    private val _clickSearchItemEvent =MutableLiveData<Event<Searches>>()
    val clickSearchItemEvent: LiveData<Event<Searches>> = _clickSearchItemEvent

    private val _clickCharacterItemEvent =MutableLiveData<Event<Int>>()
    val clickCharacterItemEvent: LiveData<Event<Int>> = _clickCharacterItemEvent

    private val _clickCreatorItemEvent =MutableLiveData<Event<Int>>()
    val clickCreatorItemEvent: LiveData<Event<Int>> = _clickCreatorItemEvent

    private val _clickComicItemEvent =MutableLiveData<Event<Int>>()
    val clickComicItemEvent: LiveData<Event<Int>> = _clickComicItemEvent

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
        _clickCharacterItemEvent.postValue(Event(characterId))
    }

    override fun onClickCreator(creatorId: Int) {
        _clickCreatorItemEvent.postValue(Event(creatorId))
    }

    override fun onClickComic(comicId: Int) {
        _clickComicItemEvent.postValue(Event(comicId))
    }

    override fun onClickItemSearch(searchId: Int) {
        viewModelScope.launch {
            repository.getSearchesItemById(searchId).apply {
                _clickSearchItemEvent.postValue(Event(this))
            }
        }
    }


    override fun onclickSeeMoreCharacter() {
        _clickSeeMoreCharacterEvent.postValue(Event(true))
    }

    override fun onclickSeeMoreCreators() {
        _clickSeeMoreCreatorEvent.postValue(Event(true))
    }

    override fun onclickSeeMoreComics() {
        _clickSeeMoreComicEvent.postValue(Event(true))
    }

    override fun onclickSeeMoreSearches() {
        _clickSeeMoreSearchesEvent.postValue(Event(true))
    }

}