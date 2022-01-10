package com.example.nesspresso.di

import com.example.nesspresso.data.database.AppDataBase
import com.example.nesspresso.data.network.mapper.AccessorieCategoryMapper
import com.example.nesspresso.data.network.mapper.CoffeeCategoryMapper
import com.example.nesspresso.data.network.mapper.MachineMapper
import com.example.nesspresso.data.network.RetrofitConfig
import com.example.nesspresso.data.repository.CoffeeLocalRepositoryImpl
import com.example.nesspresso.data.repository.CoffeeRepositoryImpl
import com.example.nesspresso.domain.repository.CoffeeLocalRepository
import com.example.nesspresso.domain.repository.CoffeeRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {

    single { RetrofitConfig.service }

    single { CoffeeCategoryMapper() }
    single { AccessorieCategoryMapper() }
    single { MachineMapper() }

    single { AppDataBase.create(androidApplication()) }

    factory<CoffeeRepository> { CoffeeRepositoryImpl(get(), get(), get(), get()) }
    factory<CoffeeLocalRepository> {CoffeeLocalRepositoryImpl(get())}
}
