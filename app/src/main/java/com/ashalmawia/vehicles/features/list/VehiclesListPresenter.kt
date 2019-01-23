package com.ashalmawia.vehicles.features.list

import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.features.Navigator
import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

interface VehiclesListPresenter {

    fun start()

    fun stop()

    fun openVehicleDetails(vehicle: Vehicle)
}

class VehiclesListPresenterImpl(
    private val view: VehiclesListView,
    private val repository: Repository,
    private val navigator: Navigator
) : VehiclesListPresenter {

    private val subscriptions = CompositeDisposable()

    override fun start() {
        val subscription = repository.getVehicles()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                view.showVehicles(it)
            }, {
                view.showError()
            })
        subscriptions.add(subscription)
    }

    override fun stop() {
        subscriptions.clear()
    }

    override fun openVehicleDetails(vehicle: Vehicle) {
        navigator.openVehicleDetails(vehicle)
    }
}