package com.example.nesspresso.data.repository

import com.example.nesspresso.data.database.AppDataBase
import com.example.nesspresso.data.database.entity.CoffeeEntity
import com.example.nesspresso.domain.repository.CoffeeLocalRepository

class CoffeeLocalRepositoryImpl(
    appDataBase: AppDataBase
): CoffeeLocalRepository {

    private val dao = appDataBase.getCoffeeDao()

    override fun add(coffeeEntity: CoffeeEntity) {
        dao.add(coffeeEntity)
    }

    override fun remove(coffeeEntity: CoffeeEntity) {
        dao.delete(coffeeEntity)
    }

    override fun getAll(): List<CoffeeEntity>? = dao.getAll()
}