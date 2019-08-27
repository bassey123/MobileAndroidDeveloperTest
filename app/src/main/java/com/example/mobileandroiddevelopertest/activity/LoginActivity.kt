package com.example.mobileandroiddevelopertest.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import com.example.mobileandroiddevelopertest.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn.setOnClickListener {
            val mail = email.text.toString()
            val pwd = password.text.toString()
            if (TextUtils.isEmpty(mail) || !Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                email.error = "Enter a valid Email"
            }

            if (TextUtils.isEmpty(pwd) || pwd.length < 6) {
                password.error = "Enter a strong Password"
            }

            if (!TextUtils.isEmpty(mail) && !TextUtils.isEmpty(mail) && Patterns.EMAIL_ADDRESS.matcher(mail).matches() && pwd.length >= 6) {
                startActivity(Intent(this, RecipeActivity::class.java))
            }
        }
    }
}
