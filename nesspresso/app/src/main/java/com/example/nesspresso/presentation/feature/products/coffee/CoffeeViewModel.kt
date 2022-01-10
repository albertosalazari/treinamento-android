package com.example.nesspresso.presentation.feature.products.coffee

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nesspresso.data.database.mapper.toEntity
import com.example.nesspresso.domain.entity.Category
import com.example.nesspresso.domain.entity.Coffee
import com.example.nesspresso.domain.entity.Type
import com.example.nesspresso.domain.repository.CoffeeLocalRepository
import com.example.nesspresso.domain.repository.CoffeeRepository
import com.example.nesspresso.presentation.base.BaseViewModel

class CoffeeViewModel(
    private val coffeeRepository: CoffeeRepository,
    private val coffeeLocalRepository: CoffeeLocalRepository
) : BaseViewModel() {

    private val _coffees = MutableLiveData<List<Type>>()
    val coffees: LiveData<List<Type>> = _coffees

    fun fetchCoffees() {
        launch {
            val coffeeCategoryList = coffeeRepository.getCooffes()
            _coffees.postValue(setCoffees(coffeeCategoryList))
        }

    }

    private fun setCoffees(repositoryList: List<Category>): MutableList<Type> {
        val coffeeList = mutableListOf<Type>()

        val favoritedCoffees = coffeeLocalRepository.getAll()

        repositoryList.forEach { category ->
            coffeeList.add(category)
            favoritedCoffees?.takeIf{ it.isNotEmpty() }?.let{ favoritedList ->
                setIsCoffeeFavorite(favoritedList.map{ it.id }, category.products.map{ it as Coffee })
            }
            coffeeList.addAll(category.products)

        }

        return coffeeList
    }

    private fun setIsCoffeeFavorite(favoriteIdList: List<Int>, coffeeList: List<Coffee>) {
        favoriteIdList.forEach { id ->
            coffeeList.forEach { it.isFavorite = it.id == id }
        }
    }

    fun setFavorite(coffee: Coffee) {
        val coffeeEntity = coffee.toEntity()

        if(coffee.isFavorite) coffeeLocalRepository.add(coffeeEntity)
        else coffeeLocalRepository.remove(coffeeEntity)
    }
}