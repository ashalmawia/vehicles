package com.ashalmawia.vehicles

import android.app.Application
import android.content.Context
import com.ashalmawia.vehicles.dependency.ServiceLocator
import com.ashalmawia.vehicles.dependency.ServiceLocatorImpl

class VehiclesApplication : Application() {

    val serviceLocator: ServiceLocator = ServiceLocatorImpl
}

val Context.serviceLocator: ServiceLocator
    get() = (applicationContext as VehiclesApplication).serviceLocator