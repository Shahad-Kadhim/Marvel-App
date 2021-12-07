package com.example.app.marvel.ui.series

import android.os.Bundle
import android.view.View
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentSeriesBinding
import com.example.app.marvel.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment: BaseFragment<FragmentSeriesBinding , SeriesViewModel>() {

    override val layoutId: Int =R.layout.fragment_series
    override val viewModelClass: Class<SeriesViewModel> =SeriesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycle()
    }

    private fun setUpRecycle() {
        binding.recycle.adapter =SeriesRecyclerAdapter(emptyList(),viewModel)
    }
}