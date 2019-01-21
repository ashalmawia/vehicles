package com.ashalmawia.vehicles.data.network.pojo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class VehiclePojo(val vrn: String)