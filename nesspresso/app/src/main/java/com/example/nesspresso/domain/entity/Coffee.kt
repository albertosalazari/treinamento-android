package com.example.nesspresso.domain.entity

class Coffee(
    id: Int,
    name: String,
    urlImage: String?,
    unitPrice: Double,
    description: String?,
    var intensity: Int?,
    var sizeList: List<String>,
    var isFavorite: Boolean = false
): Product(id, name, urlImage, unitPrice, description)