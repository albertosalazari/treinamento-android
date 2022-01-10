package com.example.nesspresso.domain.repository

import com.example.nesspresso.domain.entity.Category
import com.example.nesspresso.domain.entity.Machine

interface CoffeeRepository {
    suspend fun getCooffes(): List<Category>
    suspend fun getAccessories(): List<Category>
    suspend fun getMachines(): List<Machine>
}