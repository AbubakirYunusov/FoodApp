package com.example.foodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentFirstFoodBinding

class FirstFoodFragment : Fragment() {

    private val binding: FragmentFirstFoodBinding by lazy {
        FragmentFirstFoodBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomFood.setOnClickListener {
            findNavController().navigate(
                R.id.action_firstFoodFragment_to_secondFoodFragment
            )
        }
    }
}