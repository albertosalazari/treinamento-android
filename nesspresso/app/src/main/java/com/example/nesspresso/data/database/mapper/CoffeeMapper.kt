package com.example.nesspresso.data.database.mapper

import com.example.nesspresso.data.database.entity.CoffeeEntity
import com.example.nesspresso.domain.entity.Coffee

fun CoffeeEntity.toCoffee() = Coffee (id, name, urlImage, unitPrice, description, intensity, sizeList)

fun Coffee.toEntity() = CoffeeEntity(id, name, urlImage, unitPrice, description, intensity, sizeList)