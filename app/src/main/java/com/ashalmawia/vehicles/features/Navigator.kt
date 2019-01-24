package com.ashalmawia.vehicles.features

import android.support.annotation.IdRes
import android.support.v4.app.FragmentManager
import com.ashalmawia.vehicles.features.details.VehicleDetailsFragment
import com.ashalmawia.vehicles.features.list.VehiclesListFragment
import com.ashalmawia.vehicles.model.Vehicle

private const val TAG_VEHICLES_LIST = "list"
private const val TAG_VEHICLE_DETAILS = "details"

interface Navigator {

    fun openVehiclesList()

    fun openVehicleDetails(vehicle: Vehicle)

    fun back()
}

class NavigatorImpl(
    @IdRes private val containerId: Int,
    private val fragmentManager: FragmentManager
) : Navigator {

    override fun openVehiclesList() {
        val fragment = fragmentManager.findFragmentByTag(TAG_VEHICLES_LIST) ?: VehiclesListFragment()
        fragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(TAG_VEHICLES_LIST)
            .commit()
    }

    override fun openVehicleDetails(vehicle: Vehicle) {
        val fragment = fragmentManager.findFragmentByTag(TAG_VEHICLE_DETAILS) ?: VehicleDetailsFragment()
        fragment.arguments = VehicleDetailsFragment.arguments(vehicle)

        fragmentManager.beginTransaction()
            .replace(containerId, fragment)
            .addToBackStack(TAG_VEHICLE_DETAILS)
            .commit()
    }

    override fun back() {
        fragmentManager.popBackStack()
    }
}