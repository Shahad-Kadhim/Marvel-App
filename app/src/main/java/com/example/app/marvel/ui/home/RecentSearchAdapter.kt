package com.example.app.marvel.ui.home

import com.example.app.marvel.R
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.ui.base.BaseRecyclerAdapter

class RecentSearchAdapter(
    items: List<Searches>,
    listener: HomeInteractionListener
): BaseRecyclerAdapter<Searches>(items,listener) {
    override val layoutId: Int = R.layout.search_item

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Searches>,
    ): Boolean =
        getItems()[oldItemPosition].id == newItems[newItemPosition].id

}

