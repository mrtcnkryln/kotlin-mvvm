package com.mrtcnkryln.kotlin_mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class FlightModel(
    @SerializedName("airline")
    @Expose
    val airline : String? = null,

    @SerializedName("departure_date")
    @Expose
    val departure_date : String? = null,

    @SerializedName("arrival_date")
    @Expose
    val arrival_date : String? = null,

    @SerializedName("price")
    @Expose
    val price : Int? = null,

    @SerializedName("departure_airport")
    @Expose
    val departure_airport : String? = null,

    @SerializedName("arrival_airport")
    @Expose
    val arrival_airport : String? = null
)