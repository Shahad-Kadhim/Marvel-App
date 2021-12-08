package com.example.app.marvel.ui.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.cardview.widget.CardView
import androidx.navigation.NavDirections
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentHomeBinding
import com.example.app.marvel.ui.base.BaseFragment
import com.example.app.marvel.util.Constants
import com.example.app.marvel.util.goToFragment
import com.example.app.marvel.util.goToFragmentWithTransition
import com.example.app.marvel.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: BaseFragment<FragmentHomeBinding , HomeViewModel>() {

    override val layoutId: Int =R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel> =HomeViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerAdapter()
        observeEvents()
    }

    private fun observeEvents() {
        with(viewModel){
            clickSearchEvent.observeEvent(this@HomeFragment){
                binding.root.goToFragmentWithTransition(
                    HomeFragmentDirections.actionHomeFragmentToSearchFragment(),
                    FragmentNavigatorExtras(binding.search to Constants.SEARCH_KEY)
                )
            }

            clickCharacterItemEvent.observeEvent(this@HomeFragment){
                navTo(HomeFragmentDirections.actionHomeFragmentToCharacterDetailsFragment(it))
            }

            clickCreatorItemEvent.observeEvent(this@HomeFragment){

            }

            clickComicItemEvent.observeEvent(this@HomeFragment){

            }
            clickSearchItemEvent.observeEvent(this@HomeFragment){

            }
            clickSeeMoreCharacterEvent.observeEvent(this@HomeFragment){

            }
            clickSeeMoreComicEvent.observeEvent(this@HomeFragment){

            }
            clickSeeMoreCreatorEvent.observeEvent(this@HomeFragment){

            }
            clickSeeMoreSearchesEvent.observeEvent(this@HomeFragment){

            }
        }
    }

    private fun navTo(action: NavDirections) {
        binding.root.goToFragment(action)
    }


    private fun setupRecyclerAdapter() {
        binding.recycle.adapter= HomeRecyclerAdapter(
            mutableListOf(
                HomeItem.Characters(mutableListOf()),
                HomeItem.Creators(mutableListOf()),
                HomeItem.Comics(mutableListOf()),
                HomeItem.RecentSearches(mutableListOf())
            ),
            viewModel)

    }
}