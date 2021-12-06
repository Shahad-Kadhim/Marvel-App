package com.example.app.marvel.ui.series

import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SeriesViewModel @Inject constructor(
    repository: MarvelRepository
): BaseViewModel() {
    
    

}
