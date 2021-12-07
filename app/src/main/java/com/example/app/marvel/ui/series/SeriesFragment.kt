package com.example.app.marvel.ui.series

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentSeriesBinding
import com.example.app.marvel.ui.base.BaseFragment
import com.example.app.marvel.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SeriesFragment: BaseFragment<FragmentSeriesBinding , SeriesViewModel>() {

    override val layoutId: Int =R.layout.fragment_series
    override val viewModelClass: Class<SeriesViewModel> =SeriesViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycle()
        observeEvents()
    }

    private fun observeEvents() {
        with(viewModel){

            clickBackEvent.observeEvent(this@SeriesFragment){
                findNavController().navigateUp()
            }

            clickSeriesEvent.observeEvent(this@SeriesFragment){
                //nav to series detail fragment
            }

        }
    }

    private fun setUpRecycle() {
        binding.recycle.adapter =SeriesRecyclerAdapter(emptyList(),viewModel)
    }
}