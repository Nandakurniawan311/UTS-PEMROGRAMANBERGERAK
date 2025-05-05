package com.example.utspb.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.utspb.data.FoodCalorieRepositoryImpl
import com.example.utspb.model.FoodCalorie
import com.example.utspb.usecase.AddFoodCalorieUseCase
import com.example.utspb.usecase.GetFoodCaloriesUseCase

class CalculatorViewModel(
    private val addFoodCalorieUseCase: AddFoodCalorieUseCase,
    private val getFoodCaloriesUseCase: GetFoodCaloriesUseCase
) : ViewModel() {
    private val _foodList = mutableStateListOf<FoodCalorie>()
    val foodList: List<FoodCalorie> get() = _foodList

    val totalCalories: Int
        get() = _foodList.sumOf { it.calorie }

    init {
        loadFoods()
    }

    fun addFood(food: String, calorie: Int) {
        if (food.isNotBlank() && calorie > 0) {
            addFoodCalorieUseCase(FoodCalorie(food, calorie))
            loadFoods()
        }
    }

    private fun loadFoods() {
        _foodList.clear()
        _foodList.addAll(getFoodCaloriesUseCase())
    }
}

class CalculatorViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = FoodCalorieRepositoryImpl()
        val addUseCase = AddFoodCalorieUseCase(repository)
        val getUseCase = GetFoodCaloriesUseCase(repository)
        return CalculatorViewModel(addUseCase, getUseCase) as T
    }
}
