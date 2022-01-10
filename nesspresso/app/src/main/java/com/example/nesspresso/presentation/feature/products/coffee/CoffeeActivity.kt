package com.example.nesspresso.presentation.feature.products.coffee

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ActivityCoffeeBinding
import com.example.nesspresso.domain.entity.Type
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.example.nesspresso.presentation.extension.visibleOrGone
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

@Deprecated("deprecated")
class CoffeeActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityCoffeeBinding

    private val viewModel: CoffeeViewModel by viewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoffeeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setUpViewModel()
    }

    override fun getBottomNavigation(): BottomNavigationView =
        binding.bottomNavigation.bottomNavigation

    private fun setUpViewModel() {
        viewModel.coffees.observe(this@CoffeeActivity) { list ->
            setUpCoffeeRecyclerView(list)
        }

        viewModel.loading.observe(this@CoffeeActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@CoffeeActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchCoffees()
    }

    private fun setUpCoffeeRecyclerView(list: List<Type>) {
        binding.rvCapsules.apply {
            addItemDecoration(
                DividerItemDecoration(this@CoffeeActivity, DividerItemDecoration.VERTICAL)
            )
            /*adapter = CoffeeAdapter(list) {
                viewModel.setFavorite(it)
            }*/
        }
    }


}