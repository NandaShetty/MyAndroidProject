package com.example.myandroidproject.response

import com.google.gson.annotations.SerializedName


data class PaymentCards (

  @SerializedName("token"       ) var token      : String?  = null,
  @SerializedName("card_type"   ) var cardType   : String?  = null,
  @SerializedName("expiry_date" ) var expiryDate : String?  = null,
  @SerializedName("save_card"   ) var saveCard   : Boolean? = null

)