package com.example.app.marvel.ui.home

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.app.marvel.data.remote.MarvelRepositoryImp
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    marvelRepositoryImp: MarvelRepository
): BaseViewModel(){
    init {
        viewModelScope.launch {
            marvelRepositoryImp.getAllCreators().collect {
                Log.i("HGHG",it.toString())
            }
        }
        viewModelScope.launch {
            marvelRepositoryImp.refreshCreators()

        }
    }
}