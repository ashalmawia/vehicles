package com.ashalmawia.vehicles.features.details

import android.support.v7.app.ActionBar
import android.view.View
import android.widget.Toast
import com.ashalmawia.vehicles.R
import com.ashalmawia.vehicles.model.Vehicle
import kotlinx.android.synthetic.main.fragment_vehicle_details.view.*

interface VehicleDetailsView {

    fun showDetails(vehicle: Vehicle)

    fun showError()
}

class VehicleDetailsViewImpl(private val root: View, private val appBar: ActionBar) : VehicleDetailsView {

    override fun showDetails(vehicle: Vehicle) {
        appBar.title = vehicle.name

        root.labelId.text = vehicle.id.toString()
        root.labelCountry.text = vehicle.country
        root.labelColor.text = vehicle.color
        root.labelType.text = vehicle.type
        root.labelIsDefault.setText(vehicle.isDefault.toYesNoResource())
    }

    override fun showError() {
        Toast.makeText(root.context, R.string.vehicle_details__error, Toast.LENGTH_SHORT).show()
    }
}

private fun Boolean.toYesNoResource() = if (this) R.string.yes else R.string.no