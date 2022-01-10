package com.example.nesspresso.presentation.feature.products

import android.content.Intent
import android.os.Bundle
import com.example.nesspresso.R
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.example.nesspresso.databinding.ActivityProductsBinding
import com.example.nesspresso.presentation.feature.products.accessories.AccessorieActivity
import com.example.nesspresso.presentation.feature.products.coffee.CoffeeHostActivity
import com.example.nesspresso.presentation.feature.products.machine.MachineActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityProductsBinding

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setUpProductActions()
    }

    private fun setUpProductActions() {
        binding.contentCoffees.root.setOnClickListener {
            val intent = Intent(this, CoffeeHostActivity::class.java)
            startActivity(intent)
        }

        binding.contentMachines.root.setOnClickListener {
            val intent = Intent(this, MachineActivity::class.java)
            startActivity(intent)
        }

        binding.contentAccessories.root.setOnClickListener {
            val intent = Intent(this, AccessorieActivity::class.java)
            startActivity(intent)
        }

    }

    override fun getBottomNavigation(): BottomNavigationView = binding.bottomNavigation.bottomNavigation

}