package com.example.nesspresso.domain.entity

open class Product (
    var id: Int,
    var name: String,
    var urlImage: String?,
    var unitPrice: Double,
    var description: String?
): Type(ItemType.PRODUCT)