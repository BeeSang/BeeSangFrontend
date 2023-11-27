package com.example.beesang.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.example.beesang.composes.register.RegisterCompose
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.request.UserRegisterRequest
import com.example.beesang.retrofit.response.UserRegisterResponse
import com.example.beesang.ui.theme.BeeSangTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : ComponentActivity() {

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
                    var checkPassword by rememberSaveable { mutableStateOf("") }
                    var username by rememberSaveable { mutableStateOf("") }
                    var schoolName by rememberSaveable { mutableStateOf("") }
                    var studentId by rememberSaveable { mutableStateOf("") }

                    RegisterCompose(
                        userEmail, onIdChange = { userEmail = it },
                        password, onPasswordChange = { password = it },
                        checkPassword, onCheckPasswordChange = { checkPassword = it },
                        username, onNameChange = { username = it },
                        schoolName, onSchoolChange = { schoolName = it },
                        studentId, onStudentIdChange = { studentId = it },
                        onRegisterBtnTapped = { registerBtnClick(schoolName, studentId, userEmail, password, checkPassword, username) },
                        onBackBtn2Tapped = { backBtnClick() }
                    )

                }
            }
        }
    }

    private fun registerBtnClick(schoolName: String, studentId: String, userEmail: String,
                                 password: String, checkPassword: String, username: String) {
        //ID, PW 유효성 검사
        if(password != checkPassword) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        //POST REQUEST
        val data = UserRegisterRequest(schoolName, studentId, userEmail, password, username)
        val call = ApiObject.getRetrofitService.userRegisterRequest(data)
        call.enqueue(object: Callback<UserRegisterResponse> {
            override fun onResponse(call: Call<UserRegisterResponse>, response: Response<UserRegisterResponse>) {
                if(response.isSuccessful) {
                    Log.i("Response", response.body()?.res.toString())
                }
            }
            override fun onFailure(call: Call<UserRegisterResponse>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })

        Toast.makeText(this, "회원가입 성공!", Toast.LENGTH_SHORT).show()

        Intent(this, LoginActivity::class.java).also {
            startActivity(it)
        }
    }

    private fun backBtnClick() {
        finish()
    }
}