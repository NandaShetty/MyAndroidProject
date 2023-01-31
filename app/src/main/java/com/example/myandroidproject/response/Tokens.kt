package com.example.myandroidproject.response

import com.google.gson.annotations.SerializedName


data class Tokens (

  @SerializedName("access_token"  ) var accessToken  : String? = null,
  @SerializedName("refresh_token" ) var refreshToken : String? = null

)