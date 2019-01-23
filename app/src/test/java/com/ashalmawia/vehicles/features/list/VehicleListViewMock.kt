package com.ashalmawia.vehicles.features.list

import com.ashalmawia.vehicles.model.Vehicle

class VehicleListViewMock : VehiclesListView {

    private var _shownVehicles = mutableListOf<Vehicle>()
    private var _showErrorCalled = false

    val shownVehicles: List<Vehicle>
        get() = _shownVehicles
    val isShowErrorCalled
        get() = _showErrorCalled

    override fun showVehicles(vehicles: List<Vehicle>) {
        _shownVehicles.addAll(vehicles)
    }

    override fun showError() {
        _showErrorCalled = true     // could be done with Mockito
    }
}