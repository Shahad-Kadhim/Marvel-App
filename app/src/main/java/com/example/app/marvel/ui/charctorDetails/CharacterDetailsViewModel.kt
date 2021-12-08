package com.example.app.marvel.ui.charctorDetails

import androidx.lifecycle.*
import com.example.app.marvel.data.State
import com.example.app.marvel.data.remote.response.CharacterDto
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.ui.base.BaseViewModel
import com.example.app.marvel.util.Event
import com.example.app.marvel.util.toImageUrl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(), CharacterDetailsInteractionListener ,StoryItemInteractionListener{


    private val _clickBackEvent = MutableLiveData<Event<Boolean>>()
    val clickBackEvent: LiveData<Event<Boolean>> = _clickBackEvent

    private val _character =MutableLiveData<State<List<CharacterDto>?>>()
    val character: LiveData<State<List<CharacterDto>?>> =_character

    val characterR =Transformations.map(character){
        if(it is State.Success){
            it.data?.firstOrNull()
        }else null
    }

    fun getCharacter(id: Int){
        viewModelScope.launch {
            repository.getCharacterById(id).collect {
                _character.postValue(it)
            }
        }
    }

    fun onClickBack(){
        _clickBackEvent.postValue(Event(true))
    }


}
