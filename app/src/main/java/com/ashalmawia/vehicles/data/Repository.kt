package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.data.network.NetworkRepository
import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

interface Repository {

    companion object {
        private val instance: Repository by lazy { InMemoryCache(NetworkRepository()) }

        fun get(): Repository = instance
    }

    fun getVehicles(): Observable<List<Vehicle>>

    fun vehicleById(id: Int): Vehicle?

}