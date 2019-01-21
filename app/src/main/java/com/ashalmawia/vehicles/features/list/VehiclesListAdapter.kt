package com.ashalmawia.vehicles.features.list

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ashalmawia.vehicles.model.Vehicle

class VehiclesListAdapter(
    private val context: Context,
    private val data: List<Vehicle>
) : RecyclerView.Adapter<VehicleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return VehicleViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}

class VehicleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val text = view as TextView

    fun bind(vehicle: Vehicle) {
        text.text = vehicle.name
    }
}