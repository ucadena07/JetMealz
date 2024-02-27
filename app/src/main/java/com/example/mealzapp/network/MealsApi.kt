package com.example.mealzapp.network

import com.example.mealzapp.model.Categories
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsWebService {
    private lateinit var api:MealsApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api  = retrofit.create(MealsApi::class.java)
    }
     fun getMeals(): Call<Categories>{
        return api.getMeals()
    }

    suspend fun getMealsAsync(): Categories{
        return api.getMealsAsync()
    }

    interface MealsApi{
        @GET("categories.php")
        fun getMeals(): Call<Categories>

        @GET("categories.php")
        suspend fun getMealsAsync(): Categories
    }
}