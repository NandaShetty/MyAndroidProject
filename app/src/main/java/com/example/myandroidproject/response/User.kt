package com.example.myandroidproject.response

import com.google.gson.annotations.SerializedName


data class User (

  @SerializedName("id"              ) var id             : Int?                    = null,
  @SerializedName("name"            ) var name           : String?                 = null,
  @SerializedName("first_name"      ) var firstName      : String?                 = null,
  @SerializedName("last_name"       ) var lastName       : String?                 = null,
  @SerializedName("email"           ) var email          : String?                 = null,
  @SerializedName("username"        ) var username       : String?                 = null,
  @SerializedName("account_number"  ) var accountNumber  : String?                 = null,
  @SerializedName("photo"           ) var photo          : String?                 = null,
  @SerializedName("phone_number"    ) var phoneNumber    : String?                 = null,
  @SerializedName("gender"          ) var gender         : String?                 = null,
  @SerializedName("language"        ) var language       : String?                 = null,
  @SerializedName("date_birth"      ) var dateBirth      : String?                 = null,
  @SerializedName("date_add"        ) var dateAdd        : Int?                    = null,
  @SerializedName("date_edit"       ) var dateEdit       : Int?                    = null,
  @SerializedName("last_group_id"   ) var lastGroupId    : Int?                    = null,
  @SerializedName("last_branch_id"  ) var lastBranchId   : Int?                    = null,
  @SerializedName("has_facebook"    ) var hasFacebook    : Boolean?                = null,
  @SerializedName("has_pin"         ) var hasPin         : Boolean?                = null,
  @SerializedName("card_codes"      ) var cardCodes      : ArrayList<String>       = arrayListOf(),
  @SerializedName("payment_cards"   ) var paymentCards   : ArrayList<PaymentCards> = arrayListOf(),
  @SerializedName("status"          ) var status         : Int?                    = null,
  @SerializedName("onboarding_type" ) var onboardingType : String?                 = null,
  @SerializedName("save_card"       ) var saveCard       : Boolean?                = null

)