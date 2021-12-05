package com.example.app.marvel.ui.home

import android.util.Log
import com.example.app.marvel.R
import com.example.app.marvel.domain.models.Character
import com.example.app.marvel.ui.base.BaseRecyclerAdapter

class CharacterAdapter(
    items: List<Character>,
    listener: HomeInteractionListener
): BaseRecyclerAdapter<Character>(items,listener) {
    override val layoutId: Int = R.layout.character_item

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Character>,
    ): Boolean =
        getItems()[oldItemPosition].id == newItems[newItemPosition].id



}

