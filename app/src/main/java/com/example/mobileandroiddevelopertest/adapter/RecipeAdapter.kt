package com.example.mobileandroiddevelopertest.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mobileandroiddevelopertest.R
import com.example.mobileandroiddevelopertest.activity.DetailsActivity
import com.example.mobileandroiddevelopertest.model.RecipeModel
import de.hdodenhof.circleimageview.CircleImageView

class RecipeAdapter(
    private val context: Context
) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private var recipeList: List<RecipeModel> = listOf()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val view = layoutInflater.inflate(R.layout.recipe_list_item, p0, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.name.text = recipeList[p1].name
        Glide.with(context).load(recipeList[p1].image)
            .error(R.drawable.ic_launcher_background)
            .apply(RequestOptions().centerCrop())
            .into(p0.image)

        p0.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("name", recipeList[p1].name)
            intent.putExtra("calories", recipeList[p1].calories)
            intent.putExtra("carbos", recipeList[p1].carbos)
            intent.putExtra("country", recipeList[p1].country)
            intent.putExtra("description", recipeList[p1].description)
            intent.putExtra("difficulty", recipeList[p1].difficulty)
            intent.putExtra("fats", recipeList[p1].fats)
            intent.putExtra("headline", recipeList[p1].headline)
            intent.putExtra("id", recipeList[p1].id)
            intent.putExtra("proteins", recipeList[p1].proteins)
            intent.putExtra("time", recipeList[p1].time)
            intent.putExtra("ingredients0", recipeList[p1].ingredients[0])
            intent.putExtra("ingredients1", recipeList[p1].ingredients[1])
            intent.putExtra("ingredients2", recipeList[p1].ingredients[2])
            intent.putExtra("ingredients3", recipeList[p1].ingredients[3])
            intent.putExtra("ingredients4", recipeList[p1].ingredients[4])
            intent.putExtra("ingredients5", recipeList[p1].ingredients[5])
            intent.putExtra("ingredients6", recipeList[p1].ingredients[6])
            intent.putExtra("ingredients7", recipeList[p1].ingredients[7])
            intent.putExtra("ingredients8", recipeList[p1].ingredients[8])
            intent.putExtra("ingredients9", recipeList[p1].ingredients[9])
            intent.putExtra("ingredients10", recipeList[p1].ingredients[10])
            intent.putExtra("products", recipeList[p1].products[0])
            intent.putExtra("weeks", recipeList[p1].weeks[0])
            intent.putExtra("userEmail", recipeList[p1].user.email)
            intent.putExtra("userName", recipeList[p1].user.name)
            context.startActivity(intent)
        }
    }

    fun setRecipeListItem(recipeList: List<RecipeModel>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.recipe_name)
        val image: CircleImageView = itemView.findViewById(R.id.recipe_image)

    }
}