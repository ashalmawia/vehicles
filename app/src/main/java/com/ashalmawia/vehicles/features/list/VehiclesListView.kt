package com.ashalmawia.vehicles.features.list

import android.support.annotation.StringRes
import android.support.v7.app.ActionBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.Toast
import com.ashalmawia.vehicles.R
import com.ashalmawia.vehicles.model.Vehicle

interface VehiclesListView {

    fun showVehicles(vehicles: List<Vehicle>)

    fun showError()
}

class VehiclesListViewImpl(root: ViewGroup, actionBar: ActionBar) : VehiclesListView {

    lateinit var presenter: VehiclesListPresenter

    private val list = root as RecyclerView

    private val context = root.context

    init {
        actionBar.setTitle(R.string.app_name)
    }

    override fun showVehicles(vehicles: List<Vehicle>) {
        list.layoutManager = LinearLayoutManager(context)

        val adapter = VehiclesListAdapter(context, vehicles, presenter::openVehicleDetails)
        list.adapter = adapter
    }

    override fun showError() {
        showToast(R.string.get_list_error)
    }

    private fun showToast(@StringRes message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}