package com.example.myandroidproject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myandroidproject.databinding.ActivityMainBinding
import com.example.myandroidproject.ui.login.MainViewModel



class MainActivity : AppCompatActivity() {

    private lateinit var loginViewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val email = binding.email
        val password = binding.password
        val login = binding.login
        val result=binding.tvLoginResult
        val loading = binding.loading


        val context=this.applicationContext


        loginViewModel = ViewModelProvider(this)[MainViewModel::class.java]

        loginViewModel.getProgress()?.observe(this, Observer<Int?> { visibility -> loading.setVisibility(visibility) })

        loginViewModel.getLoginResult()?.observe(this, Observer<String?> { s -> result.setText(s) })

        password.apply {
            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->
                        loginViewModel.loginDataChanged(email.text.toString(), password.text.toString(), context)

                }
                false
            }
        }

        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("ABC", ": onBtn1Pressed-LOGIN ")
                loginViewModel.loginDataChanged(
                    email.text.toString(),
                    password.text.toString(),
                    context
                )
               // loginViewModel.login(email.getText().toString(), password.getText().toString(),context)



            }
        })

    }
}