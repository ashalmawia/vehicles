package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.Vehicle

class MockRepository(private val list: List<Vehicle>) : Repository {

    override fun getVehicles(): List<Vehicle> {
        return list
    }
}