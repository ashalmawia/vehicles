package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

class MockRepository(list: List<Vehicle>) : Repository {

    private val list = list.toMutableList()

    override fun getVehicles(): Observable<List<Vehicle>> {
        return Observable.just(list)
    }

    fun changeVehicles(vehicles: List<Vehicle>) {
        list.clear()
        list.addAll(vehicles)
    }

    override fun vehicleById(id: Int): Vehicle? = list.find { it.id == id }
}

class ErrorRepository(private val error: Throwable) : Repository {

    override fun getVehicles(): Observable<List<Vehicle>> {
        return Observable.error(error)
    }

    override fun vehicleById(id: Int): Vehicle? = null
}