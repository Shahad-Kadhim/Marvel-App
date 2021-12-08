package com.example.app.marvel.ui.search

import android.os.Bundle
import android.view.View
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentSearchBinding
import com.example.app.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding,SearchViewModel>() {
    override val layoutId: Int =R.layout.fragment_search
    override val viewModelClass: Class<SearchViewModel> =SearchViewModel::class.java


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerAdapter()
        observeEvents()
    }

    private fun observeEvents() {

    }

    private fun setupRecyclerAdapter() {
        binding.recycle.adapter= SearchAdapter(mutableListOf(), viewModel)

    }
}