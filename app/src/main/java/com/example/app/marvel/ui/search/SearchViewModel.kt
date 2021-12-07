package com.example.app.marvel.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.app.marvel.data.State
import com.example.app.marvel.ui.base.BaseViewModel
import javax.sql.StatementEvent

class SearchViewModel: BaseViewModel() {

    val searchName =MutableLiveData<String>()
    val typeSearch= MutableLiveData<String>()

    private val _searchResult= MutableLiveData<State<List<Any>>>()
    val searchResult: LiveData<State<List<Any>>> = _searchResult

    fun onSearchClick(){
        Log.i("RRR","${searchName.value} ---  ${typeSearch.value}")
    }
}
