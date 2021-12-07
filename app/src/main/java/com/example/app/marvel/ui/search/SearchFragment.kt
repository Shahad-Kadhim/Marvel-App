package com.example.app.marvel.ui.search

import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentSearchBinding
import com.example.app.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment: BaseFragment<FragmentSearchBinding,SearchViewModel>() {
    override val layoutId: Int =R.layout.fragment_search
    override val viewModelClass: Class<SearchViewModel> =SearchViewModel::class.java

}