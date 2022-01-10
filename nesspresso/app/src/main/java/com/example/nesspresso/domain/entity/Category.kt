package com.example.nesspresso.domain.entity

 class Category (
     var category: String,
     var products: List<Product>,
 ): Type(ItemType.CATEGORY)