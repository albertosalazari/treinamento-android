package com.example.nesspresso.data.network.entity.machines

import com.squareup.moshi.Json

class MachineResponse (
    @Json(name = "id") val id: Int,
    @Json(name = "nome") val name: String,
    @Json(name = "preco") val unitPrice: Double,
    @Json(name = "descricao") val description: String,
    @Json(name = "imagem") val urlImage: String
)