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

    }

    fun setRecipeListItem(recipeList: List<RecipeModel>) {
        this.recipeList = recipeList
        notifyDataSetChanged()
    }

    fun getRecipe(adapterPosition: Int) : RecipeModel {
        return recipeList[adapterPosition]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        override fun onClick(v: View?) {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra(DetailsActivity().RECIPE_POSITION_, adapterPosition)
            context.startActivity(intent)
        }

        val name: TextView = itemView.findViewById(R.id.recipe_name)
        val image: CircleImageView = itemView.findViewById(R.id.recipe_image)

    }
}