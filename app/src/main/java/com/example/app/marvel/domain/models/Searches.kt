package com.example.app.marvel.domain.models

import com.example.app.marvel.ui.search.SearchType

class Searches(
    val id: Int,
    val imageUrl: String,
    val name: String,
    val type: SearchType
)