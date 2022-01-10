package com.example.nesspresso.domain.entity

class Machine(
    id: Int,
    name: String,
    urlImage: String?,
    unitPrice: Double,
    description: String?
): Product(id, name, urlImage, unitPrice, description)