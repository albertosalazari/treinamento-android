package com.example.nesspresso.presentation.feature.favorites

import android.os.Bundle
import com.example.nesspresso.R
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.example.nesspresso.databinding.ActivityFavoritesBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavoritesActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityFavoritesBinding

    override val currentTab: Int = R.id.favorites_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityFavoritesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation.bottomNavigation
}