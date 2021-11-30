package com.example.app.marvel.ui.home

import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentHomeBinding
import com.example.app.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding , HomeViewModel>() {

    override val layoutId: Int =R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel> =HomeViewModel::class.java

}