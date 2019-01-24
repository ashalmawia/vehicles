package com.ashalmawia.vehicles

import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

class StubRepository(private val list: List<Vehicle>) : Repository {

    override fun getVehicles(): Observable<List<Vehicle>> {
        return Observable.just(list)
    }

    override fun vehicleById(id: Int): Vehicle? = list.find { it.id == id }
}