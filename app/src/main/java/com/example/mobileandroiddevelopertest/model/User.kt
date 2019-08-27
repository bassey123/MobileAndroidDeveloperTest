package com.example.mobileandroiddevelopertest.model


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("email")
    val email: String,
    @SerializedName("latlng")
    val latlng: String,
    @SerializedName("name")
    val name: String
)