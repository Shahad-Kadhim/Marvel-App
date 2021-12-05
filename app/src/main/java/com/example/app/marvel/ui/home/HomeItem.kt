package com.example.app.marvel.ui.home

import com.example.app.marvel.domain.models.*

sealed class HomeItem(var items: List<Any>,val order: Int) {
    class Characters(items: MutableList<Character>): HomeItem(items,1)
    class Comics(items: MutableList<Comic>): HomeItem(items,2)
    class Creators(items: MutableList<Creator>): HomeItem(items,3)
    class RecentSearches(items: MutableList<Searches>): HomeItem(items,4)
}