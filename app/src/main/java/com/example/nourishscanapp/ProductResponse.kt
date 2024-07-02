package com.example.nourishscanapp

data class ProductResponse(
    val product: Product
)

data class Product(
    val name: String,
    val brand: String,
    val image_url: String,
    val ingredients: String,
    val allergens: String,
    val nutrition: Nutrition
)

data class Nutrition(
    val calories: String,
    val fat: String,
    val sugar: String,
    val protein: String
)