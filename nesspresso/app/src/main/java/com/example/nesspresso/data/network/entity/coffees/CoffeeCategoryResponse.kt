package com.example.nesspresso.data.network.entity.coffees

import com.squareup.moshi.Json

data class CoffeeCategoryResponse(
    @Json(name = "categoria") val category: String,
    @Json(name = "cafes") val coffees: List<CoffeeResponse>
)