package com.example.mealzapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.screens.MealCategories.MealsCategoryScreen
import com.example.mealzapp.screens.MealCategoriesViewModel
import com.example.mealzapp.screens.mealDetails.MealDetailScreen
import com.example.mealzapp.screens.mealDetails.MealDetailsViewModel


@Composable
fun ApplicationNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ApplicationScreens.MealCategoriesScreen.name){
        composable(ApplicationScreens.MealCategoriesScreen.name){
            val vm: MealCategoriesViewModel = viewModel()
            MealsCategoryScreen(vm,navController)
        }
        composable("${ApplicationScreens.MealDetailsScreen.name}/{id}", arguments = listOf(
            navArgument("id"){
                type = NavType.StringType
            }
        )){backStackEntry ->
            backStackEntry.arguments?.getString("id").let {
                val vm : MealDetailsViewModel= viewModel()
                vm.loadMeal(it)
                MealDetailScreen(navController, vm.mealState.value)
            }

        }
    }

}