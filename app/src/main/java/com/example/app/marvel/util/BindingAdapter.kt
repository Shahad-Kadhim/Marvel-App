package com.example.app.marvel.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.marvel.domain.models.*
import com.example.app.marvel.ui.home.*


@BindingAdapter(value = ["app:characters"])
fun setRecyclerItems(view: RecyclerView, character: List<Character>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        character?.takeIf { it.isNotEmpty() }?.let { listItems ->
            it.setItemsAsPosition(HomeItem.Characters(listItems.toMutableList()), 0)
        }
    }
}

@BindingAdapter(value = ["app:creator"])
fun setCreatorItems(view: RecyclerView,creator: List<Creator>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        creator?.takeIf { it.isNotEmpty() }?.let { listItems ->
            it.setItemsAsPosition(HomeItem.Creators(listItems.toMutableList()),1)
        }
    }
}

@BindingAdapter(value = ["app:comics"])
fun setComicItems(view: RecyclerView,comics: List<Comic>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        comics?.takeIf { it.isNotEmpty() }?.let { listItems ->
            it.setItemsAsPosition(HomeItem.Comics(listItems.toMutableList()),2)
        }
    }
}


@BindingAdapter(value = ["app:searches"])
fun setSearchesItems(view: RecyclerView,searches: List<Searches>?) {
    (view.adapter as HomeRecyclerAdapter?)?.let {
        searches?.takeIf { it.isNotEmpty() }?.let { listItems ->
            it.setItemsAsPosition(HomeItem.RecentSearches(listItems.toMutableList()), 3)
        }
    }
}



@BindingAdapter(value = ["app:imageFromUrl"])
fun setImage(view: ImageView, url: String?) {
    url?.let { imageUrl ->
        Glide.with(view)
            .load(imageUrl)
            .centerCrop()
            .into(view)
    }
}
