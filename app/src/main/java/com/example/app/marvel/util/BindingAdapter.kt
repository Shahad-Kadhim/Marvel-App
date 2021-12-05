package com.example.app.marvel.util

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.marvel.domain.models.Character
import com.example.app.marvel.domain.models.Comic
import com.example.app.marvel.domain.models.Creator
import com.example.app.marvel.domain.models.Searches
import com.example.app.marvel.ui.base.BaseRecyclerAdapter
import com.example.app.marvel.ui.home.HomeItem
import com.example.app.marvel.ui.home.HomeRecyclerAdapter


@BindingAdapter(value = ["app:characters"])
fun <T> setRecyclerItems(view: RecyclerView, character: List<Character>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        character?.takeIf { it.isNotEmpty() }?.let { listItems ->
            Log.i("CHAR", "YES")
            it.setItemsAsPosition(HomeItem.Characters(listItems.toMutableList()), 0)
        }
    }
}

@BindingAdapter(value = ["app:creator"])
fun <T> setCreatorItems(view: RecyclerView,creator: List<Creator>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        creator?.takeIf { it.isNotEmpty() }?.let { listItems ->
            Log.i("CREA","YES")
            it.setItemsAsPosition(HomeItem.Creators(listItems.toMutableList()),1)
        }
    }
}

@BindingAdapter(value = ["app:comics"])
fun setComicItems(view: RecyclerView,comics: List<Comic>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {

        comics?.takeIf { it.isNotEmpty() }?.let { listItems ->
            Log.i("COMI","YES")
            it.setItemsAsPosition(HomeItem.Comics(listItems.toMutableList()),2)
        }
    }
}


@BindingAdapter(value = ["app:searches"])
fun <T> setSearchesItems(view: RecyclerView,searches: List<Searches>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        searches?.takeIf { it.isNotEmpty() }?.let { listItems ->
            Log.i("SEAR", "YES")
            it.setItemsAsPosition(HomeItem.RecentSearches(listItems.toMutableList()), 3)
        }
    }
}



