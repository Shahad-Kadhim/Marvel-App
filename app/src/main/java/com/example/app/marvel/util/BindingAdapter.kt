package com.example.app.marvel.util

import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.app.marvel.domain.models.*
import com.example.app.marvel.ui.base.BaseRecyclerAdapter
import com.example.app.marvel.ui.home.*


@BindingAdapter(value = ["app:characters"])
fun setCharacterItems(view: RecyclerView, character: List<Character>?) {
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

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView, items: List<T>?) {
    items?.let { listItems ->
        (view.adapter as BaseRecyclerAdapter<T>?)
            ?.setItems(listItems)
    }
}

@BindingAdapter(value = ["app:rate"])
fun setRate(view: RatingBar, value:String?){
    view.rating = value?.getRate() ?: 0f
}

@BindingAdapter(value = ["app:hideIfEmpty"])
fun <T> hideWhenEmpty(view: View, items: List<T>?) {
    view.isVisible= items?.isNotEmpty() ?: false
}

@BindingAdapter(value = ["app:showIfEmpty"])
fun <T> showWhenEmpty(view: View, items: List<T>?) {
    view.isVisible= items?.isEmpty() ?: false
}
