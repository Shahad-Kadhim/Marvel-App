package com.example.app.marvel.ui.series

import com.example.app.marvel.R
import com.example.app.marvel.domain.models.Series
import com.example.app.marvel.ui.base.*

class SeriesRecyclerAdapter(items: List<Series>, listener: SeriesInteractionListener)
    : BaseRecyclerAdapter<Series>(items, listener) {
    override val layoutId: Int = R.layout.series_item

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int,
        newItems: List<Series>,
    ) =
        getItems()[oldItemPosition].id == newItems[newItemPosition].id

}

interface SeriesInteractionListener: BaseInteractionListener {

    fun onClickSeries( seriesId: Int)
}
