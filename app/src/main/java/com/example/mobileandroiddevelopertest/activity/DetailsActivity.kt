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

        if (intent.hasExtra(Intent.EXTRA_TEXT)) {
            val name = intent.getStringExtra(Intent.EXTRA_TEXT)
            recipeName.text = name
        }
    }
}
