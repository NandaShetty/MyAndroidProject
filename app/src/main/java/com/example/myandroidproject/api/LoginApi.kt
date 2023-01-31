package com.example.myandroidproject.api

import com.example.myandroidproject.model.LoginBody
import com.example.myandroidproject.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface LoginApi {

        @POST("auth/login/email")
        fun login(@Body loginBody: LoginBody?): Call<LoginResponse?>?

}