package com.example.utspb.model

data class Habit(
    val name: String,
    val dailyCheck: MutableMap<String, Boolean> = mutableMapOf() // key: tanggal yyyy-MM-dd, value: sudah/ceklist
)
data class Note(val content: String)
data class FoodCalorie(val food: String, val calorie: Int)

