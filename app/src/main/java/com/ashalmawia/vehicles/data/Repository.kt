package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

interface Repository {

    fun getVehicles(): Observable<List<Vehicle>>

    fun vehicleById(id: Int): Vehicle?

}