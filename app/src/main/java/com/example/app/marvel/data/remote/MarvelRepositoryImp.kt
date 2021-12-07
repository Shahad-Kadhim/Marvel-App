package com.example.app.marvel.data.remote

import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import com.example.app.marvel.data.State
import com.example.app.marvel.domain.MarvelRepository
import com.example.app.marvel.data.local.MarvelDao
import com.example.app.marvel.data.local.mappers.*
import com.example.app.marvel.data.remote.response.MarvelResponse
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
    private val localMappers: LocalMappers,
    private val domainMapper: DomainMapper,
    ): MarvelRepository {

    override fun getAllCharacters(): Flow<List<Character>> =
        wrapper(
            dao.getAllCharacter(),
            domainMapper.characterMapper::map
        )


    override suspend fun refreshCharacters() {
        refreshWrapper(api::getCharacters, dao::addCharacter)
        { body ->
            body?.data?.results?.map { characterDto ->
                localMappers.characterEntityMapper.map(characterDto)
            }
        }
    }


    override fun getAllComics(): Flow<List<Comic>> =
        wrapper(
            dao.getAllComic(),
            domainMapper.comicMapper::map
        )


    override suspend fun refreshComics() {
        refreshWrapper(api::getComics, dao::addComic)
        { body ->
            body?.data?.results?.map { comicDto ->
                localMappers.comicEntityMapper.map(comicDto)
            }
        }
    }


    override fun getAllCreators(): Flow<List<Creator>> =
        wrapper(
            dao.getCreators(),
            domainMapper.creatorMapper::map
        )


    override suspend fun refreshCreators() {
        refreshWrapper(api::getCreators, dao::addCreators)
        { body ->
            body?.data?.results?.map { creatorDto ->
                localMappers.creatorEntityMapper.map(creatorDto)
            }
        }
    }

    override fun getRecentSearches(): Flow<List<Searches>> =
        wrapper(
            dao.getRecentSearches(),
            domainMapper.searchesMapper::map
        )

    override suspend fun addSearch(search: Searches) {
        domainMapper.searchesMapper.mapInverse(search).run {
            dao.addSearch(this)
        }
    }


    override fun getSeries(): Flow<List<Series>> =
        wrapper(
            dao.getSeries(),
            domainMapper.seriesMapper::map
        )


    override suspend fun refersSeries(limit: Int) {
        refreshWrapper(
            {
                api.getSeries(limit)
            }, dao::addSeries)
        { body ->
            body?.data?.results?.map { seriesDto ->
                localMappers.seriesEntityMapper.map(seriesDto)
            }
        }
    }


    private fun <T, U> wrapper(
        data: Flow<List<T>>,
        mapper: (T) -> U
    ): Flow<List<U>> =
        data.map { list ->
            list.map { entity ->
                mapper(entity)
            }
        }

    private suspend fun <T, U> refreshWrapper(
        request: suspend () -> Response<T>,
        insertIntoDatabase: suspend (List<U>) -> Unit,
        mapper: (T?) -> List<U>?,
    ) {
        try {
            request().also {
                if (it.isSuccessful) {
                    mapper(it.body())?.let { list ->
                        insertIntoDatabase(list)
                    }
                }
            }
        } catch (exception: Exception) {
            Log.i("MARVEL", "no connection cant update data")
        }
    }


    override fun searchCharacter(searchKeyWord: String) =
        wrapWithFlow {
            api.getCharacters(
                searchKeyWord = searchKeyWord
            )
        }
    override fun searchCreator(searchKeyWord: String) =
        wrapWithFlow {
            api.getCreators(
                searchKeyWord = searchKeyWord
            )
        }
    override fun searchComic(searchKeyWord: String) =
        wrapWithFlow {
            api.getComics(
                searchKeyWord = searchKeyWord
            )
        }
    override fun searchSeries(searchKeyWord: String) =
        wrapWithFlow {
            api.getSeries(
                searchKeyWord = searchKeyWord
            )
        }

    private fun <T> wrapWithFlow(function: suspend () -> Response<MarvelResponse<T>>): Flow<State<List<T>?>> {
        return flow {
            emit(State.Loading)
            try {
                emit(checkIsSuccessful(function()))
            } catch (e: Exception) {
                emit(State.Error(e.message.toString()))
            }
        }
    }

    private fun <T> checkIsSuccessful(response: Response<MarvelResponse<T>>): State<List<T>?> =
        if (response.isSuccessful) {
            State.Success(response.body()?.data?.results)
        } else {
            State.Error(response.message())
        }
}


//1017644461267174