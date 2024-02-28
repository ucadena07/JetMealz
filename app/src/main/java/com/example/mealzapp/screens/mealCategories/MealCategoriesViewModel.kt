package com.example.mealzapp.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.Categories
import com.example.mealzapp.model.Category
import com.example.mealzapp.repository.MealsRepository
import kotlinx.coroutines.launch

class MealCategoriesViewModel() : ViewModel() {

    val meals: MutableState<List<Category>> = mutableStateOf(emptyList<Category>())
    private  val repo: MealsRepository = MealsRepository.getInstance()
    init {
        viewModelScope.launch {
            meals.value = getMealsAsync()

        }
    }

    fun getMeals(successCallback: (response: Categories?) -> Unit){
        repo.getMeals(){
            successCallback(it)
        }
    }
    suspend  fun getMealsAsync() : List<Category>{
      return  repo.getMealsAsync().categories
    }
}