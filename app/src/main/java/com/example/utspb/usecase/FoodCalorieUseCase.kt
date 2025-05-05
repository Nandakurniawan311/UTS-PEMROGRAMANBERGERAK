package com.example.utspb.usecase

import com.example.utspb.data.FoodCalorieRepository
import com.example.utspb.model.FoodCalorie

class AddFoodCalorieUseCase(private val repository: FoodCalorieRepository) {
    operator fun invoke(foodCalorie: FoodCalorie) = repository.addFood(foodCalorie)
}

class GetFoodCaloriesUseCase(private val repository: FoodCalorieRepository) {
    operator fun invoke(): List<FoodCalorie> = repository.getFoods()
}
