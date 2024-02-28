package com.example.mealzapp.navigation

import java.lang.IllegalArgumentException

enum class ApplicationScreens {
    MealCategoriesScreen,
    MealDetailsScreen;

    companion object {
        fun fromRoute(route: String) : ApplicationScreens
            = when(route.substringBefore("/")){
                MealCategoriesScreen.name -> MealCategoriesScreen
                MealDetailsScreen.name -> MealDetailsScreen
                else -> throw  IllegalArgumentException("Route $route not found")
            }
    }
}