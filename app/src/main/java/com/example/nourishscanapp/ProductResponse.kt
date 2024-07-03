package com.example.nourishscanapp

data class ProductResponse(
    val products: List<Product>
)

data class Product(
    val product_name: String,
    val ingredients_text: String,
    val nutriments: Nutriments
)

data class Nutriments(
    val energy_kcal: Float,
    val proteins: Float,
    val fat: Float,
    val carbohydrates: Float,
    val fiber: Float
)