package com.example.app.marvel.ui.series

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import com.example.app.marvel.util.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    repository: MarvelRepository
): BaseViewModel(), SeriesInteractionListener {


    private val _clickBackEvent = MutableLiveData<Event<Boolean>>()
    val clickBackEvent: LiveData<Event<Boolean>> = _clickBackEvent

    val _clickSeriesEvent =MutableLiveData<Event<Int>>()
    val clickSeriesEvent: LiveData<Event<Int>> = _clickSeriesEvent

    val series =repository.getSeries().asLiveData()

    init {
        viewModelScope.launch {
            repository.refersSeries(99)
        }
    }

    fun onClickBack(){
        _clickBackEvent.postValue(Event(true))
    }

    override fun onClickSeries(seriesId: Int) {
        _clickSeriesEvent.postValue(Event(seriesId))
    }

}
