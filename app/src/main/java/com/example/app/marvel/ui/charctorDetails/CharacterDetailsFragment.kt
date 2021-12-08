package com.example.app.marvel.ui.charctorDetails

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.*
import com.example.app.marvel.R
import com.example.app.marvel.databinding.FragmentCharacterDetailsBinding
import com.example.app.marvel.ui.base.BaseFragment
import com.example.app.marvel.util.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterDetailsFragment: BaseFragment<FragmentCharacterDetailsBinding , CharacterDetailsViewModel>() {

    override val layoutId: Int =R.layout.fragment_character_details
    override val viewModelClass: Class<CharacterDetailsViewModel> =CharacterDetailsViewModel::class.java

    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getCharacter(args.id)
        setUpRecycle()
        observeEvents()
    }

    private fun observeEvents() {
        with(viewModel){

            clickBackEvent.observeEvent(this@CharacterDetailsFragment){
                findNavController().navigateUp()
            }


        }
    }

    private fun setUpRecycle() {
        binding.apply {
            seriesRecycle.adapter=DetailsRecyclerAdapter(emptyList(),this@CharacterDetailsFragment.viewModel)
            eventRecycle.adapter=DetailsRecyclerAdapter(emptyList(),this@CharacterDetailsFragment.viewModel)
            comicRecycle.adapter=DetailsRecyclerAdapter(emptyList(),this@CharacterDetailsFragment.viewModel)
            storyRecycle.adapter=StoryRecyclerAdapter(emptyList(),this@CharacterDetailsFragment.viewModel)
        }
    }
}