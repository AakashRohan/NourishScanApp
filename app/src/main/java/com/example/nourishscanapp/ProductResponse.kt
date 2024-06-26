package com.example.nourishscanapp

data class ProductResponse(
    val text: String,
    val parsed: List<Parsed>
)

data class Parsed(
    val food: Food
)

data class Food(
    val label: String,
    val nutrients: Nutrients
)

data class Nutrients(
    val ENERC_KCAL: Float,
    val PROCNT: Float,
    val FAT: Float,
    val CHOCDF: Float,
    val FIBTG: Float
)