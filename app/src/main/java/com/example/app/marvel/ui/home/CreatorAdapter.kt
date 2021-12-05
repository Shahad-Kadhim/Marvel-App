package com.example.app.marvel.ui.home

import com.example.app.marvel.R
import com.example.app.marvel.domain.models.Creator
import com.example.app.marvel.ui.base.BaseRecyclerAdapter

class CreatorAdapter(
    items: List<Creator>,
    listener: HomeInteractionListener
): BaseRecyclerAdapter<Creator>(items,listener) {
    override val layoutId: Int = R.layout.creator_item

    override fun  areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Creator>,
    ): Boolean =
        getItems()[oldItemPosition].id == newItems[newItemPosition].id

}

