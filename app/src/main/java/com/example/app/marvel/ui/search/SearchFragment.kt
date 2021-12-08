package com.example.app.marvel.ui.search

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentSearchBinding
import com.example.app.marvel.ui.base.BaseFragment
import com.example.app.marvel.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding,SearchViewModel>() {
    override val layoutId: Int =R.layout.fragment_search
    override val viewModelClass: Class<SearchViewModel> =SearchViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
            TransitionInflater
                .from(context)
                .inflateTransition(android.R.transition.move)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerAdapter()
        observeEvents()
    }

    private fun observeEvents() {
        viewModel.clickSearchItemEvent.observeEvent(this){
            when(it.type){
                SearchType.CHARACTERS -> {
                    //nav to detail character
                }
                SearchType.CREATORS -> {
                    // nav to detail creator
                }
            }
        }
    }

    private fun setupRecyclerAdapter() {
        binding.recycle.adapter= SearchAdapter(mutableListOf(), viewModel)
    }
}