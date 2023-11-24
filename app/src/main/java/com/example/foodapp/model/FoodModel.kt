package com.example.foodapp.model

import java.io.Serializable
import java.util.UUID

data class FoodModel(
    val foodId: String = UUID.randomUUID().toString(),
    val name: String,
    val name2: String,
    val img: String
) : Serializable