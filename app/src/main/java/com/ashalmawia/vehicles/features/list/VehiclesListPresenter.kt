package com.ashalmawia.vehicles.features.list

import com.ashalmawia.vehicles.data.Repository

interface VehiclesListPresenter {

    fun start()

    fun stop()
}

class VehiclesListPresenterImpl(
    private val view: VehiclesListView,
    private val repository: Repository
) : VehiclesListPresenter {

    override fun start() {
        // TODO: make async
        view.showVehicles(repository.getVehicles())
    }

    override fun stop() {
    }
}