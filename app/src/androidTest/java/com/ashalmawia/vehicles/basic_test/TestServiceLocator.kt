package com.ashalmawia.vehicles.basic_test

import com.ashalmawia.vehicles.StubRepository
import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.dependency.ServiceLocator
import com.ashalmawia.vehicles.model.Vehicle

class TestServiceLocator : ServiceLocator {

    override val repository: Repository
        get() = StubRepository(listOf(
            Vehicle(1, "Test Vehicle 1", "GB", "Black", "Van", false),
            Vehicle(2, "Test Vehicle 2", "GB", "Black", "Van", false)
        ))
}