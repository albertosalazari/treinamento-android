package com.example.nesspresso.di

import com.example.nesspresso.presentation.feature.products.accessories.AccessorieViewModel
import com.example.nesspresso.presentation.feature.products.coffee.CoffeeViewModel
import com.example.nesspresso.presentation.feature.products.machine.MachineViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { CoffeeViewModel(get(), get()) }
    viewModel { MachineViewModel(get()) }
    viewModel { AccessorieViewModel(get()) }
}