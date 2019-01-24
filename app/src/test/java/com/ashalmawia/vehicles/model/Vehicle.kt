package com.ashalmawia.vehicles.model

/**
 * Even in test ids must be unique.
 */
private var idCounter = 0

fun vehicle(id: Int = ++idCounter, name: String = "name") = Vehicle(id, name, "GB", "Black", "Van", false)