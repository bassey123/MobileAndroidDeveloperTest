package com.example.mobileandroiddevelopertest.api

import com.example.mobileandroiddevelopertest.model.RecipeModel
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RecipeAPI {
    @GET("Recipe.json")
    fun getRecipes() : Call<List<RecipeModel>>

    companion object {
        private var BASE_URL = "https://raw.githubusercontent.com/Nsikaktopdown/Recipe/master/"

        fun create() : RecipeAPI {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(RecipeAPI::class.java)
        }
    }
}