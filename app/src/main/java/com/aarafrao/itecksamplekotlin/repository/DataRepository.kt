package com.aarafrao.itecksamplekotlin.repository

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.aarafrao.itecksamplekotlin.model.CustomerData
import com.aarafrao.itecksamplekotlin.network.ApiInterface
import retrofit2.Call
import retrofit2.Response


class DataRepository(private val apiInterface: ApiInterface) {
    private val customerLiveData = MutableLiveData<CustomerData>()

    val data: LiveData<CustomerData>
        get() = customerLiveData

    suspend fun loadCustomerData(contact: String) {

        apiInterface.loadCustomerData(contact).enqueue(object : retrofit2.Callback<CustomerData> {
            override fun onResponse(call: Call<CustomerData>, response: Response<CustomerData>) {
                customerLiveData.postValue(response.body())
            }

            override fun onFailure(call: Call<CustomerData>, t: Throwable) {
                Log.d(TAG, "onFailure: ")
            }

        })


    }

}
