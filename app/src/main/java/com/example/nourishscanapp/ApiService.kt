package com.example.nourishscanapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("products")
    fun getProductInfo(
        @Query("upc") barcode: String,
        @Query("key") apiKey: String = "" // Replace with your BarcodeLookup API Key
    ): Call<ProductResponse>
}