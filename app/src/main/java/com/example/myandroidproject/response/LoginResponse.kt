package com.example.myandroidproject.response

import com.google.gson.annotations.SerializedName


data class LoginResponse (

  @SerializedName("user"     ) var user     : User?     = User(),
  @SerializedName("merchant" ) var merchant : Merchant? = Merchant(),
  @SerializedName("tokens"   ) var tokens   : Tokens?   = Tokens()

)