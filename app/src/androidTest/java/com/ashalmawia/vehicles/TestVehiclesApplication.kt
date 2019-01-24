package com.ashalmawia.vehicles

import com.ashalmawia.vehicles.basic_test.TestServiceLocator
import com.ashalmawia.vehicles.dependency.ServiceLocator

class TestVehiclesApplication : VehiclesApplication() {

    override val serviceLocator: ServiceLocator
        get() = TestServiceLocator()
}