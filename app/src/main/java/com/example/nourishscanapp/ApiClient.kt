package com.example.nourishscanapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.util.Log

class ApiClient(private val apiService: ApiService) {

    fun getProductInfo(barcode: String, apiKey: String, callback: (ProductResponse?, Throwable?) -> Unit) {
        apiService.getProductInfo(barcode, apiKey).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(call: Call<ProductResponse>, response: Response<ProductResponse>) {
                if (response.isSuccessful) {
                    callback(response.body(), null)
                    Log.d("ApiClient", "API call successful: ${response.body()}")
                } else {
                    callback(null, Throwable("Error: ${response.code()} ${response.message()}"))
                    Log.e("ApiClient", "API call failed: ${response.code()} ${response.message()}")
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                callback(null, t)
                Log.e("ApiClient", "API call failed: ${t.message}")
            }
        })
    }
}