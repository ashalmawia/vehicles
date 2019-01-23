package com.ashalmawia.vehicles.data.network.pojo

import com.ashalmawia.vehicles.model.Vehicle
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehiclesListResponse(
    val count: Int,
    val vehicles: List<VehiclePojo>,
    val currentPage: Int,
    val nextPage: Int,
    val totalPages: Int
) {

    fun toVehiclesList(): List<Vehicle> {
        return vehicles.map { Vehicle(it.vehicleId, it.vrn, it.country, it.color, it.type, it.default) }
    }
}