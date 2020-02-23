package com.mrtcnkryln.kotlin_mvvm.network

import com.mrtcnkryln.kotlin_mvvm.model.AllFlightsModel
import com.mrtcnkryln.kotlin_mvvm.model.HotelModel
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiInterface {
    @GET("f0Tm6bfy")
    fun hotel() : Observable<HotelModel>

    @GET("bFnZQEx0")
    fun flights() : Observable<AllFlightsModel>
}