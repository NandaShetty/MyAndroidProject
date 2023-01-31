package com.example.myandroidproject.ui.login

import android.content.Context
import android.content.Intent
import android.provider.Settings
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myandroidproject.R
import com.example.myandroidproject.model.LoginBody
import com.example.myandroidproject.response.LoginResponse
import com.example.myandroidproject.ui.login.MainRepository.ILoginResponse


class MainViewModel() : ViewModel() {
    var mProgressMutableData = MutableLiveData<Int>()
    var mDrinksMutableData = MutableLiveData<String>()
    var mLoginResultMutableData = MutableLiveData<String>()
    var mMainRepository: MainRepository

    private val _loginResult = MutableLiveData<LoginResponse>()
    val loginResult = _loginResult

    init {
        mProgressMutableData.postValue(View.INVISIBLE)
        mDrinksMutableData.postValue("")
        mLoginResultMutableData.postValue("")
        mMainRepository = MainRepository()
    }

    fun loginDataChanged(username: String, password: String,context: Context) {

        if (!isUserNameValid(username)) {
            Toast.makeText(context,R.string.invalid_username,Toast.LENGTH_LONG).show()
        } else if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(context,"Fields must not be blank",Toast.LENGTH_LONG).show()
        }
        else if (!isPasswordValid(password)) {
            Toast.makeText(context,R.string.invalid_password,Toast.LENGTH_LONG).show()
        }else{
            login(username, password,context)
        }
    }
    fun login(email: String?, password: String?, context: Context) {
        mProgressMutableData.postValue(View.VISIBLE)
        mLoginResultMutableData.postValue("Checking")



        mMainRepository.loginRemote(LoginBody(email!!, password!!), object : ILoginResponse {
            override fun onResponse(loginResponse: LoginResponse?) {
                mProgressMutableData.postValue(View.INVISIBLE)
                mLoginResultMutableData.postValue("Login Success")

                openActivityB(context)


            }

            override fun onFailure(t: Throwable?) {
                mProgressMutableData.postValue(View.INVISIBLE)
                mLoginResultMutableData.postValue("Invalid User" + t!!.localizedMessage)
            }
        })
    }


    fun openActivityB(context: Context) {

        val intent = Intent(Intent(context,HomeActivity::class.java))
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.applicationContext.startActivity(intent)
    }

    fun getLoginResult(): LiveData<String?>? {
        return mLoginResultMutableData
    }

    fun getProgress(): LiveData<Int?>? {
        return mProgressMutableData
    }
    // A placeholder username validation check
   /* private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }*/

    private fun isUserNameValid(username: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(username).matches()
    }


    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {

        if (password.length < 8) return false
        if (password.filter { it.isDigit() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isUpperCase() }.firstOrNull() == null) return false
        if (password.filter { it.isLetter() }.filter { it.isLowerCase() }.firstOrNull() == null) return false
        if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

        return true

    }


}