package com.sylphid.ptupokedexcharactermaker.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sylphid.ptupokedexcharactermaker.databinding.FragmentStartingPageBinding

class StartingPageFragment: ViewModelFragment() {
    private lateinit var binding: FragmentStartingPageBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartingPageBinding.inflate(layoutInflater)

        binding.btnAbilities.setOnClickListener {
            viewModel.setLoading()
            findNavController().navigate(
                StartingPageFragmentDirections.actionStartingPageToAbilities()
            )
        }

        return binding.root
    }
}