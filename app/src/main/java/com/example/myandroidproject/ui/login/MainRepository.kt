package com.example.myandroidproject.ui.login

import android.content.Intent
import com.example.myandroidproject.RetrofitClientInstance.instance
import com.example.myandroidproject.api.LoginApi
import com.example.myandroidproject.model.LoginBody
import com.example.myandroidproject.response.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainRepository {

    fun loginRemote(loginBody: LoginBody?, loginResponse: ILoginResponse) {
        val loginService: LoginApi = instance!!.create(LoginApi::class.java)
        val initiateLogin = loginService.login(loginBody)



        initiateLogin?.enqueue(object : Callback<LoginResponse?> {
            override fun onResponse(
                call: Call<LoginResponse?>,
                response: Response<LoginResponse?>
            ) {
                if (response.isSuccessful) {
                    loginResponse.onResponse(response.body())


                } else {
                    loginResponse.onFailure(Throwable(response.message()))
                }
            }

            override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                loginResponse.onFailure(t)
            }
        })
    }

    interface ILoginResponse {
        fun onResponse(loginResponse: LoginResponse?)
        fun onFailure(t: Throwable?)
    }


}