package com.example.app.marvel.ui.search

import com.example.app.marvel.R
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.ui.base.*

class SearchAdapter(
    items: List<Searches>,
    listener: SearchInteractionListener
): BaseRecyclerAdapter<Searches>(items,listener) {
    override val layoutId: Int = R.layout.v_search_item

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Searches>,
    ): Boolean =
        getItems()[oldItemPosition].id == newItems[newItemPosition].id

}

interface SearchInteractionListener: BaseInteractionListener {

    fun onClickItem(itemId: Int)
}

