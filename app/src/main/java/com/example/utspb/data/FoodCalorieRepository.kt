package com.example.utspb.data

import com.example.utspb.model.FoodCalorie

interface FoodCalorieRepository {
    fun addFood(foodCalorie: FoodCalorie)
    fun getFoods(): List<FoodCalorie>
}

class FoodCalorieRepositoryImpl : FoodCalorieRepository {
    private val foods = mutableListOf<FoodCalorie>()
    override fun addFood(foodCalorie: FoodCalorie) {
        foods.add(foodCalorie)
    }
    override fun getFoods(): List<FoodCalorie> = foods
}
