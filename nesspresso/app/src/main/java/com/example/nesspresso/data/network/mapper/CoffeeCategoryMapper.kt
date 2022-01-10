package com.example.nesspresso.data.network.mapper

import com.example.nesspresso.data.network.entity.coffees.CoffeeCategoryResponse
import com.example.nesspresso.domain.entity.Category

class CoffeeCategoryMapper: DomainMapper<CoffeeCategoryResponse, Category> {

    override fun toDomain(from: CoffeeCategoryResponse) = Category (
        category = from.category,
        products = CoffeeMapper().toDomain(from.coffees)
    )

    override fun toDomain(from: List<CoffeeCategoryResponse>) = from.map{
        toDomain(it)
    }

}