package com.example.beesang.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.beesang.composes.login.LoginCompose
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.TokenStorage
import com.example.beesang.retrofit.request.UserLoginRequest
import com.example.beesang.retrofit.response.UserLoginResponse
import com.example.beesang.ui.theme.BeeSangTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeeSangTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var userEmail by rememberSaveable { mutableStateOf("") }
                    var password by rememberSaveable { mutableStateOf("") }

                    //rememberMe 버튼 클릭 기능 추가 필요 -> 자동 로그인
                    LoginCompose(
                        userEmail, onUserEmailChange = { userEmail = it },
                        password, onPasswordChange = { password = it },
                        onFindPasswordBtnTapped = { findPasswordBtnClick() },
                        onEnterBtnTapped = { enterBtnClick(userEmail, password) },
                        onRegisterBtnTapped = { registerBtnClick() }
                    )
                }
            }
        }
    }

    private fun enterBtnClick(userEmail: String, password: String) {
        val data = UserLoginRequest(userEmail, password)
        val call = ApiObject.getRetrofitService.userLoginRequest(data)

        call.enqueue(object: Callback<UserLoginResponse> {
            override fun onResponse(call: Call<UserLoginResponse>, response: Response<UserLoginResponse>) {
                if(response.isSuccessful) {
                    val accessToken = response.body()?.accessToken.toString()
                    TokenStorage.setToken(applicationContext, accessToken)

                    Toast.makeText(applicationContext, "로그인 성공!", Toast.LENGTH_SHORT).show()
                    Intent(applicationContext, HomeActivity::class.java).also {
                        startActivity(it)
                    }
                } else {
                    when(response.code()) {
                        403 -> {
                            Toast.makeText(applicationContext, "아이디 또는 비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {}
        })
    }
    private fun registerBtnClick() {
        Intent(this, RegisterActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun findPasswordBtnClick() {
        //go to findPwd activity
    }
}