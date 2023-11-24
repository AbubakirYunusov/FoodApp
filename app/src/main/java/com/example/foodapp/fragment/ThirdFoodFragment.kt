package com.example.foodapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.animeapp.R
import com.example.animeapp.databinding.FragmentFirstFoodBinding
import com.example.animeapp.databinding.FragmentSecondFoodBinding
import com.example.animeapp.databinding.FragmentThirdFoodBinding

class ThirdFoodFragment : Fragment() {

    private val binding: FragmentThirdFoodBinding by lazy {
        FragmentThirdFoodBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}