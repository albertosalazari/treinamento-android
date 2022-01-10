package com.example.nesspresso.data.network.mapper

import com.example.nesspresso.data.network.entity.coffees.CoffeeResponse
import com.example.nesspresso.domain.entity.Coffee

class CoffeeMapper: DomainMapper<CoffeeResponse,Coffee> {
    override fun toDomain(from: CoffeeResponse) = Coffee(
        id = from.id,
        name = from.name,
        description = from.description,
        intensity = from.intensity,
        sizeList = from.sizeList,
        unitPrice = from.unitPrice,
        urlImage = from.urlImage
    )

    override fun toDomain(from: List<CoffeeResponse>) = from.map {
        toDomain(it)
    }
}