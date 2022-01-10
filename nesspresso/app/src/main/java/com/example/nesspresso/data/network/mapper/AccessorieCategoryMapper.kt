package com.example.nesspresso.data.network.mapper

import com.example.nesspresso.data.network.entity.accessories.AccessorieCategoryResponse
import com.example.nesspresso.domain.entity.Category

class AccessorieCategoryMapper: DomainMapper<AccessorieCategoryResponse, Category> {
    override fun toDomain(from: AccessorieCategoryResponse)= Category (
        category = from.category,
        products = AccessorieMapper().toDomain(from.accessories)
    )

    override fun toDomain(from: List<AccessorieCategoryResponse>) = from.map{
        toDomain(it)
    }
}