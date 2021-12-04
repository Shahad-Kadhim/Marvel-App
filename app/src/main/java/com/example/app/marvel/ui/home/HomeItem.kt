package com.example.app.marvel.ui.home

import com.example.app.marvel.domain.models.*

sealed class HomeItem(val items: List<Any>,val order: Int) {
    class Characters(items: List<Character>): HomeItem(items,1)
    class Comics(items: List<Comic>): HomeItem(items,2)
    class Creators(items: List<Creator>): HomeItem(items,3)
    class RecentSearches(items: List<Searches>): HomeItem(items,4)
}