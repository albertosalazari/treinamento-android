package com.example.nesspresso.data.network.mapper

import com.example.nesspresso.data.network.entity.accessories.AccessorieResponse
import com.example.nesspresso.domain.entity.Accessorie

class AccessorieMapper: DomainMapper<AccessorieResponse,Accessorie> {
    override fun toDomain(from: AccessorieResponse) = Accessorie (
        id = from.id,
        name = from.nome,
        urlImage = from.imagem,
        unitPrice = from.preco,
        description = from.descricao
    )

    override fun toDomain(from: List<AccessorieResponse>) = from.map{
        toDomain(it)
    }

}