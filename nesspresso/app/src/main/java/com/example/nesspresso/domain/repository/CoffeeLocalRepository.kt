package com.example.nesspresso.domain.repository

import com.example.nesspresso.data.database.entity.CoffeeEntity

interface CoffeeLocalRepository {
    fun add(coffeeEntity: CoffeeEntity)
    fun remove(coffeeEntity: CoffeeEntity)
    fun getAll(): List<CoffeeEntity>?
}