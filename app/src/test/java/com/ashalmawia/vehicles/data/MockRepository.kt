package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

class MockRepository(private val list: List<Vehicle>) : Repository {

    override fun getVehicles(): Observable<List<Vehicle>> {
        return Observable.just(list)
    }
}