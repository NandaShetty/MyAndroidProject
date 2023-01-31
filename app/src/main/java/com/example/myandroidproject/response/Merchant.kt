package com.example.myandroidproject.response

import com.google.gson.annotations.SerializedName


data class Merchant (

  @SerializedName("id"       ) var id       : Int?      = null,
  @SerializedName("name"     ) var name     : String?   = null,
  @SerializedName("employee" ) var employee : Employee? = Employee(),
  @SerializedName("branch"   ) var branch   : Branch?   = Branch()

)