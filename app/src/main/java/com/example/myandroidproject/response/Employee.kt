package com.example.myandroidproject.response

import com.google.gson.annotations.SerializedName


data class Employee (

  @SerializedName("id")
  var id  : Int?    = null,

  @SerializedName("permissions" )
  var permissions : String? = null

)