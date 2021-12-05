package com.example.app.marvel.ui.home

import android.os.Bundle
import android.view.View
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentHomeBinding
import com.example.app.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding , HomeViewModel>() ,HomeInteractionListener{

    override val layoutId: Int =R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel> =HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // just for test
        binding.recycle.adapter= HomeRecyclerAdapter(
            mutableListOf(
                HomeItem.Characters(mutableListOf()),
                HomeItem.Creators(mutableListOf()),
                HomeItem.Comics(mutableListOf()),
                HomeItem.RecentSearches(mutableListOf())
            ),
            this)

    }
}