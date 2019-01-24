package com.ashalmawia.vehicles

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner

@Suppress("unused")
class TestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, TestVehiclesApplication::class.java.name, context)
    }
}