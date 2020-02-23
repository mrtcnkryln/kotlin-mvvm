package com.mrtcnkryln.kotlin_mvvm.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HotelModel(
    @SerializedName("name")
    @Expose
    val name : String? = null,

    @SerializedName("hotel_location")
    @Expose
    val hotel_location : String? = null,

    @SerializedName("description")
    @Expose
    val description : String? = null,

    @SerializedName("images")
    @Expose
    val images : ArrayList<String>? = null,

    @SerializedName("rating")
    @Expose
    val rating : Int? = null,

    @SerializedName("facilities")
    @Expose
    val facilities : ArrayList<String>? = null
) : Serializable