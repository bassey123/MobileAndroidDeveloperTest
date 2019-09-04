package com.example.mobileandroiddevelopertest.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mobileandroiddevelopertest.R
import com.example.mobileandroiddevelopertest.model.RecipeModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    private val RECIPEPOSITION = "recipePosition"
    private var position: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent

        if (intent != null) {
            position = intent.getIntExtra(RECIPEPOSITION, 0)
            val recipeModel: RecipeModel = RecipeActivity().getRecipe(position!!)

            Glide.with(this).load(recipeModel.image)
                .error(R.drawable.ic_launcher_background)
                .apply(RequestOptions().centerCrop())
                .into(recipeImage)

            recipeName.text = recipeModel.name
            description.text = recipeModel.description
            ingredients.text = recipeModel.ingredients.toString()
            calories.text = recipeModel.calories
            carbos.text = recipeModel.carbos
            country.text = recipeModel.country
            difficulty.text = recipeModel.difficulty.toString()
            headline.text = recipeModel.headline
            id.text = recipeModel.id
            products.text = recipeModel.products.toString()
            proteins.text = recipeModel.proteins
            fats.text = recipeModel.fats
            time.text = recipeModel.time
            email.text = recipeModel.user.email
            userName.text = recipeModel.user.name
            weeks.text = recipeModel.weeks.toString()

        }

    }
}
