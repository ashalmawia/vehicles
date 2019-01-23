package com.ashalmawia.vehicles.model

data class Vehicle(
    val id: Int,
    val name: String,
    val country: String,
    val color: String,
    val type: String,
    val isDefault: Boolean
)