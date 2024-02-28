package com.example.mealzapp.repository

import com.example.mealzapp.model.Categories
import com.example.mealzapp.model.Category
import com.example.mealzapp.network.MealsWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(private val webService : MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<Category>()
    fun getMeals(successCallback: (response: Categories?) -> Unit) {
        return webService.getMeals().enqueue(object: Callback<Categories>{
            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
               if(response.isSuccessful){
                   successCallback(response.body())
               }
            }

            override fun onFailure(call: Call<Categories>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    suspend fun getMealsAsync(): Categories {
       val data = webService.getMealsAsync()
        cachedMeals = data.categories
        return data
    }

    fun getMeal(id: String?) : Category?{
        return cachedMeals.firstOrNull() { it -> it.idCategory == id }
    }

    companion object{
        @Volatile
        private var instance : MealsRepository? = null
        fun getInstance() = instance?: synchronized(this){
            instance ?: MealsRepository().also { instance = it }
        }
    }

}