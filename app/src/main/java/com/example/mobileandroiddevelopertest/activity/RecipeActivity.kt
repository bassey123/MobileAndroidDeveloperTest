package com.example.mobileandroiddevelopertest.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.mobileandroiddevelopertest.*
import com.example.mobileandroiddevelopertest.adapter.RecipeAdapter
import com.example.mobileandroiddevelopertest.api.RecipeAPI
import com.example.mobileandroiddevelopertest.model.RecipeModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecipeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerAdapter = RecipeAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = recyclerAdapter

        val apiInterface = RecipeAPI.create().getRecipes()

        apiInterface.enqueue(object : Callback<List<RecipeModel>> {
            override fun onFailure(call: Call<List<RecipeModel>>, t: Throwable) {
                Log.e("RecipeActivity", "Error calling API", t)
            }

            override fun onResponse(
                call: Call<List<RecipeModel>>,
                response: Response<List<RecipeModel>>
            ) {
                if (response.body() != null) {
                    recyclerAdapter.setRecipeListItem(response.body()!!)
                }
            }

        })
    }
}


