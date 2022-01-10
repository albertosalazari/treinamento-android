package com.example.nesspresso.presentation.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nesspresso.R
import com.example.nesspresso.presentation.feature.bag.BagActivity
import com.example.nesspresso.presentation.feature.favorites.FavoritesActivity
import com.example.nesspresso.presentation.feature.products.ProductsActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

abstract class  BaseBottomNavigationActivity : AppCompatActivity() {

    abstract val currentTab: Int

    abstract fun getBottomNavigation(): BottomNavigationView

    override fun onPause() {
        super.onPause()
        overridePendingTransition(0 ,0)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()
        setUpBottomNavigationActions()
        selectCurrentTab()
    }

    private fun setUpBottomNavigationActions() {
        getBottomNavigation().setOnItemSelectedListener {
            if(it.itemId != this.currentTab) when (it.itemId) {
                R.id.products_menu -> {
                    val intent = Intent(this, ProductsActivity::class.java)
                    startActivity(intent)
                }
                R.id.bag_menu -> {
                    val intent = Intent(this, BagActivity::class.java)
                    startActivity(intent)
                }
                R.id.favorites_menu -> {
                    val intent = Intent(this, FavoritesActivity::class.java)
                    startActivity(intent)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun  selectCurrentTab() {
        getBottomNavigation().selectedItemId = currentTab
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}