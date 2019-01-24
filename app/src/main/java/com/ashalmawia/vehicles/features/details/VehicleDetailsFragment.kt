package com.ashalmawia.vehicles.features.details

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ashalmawia.vehicles.R
import com.ashalmawia.vehicles.features.actionBar
import com.ashalmawia.vehicles.features.navigator
import com.ashalmawia.vehicles.model.Vehicle
import com.ashalmawia.vehicles.serviceLocator

private const val ARGUMENTS_VEHICLE_ID = "VehicleId"

class VehicleDetailsFragment : Fragment() {

    companion object {
        fun arguments(vehicle: Vehicle) = Bundle().apply {
            putInt(ARGUMENTS_VEHICLE_ID, vehicle.id)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_vehicle_details, container, false)
    }

    override fun onViewCreated(root: View, savedInstanceState: Bundle?) {
        super.onViewCreated(root, savedInstanceState)

        val view = VehicleDetailsViewImpl(root, actionBar)
        val presenter = VehicleDetailsPresenterImpl(view, activity!!.serviceLocator.repository, navigator)

        val id = arguments?.vehicleId
        if (id != null) {
            presenter.showVehicleWithId(id)
        } else {
            presenter.noVehicleId()
        }
    }
}

private val Bundle.vehicleId
    get() = if (this.containsKey(ARGUMENTS_VEHICLE_ID)) this.getInt(ARGUMENTS_VEHICLE_ID) else null