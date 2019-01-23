package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

class MockRepository(private val list: List<Vehicle>) : Repository {

    override fun getVehicles(): Observable<List<Vehicle>> {
        return Observable.just(list)
    }

    override fun vehicleById(id: Int): Vehicle? = list.find { it.id == id }
}

class ErrorRepository(private val error: Throwable) : Repository {

    override fun getVehicles(): Observable<List<Vehicle>> {
        return Observable.error(error)
    }

    override fun vehicleById(id: Int): Vehicle? = null
}