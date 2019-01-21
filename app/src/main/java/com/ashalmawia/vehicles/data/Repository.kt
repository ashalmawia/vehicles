package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.data.network.NetworkRepository
import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

interface Repository {

    companion object {
        private val instance: Repository by lazy { NetworkRepository() }

        fun get(): Repository = instance
    }

    fun getVehicles(): Observable<List<Vehicle>>

}