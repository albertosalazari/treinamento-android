package com.example.nesspresso.presentation.feature.products.machine

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.nesspresso.domain.entity.Machine
import com.example.nesspresso.domain.repository.CoffeeRepository
import com.example.nesspresso.presentation.base.BaseViewModel

class MachineViewModel(
    private val repository: CoffeeRepository
) : BaseViewModel() {

    private val _machines = MutableLiveData<List<Machine>>()
    val machines: LiveData<List<Machine>> = _machines

    fun fetchMachines() {
        launch {
            repository.getMachines().run {
                _machines.postValue(setMachines(this))
            }
        }

    }

    private fun setMachines(repositoryList: List<Machine>): MutableList<Machine> {
        val machineList: MutableList<Machine> = mutableListOf()

        repositoryList.forEach {
            machineList.add(it)
        }

        return machineList
    }
}