package com.example.mobileandroiddevelopertest.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileandroiddevelopertest.R
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val intent = intent

        if (intent.hasExtra("name")) {
            val data = intent.getStringExtra("name")
            recipeName.text = data
        }

        if (intent.hasExtra("description")) {
            val data = intent.getStringExtra("description")
            description.text = data
        }

        if (intent.hasExtra("calories")) {
            val data = intent.getStringExtra("calories")
            calories.text = data
        }

        if (intent.hasExtra("carbos")) {
            val data = intent.getStringExtra("carbos")
            carbos.text = data
        }

        if (intent.hasExtra("country")) {
            val data = intent.getStringExtra("country")
            country.text = data
        }

        if (intent.hasExtra("difficulty")) {
            val data = intent.getStringExtra("difficulty")
            difficulty.text = data
        }

        if (intent.hasExtra("fats")) {
            val data = intent.getStringExtra("fats")
            fats.text = data
        }

        if (intent.hasExtra("headline")) {
            val data = intent.getStringExtra("headline")
            headline.text = data
        }

        if (intent.hasExtra("id")) {
            val data = intent.getStringExtra("id")
            id.text = data
        }

        if (intent.hasExtra("proteins")) {
            val data = intent.getStringExtra("proteins")
            proteins.text = data
        }

        if (intent.hasExtra("time")) {
            val data = intent.getStringExtra("time")
            time.text = data
        }

        if (intent.hasExtra("ingredients")) {
            val data = intent.getStringExtra("ingredients")
            ingredients.text = data
        }

        if (intent.hasExtra("products")) {
            val data = intent.getStringExtra("products")
            products.text = data
        }

        if (intent.hasExtra("weeks")) {
            val data = intent.getStringExtra("weeks")
            weeks.text = data
        }

        if (intent.hasExtra("userEmail")) {
            val data = intent.getStringExtra("userEmail")
            email.text = data
        }

        if (intent.hasExtra("userName")) {
            val data = intent.getStringExtra("userName")
            userName.text = data
        }
    }
}
