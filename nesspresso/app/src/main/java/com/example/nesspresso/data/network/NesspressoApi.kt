package com.example.nesspresso.data.network

import com.example.nesspresso.data.network.entity.accessories.AccessorieCategoryResponse
import com.example.nesspresso.data.network.entity.coffees.CoffeeCategoryResponse
import com.example.nesspresso.data.network.entity.machines.MachineResponse
import retrofit2.http.GET

interface NesspressoApi {

    @GET("/capsulas")
    suspend fun getCoffees(): List<CoffeeCategoryResponse>

    @GET("/maquinas")
    suspend fun getMachines(): List<MachineResponse>

    @GET("/acessorios")
    suspend fun getAccessories(): List<AccessorieCategoryResponse>
}