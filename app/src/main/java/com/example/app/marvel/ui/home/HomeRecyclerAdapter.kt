package com.example.app.marvel.ui.home

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.example.app.marvel.*
import com.example.app.marvel.domain.models.*
import com.example.app.marvel.ui.base.*

class HomeRecyclerAdapter(
    var itemsHome: MutableList<HomeItem>,
    private val listener: HomeInteractionListener,
): BaseRecyclerAdapter<HomeItem>(itemsHome, listener) {

    override var layoutId: Int =0

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder,position)
    }

    fun  setItemsAsPosition(homeItem: HomeItem,position: Int){
        val newItems= itemsHome.apply {
            removeAt(position)
            add(position,homeItem)
        }
        val diffResult = DiffUtil.calculateDiff(
            MarvelDiffUtil(
                getItems(),
                newItems,
                ::areItemsTheSame,
                ::areContentSame
            )
        )
        diffResult.dispatchUpdatesTo(this)
    }


    private fun bind(holder: ItemViewHolder, position: Int) {
        val currentItem =getItems()[position]
        when(getItems()[position]){
            is HomeItem.Characters -> {
                setVariables<Character>(
                    holder,
                    CharacterAdapter(currentItem.items as List<Character>,listener),
                    listener
                )
            }
            is HomeItem.Comics ->{
                setVariables<Comic>(
                    holder,
                    ComicAdapter(currentItem.items as List<Comic>,listener),
                    listener
                )
            }
            is HomeItem.Creators -> {
                setVariables<Creator>(
                    holder,
                    CreatorAdapter(currentItem.items as List<Creator>,listener),
                    listener
                )
            }
            is HomeItem.RecentSearches -> {
                setVariables<Searches>(
                    holder,
                    RecentSearchAdapter(currentItem.items as List<Searches>,listener),
                    listener
                )
            }
        }
    }

    private fun<T> setVariables(holder: ItemViewHolder,adapter: BaseRecyclerAdapter<T>, listener: HomeInteractionListener) {
        holder.binding.apply {
            setVariable(BR.adapter,adapter)
            setVariable(BR.listener,listener)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getLayout(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getLayout(viewType: Int): Int =
        when(viewType){
            CHARACTER_TYPE -> R.layout.characters_item
            COMICS_TYPE -> R.layout.comics_item
            CREATOR_TYPE -> R.layout.creators_item
            else -> R.layout.recent_searcher
        }


    override fun getItemViewType(position: Int): Int =
        when (getItems()[position]) {
            is HomeItem.Characters -> CHARACTER_TYPE
            is HomeItem.Comics -> COMICS_TYPE
            is HomeItem.Creators -> CREATOR_TYPE
            is HomeItem.RecentSearches -> SEARCHES_TYPE
        }

    companion object {
        const val CHARACTER_TYPE = 1
        const val COMICS_TYPE = 2
        const val CREATOR_TYPE = 3
        const val SEARCHES_TYPE = 4
    }

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<HomeItem>,
    ): Boolean {
        return (getItems()[oldItemPosition].order == newItems[newItemPosition].order)
    }

    override fun areContentSame(
        oldPosition: Int,
        newPosition: Int,
        newList: List<HomeItem>
    ): Boolean {
        return  false
    }
}

interface HomeInteractionListener: BaseInteractionListener {

    fun onClickCharacter(characterId: Int)

    fun onclickSeeMoreCharacter()

    fun onClickCreator(creatorId: Int)

    fun onclickSeeMoreCreators()

    fun onClickComic(comicId: Int)

    fun onclickSeeMoreComics()

    fun onClickItemSearch(searchId: Int)

    fun onclickSeeMoreSearches()

}


