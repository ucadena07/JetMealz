package com.example.mealzapp.navigation

import java.lang.IllegalArgumentException

enum class ApplicationScreens {
    MealCategoriesScreen;

    companion object {
        fun fromRoute(route: String) : ApplicationScreens
            = when(route.substringBefore("/")){
                MealCategoriesScreen.name -> MealCategoriesScreen
                else -> throw  IllegalArgumentException("Route $route not found")
            }
    }
}