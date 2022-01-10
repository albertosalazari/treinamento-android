package com.example.nesspresso.data.network.mapper

import com.example.nesspresso.data.network.entity.machines.MachineResponse
import com.example.nesspresso.domain.entity.Machine

class MachineMapper: DomainMapper<MachineResponse,Machine>{
    override fun toDomain(from: MachineResponse) = Machine(
    id = from.id,
    name = from.name,
    urlImage = from.urlImage,
    unitPrice = from.unitPrice,
    description = from.description,
    )

    override fun toDomain(from: List<MachineResponse>) = from.map{
        toDomain(it)
    }
}