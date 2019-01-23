package com.ashalmawia.vehicles.features.details

import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.features.Navigator

interface VehicleDetailsPresenter {

    fun showVehicleWithId(id: Int)

    fun noVehicleId()
}

class VehicleDetailsPresenterImpl(
    private val view: VehicleDetailsView,
    private val repository: Repository,
    private val navigator: Navigator
) : VehicleDetailsPresenter {

    override fun showVehicleWithId(id: Int) {
        val vehicle = repository.vehicleById(id)
        if (vehicle != null) {
            view.showDetails(vehicle)
        } else {
            onError()
        }
    }

    override fun noVehicleId() {
        onError()
    }

    private fun onError() {
        view.showError()
        navigator.back()
    }
}