package com.example.nesspresso.presentation.feature.products.coffee

import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ActivityCoffeeHostBinding
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val VIEW_CONTENT = 0
private const val VIEW_LOADING = 1
private const val VIEW_ERROR = 2

class CoffeeHostActivity : BaseBottomNavigationActivity() {

    private val viewModel: CoffeeViewModel by viewModel()

    private lateinit var binding: ActivityCoffeeHostBinding

    private val navController by lazy {
        (supportFragmentManager.findFragmentById(binding.navHostContainer.id) as NavHostFragment)
            .findNavController()
    }

    override val currentTab: Int = R.id.products_menu

    override fun getBottomNavigation(): BottomNavigationView =
        binding.contentBottomNavigation.bottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeHostBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setUpViewModel()
        setupNavController()


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setupNavController() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val title = when (destination.id) {
                R.id.coffeeFragment -> getString(R.string.coffees)
                else -> "Detalhes"
            }
            supportActionBar?.title = title
        }
    }

    private fun setUpViewModel() {
        viewModel.loading.observe(this) { isLoading ->
            binding.vpCoffee.displayedChild = if (isLoading) VIEW_LOADING else VIEW_CONTENT
        }

        viewModel.error.observe(this) { hasError ->
            binding.vpCoffee.displayedChild = if (hasError) VIEW_ERROR else VIEW_CONTENT
        }
    }

}