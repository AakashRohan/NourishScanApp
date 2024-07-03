package com.example.nourishscanapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    fun getProductInfo(
        @Query("barcode") barcode: String,
        @Query("formatted") formatted: String = "y",
        @Query("key") apiKey: String = "jhs94q3no2wznxaxttoaqzfnatlie9" // Replace with your Barcode Lookup API key
    ): Call<ProductResponse>
}