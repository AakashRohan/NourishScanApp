package com.example.nourishscanapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/food-database/v2/parser")
    fun getProductInfo(
        @Query("upc") barcode: String,
        @Query("app_id") appId: String = "6d50b420", // Replace with your Edamam App ID
        @Query("app_key") appKey: String = "73cedea7dda11af1eeeb1009767bd85f" // Replace with your Edamam App Key
    ): Call<ProductResponse>
}