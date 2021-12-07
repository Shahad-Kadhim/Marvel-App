package com.example.app.marvel.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.app.marvel.data.State
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
   val  repository: MarvelRepository
): BaseViewModel() {

    val searchName =MutableLiveData<String>()
    val typeSearch= MutableLiveData<String>()

    private val _searchResult= MutableLiveData<State<List<Any>>>()
    val searchResult: LiveData<State<List<Any>>> = _searchResult

    fun onSearchClick(){
            when (typeSearch.value) {
                "Character" -> search (repository::searchCharacter)
                "Comic" -> search (repository::searchComic)
                "Creator" -> search (repository::searchCreator)
                "Series" -> search (repository::searchSeries)
            }
        }


    fun <T>search( searchFunction: (String) -> Flow<State<List<T>?>>){
        viewModelScope.launch {
            searchName.value?.let {
                searchFunction(it).collect { state ->
                    _searchResult.postValue(state as State<List<Any>>)
                }
            }
        }
    }

}
