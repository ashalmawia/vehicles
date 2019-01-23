package com.ashalmawia.vehicles.data

import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable

class InMemoryCache(private val inner: Repository) : Repository {

    private val cache = mutableMapOf<Int, Vehicle>()

    override fun getVehicles(): Observable<List<Vehicle>> {
        if (cache.isEmpty()) {
            return inner.getVehicles().doOnNext { vehicles ->
                cache.putAll(vehicles.associateBy { it.id })
            }
        } else {
            return Observable.just(cache.values.toList())
        }
    }

    override fun vehicleById(id: Int): Vehicle? = cache[id]
}