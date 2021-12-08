package com.example.app.marvel.ui.search

import androidx.lifecycle.*
import com.example.app.marvel.data.State
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.ui.base.BaseViewModel
import com.example.app.marvel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val  repository: MarvelRepository
): BaseViewModel() , SearchInteractionListener{

    val searchName =MutableLiveData<String>()
    val typeSearch= MutableLiveData<SearchType>()

    private val _searchResult= MutableLiveData<State<List<Searches?>>>()
    val searchResult: LiveData<State<List<Searches?>>> = _searchResult

    private val _clickSearchItemEvent =MutableLiveData<Event<Searches>>()
    val clickSearchItemEvent: LiveData<Event<Searches>> = _clickSearchItemEvent

    fun onSearchClick(){
            when (typeSearch.value) {
                SearchType.CHARACTERS -> search (repository::searchCharacter)
                SearchType.CREATORS -> search (repository::searchCreator)
            }
        }


    fun search( searchFunction: (String) -> Flow<State<List<Searches?>>>){
        viewModelScope.launch {
            searchName.value?.let {
                searchFunction(it).collect { state ->
                    _searchResult.postValue(state)
                }
            }
        }
    }

    override fun onClickItem(itemId: Int) {
        searchResult.value?.toData()?.firstOrNull{ it?.id ==itemId }?.let{ searchItem ->
            insertSearchItem(searchItem)
            _clickSearchItemEvent.postValue(Event(searchItem))
        }
    }

    private fun insertSearchItem(item: Searches) {
        viewModelScope.launch {
                repository.addSearch(item)
            }
    }

}
