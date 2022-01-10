package com.example.nesspresso.data.network.entity.coffees

import com.squareup.moshi.Json

data class CoffeeResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "nome") val name: String,
    @Json(name = "descricao") val description: String,
    @Json(name = "intensidade") val intensity: Int?,
    @Json(name = "precoUnitario") val unitPrice: Double,
    @Json(name = "imagem") val urlImage: String,
    @Json(name = "medidas") val sizeList: List<String>
)
