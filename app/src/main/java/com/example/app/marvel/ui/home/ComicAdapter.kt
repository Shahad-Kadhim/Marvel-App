package com.example.app.marvel.ui.home

import com.example.app.marvel.R
import com.example.app.marvel.domain.models.Comic
import com.example.app.marvel.ui.base.BaseRecyclerAdapter

class ComicAdapter(
    items: List<Comic>,
    listener: HomeInteractionListener
): BaseRecyclerAdapter<Comic>(items,listener) {
    override val layoutId: Int = R.layout.comic_item

    override fun  areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Comic>,
    ): Boolean =
        getItems()[oldItemPosition].id == newItems[newItemPosition].id

}

