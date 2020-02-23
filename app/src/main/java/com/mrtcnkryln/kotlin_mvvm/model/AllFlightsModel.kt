package com.mrtcnkryln.kotlin_mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class AllFlightsModel(
    @SerializedName("flights")
    @Expose
    val flights : ArrayList<FlightModel>? = null
)