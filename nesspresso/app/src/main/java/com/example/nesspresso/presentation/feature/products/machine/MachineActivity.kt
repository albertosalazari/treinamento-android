package com.example.nesspresso.presentation.feature.products.machine

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.nesspresso.R
import com.example.nesspresso.databinding.ActivityMachineBinding
import com.example.nesspresso.presentation.base.BaseBottomNavigationActivity
import com.example.nesspresso.presentation.extension.visibleOrGone
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MachineActivity : BaseBottomNavigationActivity() {

    private lateinit var binding: ActivityMachineBinding

    private val viewModel: MachineViewModel by viewModel()

    override val currentTab: Int = R.id.products_menu

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMachineBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        setUpViewModel()
    }

    override fun getBottomNavigation(): BottomNavigationView =
        binding.bottomNavigation.bottomNavigation

    private fun setUpViewModel() {
        viewModel.machines.observe(this@MachineActivity) {
            val recyclerView = binding.rvMachines
            recyclerView.adapter = MachineAdapter(this@MachineActivity, it)
            recyclerView.addItemDecoration(
                DividerItemDecoration(this@MachineActivity, DividerItemDecoration.VERTICAL)
            )
        }

        viewModel.loading.observe(this@MachineActivity) { isLoading ->
            binding.viewLoading.root.visibleOrGone(isLoading)
        }

        viewModel.error.observe(this@MachineActivity) { hasError ->
            binding.viewError.root.visibleOrGone(hasError)
        }

        viewModel.fetchMachines()
    }
}