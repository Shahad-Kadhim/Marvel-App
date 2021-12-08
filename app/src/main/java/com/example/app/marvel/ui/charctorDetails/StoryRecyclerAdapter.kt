package com.example.app.marvel.ui.charctorDetails

import com.example.app.marvel.R
import com.example.app.marvel.data.remote.response.StoryItem
import com.example.app.marvel.data.remote.response.Summary
import com.example.app.marvel.ui.base.*

class StoryRecyclerAdapter(items: List<StoryItem>, listener: StoryItemInteractionListener)
    : BaseRecyclerAdapter<StoryItem>(items, listener) {
    override val layoutId: Int = R.layout.story_item

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<StoryItem>,
    ) =
        getItems()[oldItemPosition].resourceURI == newItems[newItemPosition].resourceURI

}

interface StoryItemInteractionListener: BaseInteractionListener {

}
