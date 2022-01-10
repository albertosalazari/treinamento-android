package com.example.nesspresso.presentation.feature.products.accessories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nesspresso.domain.entity.Category
import com.example.nesspresso.domain.entity.Type
import com.example.nesspresso.domain.repository.CoffeeRepository
import com.example.nesspresso.presentation.base.BaseViewModel

class AccessorieViewModel(
    private val repository: CoffeeRepository
) : BaseViewModel() {

    private val _accessories = MutableLiveData<List<Type>>()
    val accessories: LiveData<List<Type>> = _accessories

    fun fetchAccessories() {
        launch {
            repository.getAccessories().run {
                _accessories.postValue(setAccessories(this))
            }
        }

    }

    private fun setAccessories(repositoryList: List<Category>): MutableList<Type> {
        val accessorieList: MutableList<Type> = mutableListOf()

        repositoryList.forEach {
            accessorieList.add(it)
            accessorieList.addAll(it.products)
        }

        return accessorieList
    }
}