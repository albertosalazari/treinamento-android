package com.example.nesspresso.data.network.entity.accessories

import com.squareup.moshi.Json

class AccessorieResponse (
    @Json(name = "id") val id: Int,
    @Json(name = "nome") val nome: String,
    @Json(name = "preco") val preco: Double,
    @Json(name = "imagem") val imagem: String,
    @Json(name = "descricao") val descricao: String?,
)