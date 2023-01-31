package com.example.myandroidproject.model

import com.google.gson.annotations.SerializedName

class LoginBody(
    @field:SerializedName("email")
    var email: String,

    @field:SerializedName("password")
    var password: String
)