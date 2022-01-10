package com.example.nesspresso.data.network.entity.accessories

import com.squareup.moshi.Json

class AccessorieCategoryResponse(
    @Json(name = "categoria") val category: String,
    @Json(name = "itens") val accessories: List<AccessorieResponse>
)