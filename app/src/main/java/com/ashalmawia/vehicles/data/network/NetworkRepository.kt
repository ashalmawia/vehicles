package com.ashalmawia.vehicles.data.network

import com.ashalmawia.vehicles.data.Repository
import com.ashalmawia.vehicles.data.network.retrofit.VehiclesAPI
import com.ashalmawia.vehicles.model.Vehicle
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.lang.IllegalStateException

private const val BASE_URL = "http://private-6d86b9-vehicles5.apiary-mock.com"

class NetworkRepository : Repository {

    private val vehiclesApi: VehiclesAPI

    init {
        val client = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        vehiclesApi = client.create(VehiclesAPI::class.java)
    }

    override fun getVehicles(): Observable<List<Vehicle>> {
        return vehiclesApi.getVehicles()
            .map {
                it.toVehiclesList()
            }
    }

    override fun vehicleById(id: Int): Vehicle? {
        throw IllegalStateException("not yet supported")
    }
}