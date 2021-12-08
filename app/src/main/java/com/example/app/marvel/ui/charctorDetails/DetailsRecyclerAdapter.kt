package com.example.app.marvel.ui.charctorDetails

import com.example.app.marvel.R
import com.example.app.marvel.data.remote.response.Summary
import com.example.app.marvel.ui.base.*

class DetailsRecyclerAdapter(items: List<Summary>, listener: CharacterDetailsInteractionListener)
    : BaseRecyclerAdapter<Summary>(items, listener) {
    override val layoutId: Int = R.layout.summary_item

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Summary>,
    ) =
        getItems()[oldItemPosition].resourceURI == newItems[newItemPosition].resourceURI

}

interface CharacterDetailsInteractionListener: BaseInteractionListener {

}
