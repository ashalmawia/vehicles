package com.ashalmawia.vehicles

import android.app.Application
import android.content.Context
import com.ashalmawia.vehicles.dependency.ServiceLocator
import com.ashalmawia.vehicles.dependency.ServiceLocatorImpl

/**
 * Open for testing.
 */
open class VehiclesApplication : Application() {

    open val serviceLocator: ServiceLocator = ServiceLocatorImpl
}

val Context.serviceLocator: ServiceLocator
    get() = (applicationContext as VehiclesApplication).serviceLocator