package com.example.app.marvel.ui.series

import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    repository: MarvelRepository
): BaseViewModel(), SeriesInteractionListener {

    val series =repository.getSeries().asLiveData()

    init {
        viewModelScope.launch {
            repository.refersSeries()
        }
    }

}
