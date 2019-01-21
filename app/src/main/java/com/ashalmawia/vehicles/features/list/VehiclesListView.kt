package com.ashalmawia.vehicles.features.list

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.ashalmawia.vehicles.model.Vehicle

interface VehiclesListView {

    fun showVehicles(vehicles: List<Vehicle>)
}

class VehiclesListViewImpl(root: ViewGroup) : VehiclesListView {

    private val list = root as RecyclerView

    private val context = root.context

    override fun showVehicles(vehicles: List<Vehicle>) {
        list.layoutManager = LinearLayoutManager(context)

        val adapter = VehiclesListAdapter(context, vehicles)
        list.adapter = adapter
    }
}