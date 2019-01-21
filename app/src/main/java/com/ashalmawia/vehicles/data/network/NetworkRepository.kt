package com.ashalmawia.vehicles.data.network

import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.model.Vehicle

class NetworkRepository : Repository {

    override fun getVehicles(): List<Vehicle> {
        // TODO; mock
        return listOf(
            Vehicle("Sample Vehicle 1"),
            Vehicle("Sample Vehicle 2")
        )
    }
}