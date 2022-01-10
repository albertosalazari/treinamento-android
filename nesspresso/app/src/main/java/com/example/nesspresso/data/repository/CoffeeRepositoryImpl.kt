package com.example.nesspresso.data.repository

import com.example.nesspresso.data.network.NesspressoApi
import com.example.nesspresso.data.network.mapper.AccessorieCategoryMapper
import com.example.nesspresso.data.network.mapper.CoffeeCategoryMapper
import com.example.nesspresso.data.network.mapper.MachineMapper
import com.example.nesspresso.domain.entity.Category
import com.example.nesspresso.domain.entity.Machine
import com.example.nesspresso.domain.repository.CoffeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CoffeeRepositoryImpl(
    private val api: NesspressoApi,
    private val coffeeCategoryMapper: CoffeeCategoryMapper,
    private val accessorieCategoryMapper: AccessorieCategoryMapper,
    private val machineMapper: MachineMapper,
): CoffeeRepository {


    override suspend fun getCooffes(): List<Category> {
        return withContext(Dispatchers.IO) {
            coffeeCategoryMapper.toDomain(api.getCoffees())
        }
    }

    override suspend fun getAccessories(): List<Category> {
        return withContext(Dispatchers.IO) {
            accessorieCategoryMapper.toDomain(api.getAccessories())
        }
    }

    override suspend fun getMachines(): List<Machine> {
        return withContext(Dispatchers.IO) {
            machineMapper.toDomain(api.getMachines())
        }
    }
}