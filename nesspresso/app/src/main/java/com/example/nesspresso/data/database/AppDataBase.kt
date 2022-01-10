package com.example.nesspresso.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nesspresso.data.database.dao.CoffeeDao
import com.example.nesspresso.data.database.entity.CoffeeEntity

@Database(entities = [CoffeeEntity::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getCoffeeDao(): CoffeeDao

    companion object {
        private const val DATABASE_NAME = "nespresso-db"
        fun create(application: Application): AppDataBase {
            return Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}