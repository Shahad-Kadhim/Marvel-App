package com.example.app.marvel.data.remote


import android.util.Log
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.data.local.MarvelDao
import com.example.app.marvel.data.local.mappers.CharacterEntityMapper
import com.example.app.marvel.domain.mappers.CharacterMapper
import com.example.app.marvel.domain.models.Character
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val dao: MarvelDao,
    private val api: MarvelService,
    private val characterEntityMapper: CharacterEntityMapper,
    private val characterMapper: CharacterMapper
): MarvelRepository{

    override fun getAllCharacters(): Flow<List<Character>> =
        wrapper(
            dao.getAllCharacter(),
            characterMapper::map
        )

    override suspend fun refreshCharacters() {
        refreshWrapper(api.getCharacters(),dao::addCharacter)
            { body ->
                body?.data?.characters?.map { characterDto ->
                    characterEntityMapper.map(characterDto)
                }
            }
    }

    private  fun <T,U> wrapper(
        data:Flow<List<T>> ,
        mapper: (T) -> U
    ): Flow<List<U>> =
        data.map { list ->
            list.map{ entity->
                mapper(entity)
            }
        }

    private suspend fun <T,U> refreshWrapper(
        response: Response<T> ,
        insertIntoDatabase: suspend (List<U>) ->Unit,
        mapper: (T?) -> List<U>? ,
    ){
        try {
            response.also {
                if(it.isSuccessful){
                    mapper(it.body())?.let {  list ->
                        insertIntoDatabase(list)
                    }
                }
            }
        }catch(exception:Exception){
            Log.i("MARVEL","no connection cant update data")
        }
    }

}



//1017644461267174