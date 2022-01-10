package com.example.nesspresso.presentation.feature.bag

import android.os.Bundle
import com.example.nesspresso.R
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.example.nesspresso.databinding.ActivityBagBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BagActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityBagBinding

    override val currentTab: Int = R.id.bag_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityBagBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation.bottomNavigation
}