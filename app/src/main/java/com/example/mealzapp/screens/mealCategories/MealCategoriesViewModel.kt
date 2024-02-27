package com.example.mealzapp.screens.mealCategories

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.Categories
import com.example.mealzapp.model.Category
import com.example.mealzapp.repository.MealsRepository
import kotlinx.coroutines.launch

class MealCategoriesViewModel(private  val repo: MealsRepository = MealsRepository()) : ViewModel() {

    val meals: MutableState<List<Category>> = mutableStateOf(emptyList<Category>())

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