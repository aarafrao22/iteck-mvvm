package com.aarafrao.itecksamplekotlin.network

import com.aarafrao.itecksamplekotlin.model.CustomerData
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiInterface {

    @FormUrlEncoded
    @POST("mobile/loadcustomerdata.php/")
    fun loadCustomerData(@Field("contact") contact: String?): Call<CustomerData>

}