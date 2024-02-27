package com.example.mealzapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mealzapp.screens.MealCategories.MealsCategoryScreen
import com.example.mealzapp.screens.mealCategories.MealCategoriesViewModel

@Composable
fun ApplicationNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ApplicationScreens.MealCategoriesScreen.name){
        composable(ApplicationScreens.MealCategoriesScreen.name){
            val vm: MealCategoriesViewModel = viewModel()
            MealsCategoryScreen(vm)
        }
    }

}