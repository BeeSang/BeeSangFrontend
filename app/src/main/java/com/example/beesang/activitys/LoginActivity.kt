package com.example.beesang.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.login.LoginCompose
import com.example.beesang.login.notoSansKR
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.request.UserLoginRequest
import com.example.beesang.retrofit.response.UserLoginResponse
import com.example.beesang.ui.theme.BeeSangTheme
import com.google.relay.compose.RelayText
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

    private fun findPasswordBtnClick() {
        //go to findPwd activity
    }

    private fun enterBtnClick(userEmail: String, password: String) {
        val data = UserLoginRequest(userEmail, password)
        val call = ApiObject.getRetrofitService.userLoginRequest(data)

        call.enqueue(object: Callback<UserLoginResponse> {
            override fun onResponse(call: Call<UserLoginResponse>, response: Response<UserLoginResponse>) {
                if(response.isSuccessful) {
                    var accessToken = response.body()?.accessToken.toString()

                    //accessToken을 local storage에 저장
                }
            }
            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                //예외처리 안먹음

                Log.e("Error", t.toString())
                Log.e("Error" , "Error")
                return
            }
        })

        Intent(this, HomeActivity::class.java).also {
            startActivity(it)
        }
    }
    private fun registerBtnClick() {
        Intent(this, RegisterActivity::class.java).also {
            startActivity(it)
        }
    }
}