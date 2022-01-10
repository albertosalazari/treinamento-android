package com.example.nesspresso.presentation.feature.products.accessories

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ActivityAcessoriesBinding
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.example.nesspresso.presentation.extension.visibleOrGone
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class AccessorieActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityAcessoriesBinding

    private val viewModel: AccessorieViewModel by viewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityAcessoriesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setUpViewModel()
    }

    override fun getBottomNavigation(): BottomNavigationView =
        binding.bottomNavigation.bottomNavigation

    private fun setUpViewModel() {
        viewModel.accessories.observe(this@AccessorieActivity) {
            val recyclerView = binding.rvAccessories
            recyclerView.adapter = AccessorieAdapter(this@AccessorieActivity, it)
            recyclerView.addItemDecoration(
                DividerItemDecoration(this@AccessorieActivity, DividerItemDecoration.VERTICAL)
            )
        }

        viewModel.loading.observe(this@AccessorieActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@AccessorieActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchAccessories()
    }
}