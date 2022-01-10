package com.example.nesspresso

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nesspresso.databinding.FragmentCoffeeDetailBinding


const val EXTRA_COFFEE_ID = "EXTRA_COFFEE_ID"

class CoffeeDetailFragment : Fragment() {

    private lateinit var binding: FragmentCoffeeDetailBinding

    private val coffeeId by lazy {
        arguments?.getInt(EXTRA_COFFEE_ID)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCoffeeDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvText.text = coffeeId.toString()
    }

}