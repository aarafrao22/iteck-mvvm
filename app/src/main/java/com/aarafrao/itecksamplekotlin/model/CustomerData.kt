package com.aarafrao.itecksamplekotlin.model

import com.google.gson.annotations.SerializedName

data class CustomerData(
    @SerializedName("Name")
    val Name: String,
    @SerializedName("Vehicle")
    val Vehicle: List<Vehicle>,
    @SerializedName("Success")
    val Success: Boolean
)

