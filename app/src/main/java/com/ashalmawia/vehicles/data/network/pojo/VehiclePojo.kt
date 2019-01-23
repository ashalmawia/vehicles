package com.ashalmawia.vehicles.data.network.pojo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehiclePojo(
    val vehicleId: Int,
    val vrn: String,
    val country: String,
    val color: String,
    val type: String,
    val default: Boolean
)