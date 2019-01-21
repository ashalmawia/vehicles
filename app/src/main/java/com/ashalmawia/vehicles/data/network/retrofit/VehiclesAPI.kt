package com.ashalmawia.vehicles.data.network.retrofit

import com.ashalmawia.vehicles.data.network.pojo.VehiclesListResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface VehiclesAPI {

    @GET("/vehicles")
    fun getVehicles(): Observable<VehiclesListResponse>
}