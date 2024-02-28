package com.example.mealzapp.screens.mealDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mealzapp.model.Category
import com.example.mealzapp.repository.MealsRepository

class MealDetailsViewModel() : ViewModel() {
    var mealState = mutableStateOf<Category?>(null)
    private  val repo: MealsRepository = MealsRepository.getInstance()
    init{
        //val mealId = savedStateHandle.get<String>("id") ?: ""
        ///mealState.value  = repo.getMeal(id)
    }

    fun loadMeal(id: String?){
        mealState.value  = repo.getMeal(id)
    }
}