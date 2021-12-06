package com.example.app.marvel.ui.series

import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentSeriesBinding
import com.example.app.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment: BaseFragment<FragmentSeriesBinding , SeriesViewModel>() {

    override val layoutId: Int =R.layout.fragment_series
    override val viewModelClass: Class<SeriesViewModel> =SeriesViewModel::class.java

}