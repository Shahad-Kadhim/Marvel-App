package com.example.app.marvel.data.remote


import android.util.Log
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.data.local.MarvelDao
import com.example.app.marvel.data.local.mappers.*
import com.example.app.marvel.domain.models.Comic
import com.example.app.marvel.domain.mappers.*
import com.example.app.marvel.domain.models.*
import kotlinx.coroutines.flow.*
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class MarvelRepositoryImp @Inject constructor(
    private val dao: MarvelDao,
    private val api: MarvelService,
    private val characterEntityMapper: CharacterEntityMapper,
    private val characterMapper: CharacterMapper,
    private val comicEntityMapper: ComicEntityMapper,
    private val comicMapper: ComicMapper,
    private val creatorEntityMapper: CreatorEntityMapper,
    private val creatorMapper: CreatorMapper,
    private val searchesMapper: SearchesMapper,
    ): MarvelRepository{

    override fun getAllCharacters(): Flow<List<Character>> =
        wrapper(
            dao.getAllCharacter(),
            characterMapper::map
        )


    override suspend fun refreshCharacters() {
        refreshWrapper(api::getCharacters,dao::addCharacter)
            { body ->
                body?.data?.results?.map { characterDto ->
                    characterEntityMapper.map(characterDto)
                }
            }
    }


    override fun getAllComics(): Flow<List<Comic>> =
        wrapper(
            dao.getAllComic(),
            comicMapper::map
        )


    override suspend fun refreshComics() {
        refreshWrapper(api::getComics,dao::addComic)
            { body ->
                body?.data?.results?.map { comicDto ->
                    comicEntityMapper.map(comicDto)
                }
            }
    }


    override fun getAllCreators(): Flow<List<Creator>> =
        wrapper(
            dao.getCreators(),
            creatorMapper::map
        )


    override suspend fun refreshCreators() {
        refreshWrapper(api::getCreators,dao::addCreators)
            { body ->
                body?.data?.results?.map { creatorDto ->
                    creatorEntityMapper.map(creatorDto)
                }
            }
    }

    override fun getRecentSearches(): Flow<List<Searches>> =
        wrapper(
            dao.getRecentSearches(),
            searchesMapper::map
        )

    override suspend fun addSearch(search: Searches) {
        searchesMapper.mapInverse(search).run {
            dao.addSearch(this)
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
        request: suspend () -> Response<T> ,
        insertIntoDatabase: suspend (List<U>) ->Unit,
        mapper: (T?) -> List<U>? ,
    ){
        try {
            request().also {
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