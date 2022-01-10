package com.example.nesspresso.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.nesspresso.data.database.entity.CoffeeEntity

@Dao
interface CoffeeDao {

    @Insert
    fun add(coffeeEntity: CoffeeEntity)

    @Delete
    fun delete(coffeeEntity: CoffeeEntity)

    @Query("SELECT * FROM CoffeeEntity")
    fun getAll():List<CoffeeEntity>?
}