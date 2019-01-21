package com.ashalmawia.vehicles.features.list

import com.ashalmawia.vehicles.model.Vehicle

class VehicleListViewMock : VehiclesListView {

    private var _shownVehicles = mutableListOf<Vehicle>()

    val shownVehicles: List<Vehicle> = _shownVehicles

    override fun showVehicles(vehicles: List<Vehicle>) {
        _shownVehicles.addAll(vehicles)
    }

    override fun showError(message: Int) {
    }
}