package com.example.beesang.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.beesang.composes.login.LoginCompose
import com.example.beesang.retrofit.ApiObject
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
                    LoginCompose(
                        onEnterBtnTapped = { enterBtnClick() },
                        onRegisterBtnTapped = { registerBtnClick() }
                    )
                }
            }
        }
    }

    private fun enterBtnClick() {
        val data = UserLoginRequest("testId", "testPw")
        val call = ApiObject.getRetrofitService.userLoginRequest(data)

        call.enqueue(object: Callback<UserLoginResponse> {
            override fun onResponse(call: Call<UserLoginResponse>, response: Response<UserLoginResponse>) {
                if(response.isSuccessful) {
                    Log.i("Response", response.body()?.res.toString())
                    //return 값으로 세션 값 가져와서 local storage에 저장
                }
            }
            override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
                Log.e("Error", t.toString())
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



@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    BeeSangTheme {
        LoginCompose()
    }
}