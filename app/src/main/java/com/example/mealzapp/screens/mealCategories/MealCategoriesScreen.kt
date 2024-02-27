package com.example.mealzapp.screens.MealCategories

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import com.example.mealzapp.model.Category
import com.example.mealzapp.screens.mealCategories.MealCategoriesViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun MealsCategoryScreen(vm: MealCategoriesViewModel) {

    LazyColumn{
        items(vm.meals.value){
            Text(text = it.strCategory)
        }
    }
}