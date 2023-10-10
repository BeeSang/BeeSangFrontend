package com.example.beesang.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.beesang.composes.login.LoginCompose
import com.example.beesang.composes.register.AutoLayout
import com.example.beesang.composes.register.AutoLayoutSynth
import com.example.beesang.composes.register.BackBtn2
import com.example.beesang.composes.register.BackgroundImg
import com.example.beesang.composes.register.CheckPassword
import com.example.beesang.composes.register.Id
import com.example.beesang.composes.register.InputAutoLayout
import com.example.beesang.composes.register.InputBox
import com.example.beesang.composes.register.MiddleFrame
import com.example.beesang.composes.register.Name
import com.example.beesang.composes.register.Password
import com.example.beesang.composes.register.RegisterBtn
import com.example.beesang.composes.register.RegisterCompose
import com.example.beesang.composes.register.RegisterRectangle
import com.example.beesang.composes.register.RegisterText
import com.example.beesang.composes.register.School
import com.example.beesang.composes.register.StudentId
import com.example.beesang.composes.register.Title
import com.example.beesang.composes.register.TopLevel
import com.example.beesang.login.notoSansKR
import com.example.beesang.register.Register
import com.example.beesang.retrofit.ApiObject
import com.example.beesang.retrofit.request.UserRegisterRequest
import com.example.beesang.retrofit.response.UserRegisterResponse
import com.example.beesang.ui.theme.BeeSangTheme
import com.google.relay.compose.RelayText
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
                    var id by rememberSaveable { mutableStateOf("") }
                    var password by rememberSaveable { mutableStateOf("") }
                    var checkPassword by rememberSaveable { mutableStateOf("") }
                    var name by rememberSaveable { mutableStateOf("") }
                    var school by rememberSaveable { mutableStateOf("") }
                    var studentId by rememberSaveable { mutableStateOf("") }

                    RegisterCompose(
                        id, onIdChange = { id = it },
                        password, onPasswordChange = { password = it },
                        checkPassword, onCheckPasswordChange = { checkPassword = it },
                        name, onNameChange = { name = it },
                        school, onSchoolChange = { school = it },
                        studentId, onStudentIdChange = { studentId = it },
                        onRegisterBtnTapped = { registerBtnClick(id, password, checkPassword, name, school, studentId) },
                        onBackBtn2Tapped = { backBtnClick() }
                    )

                }
            }
        }
    }

    private fun registerBtnClick(id: String, password: String, checkPassword: String, name: String, school: String, schoolId: String) {
        //ID, PW 유효성 검사

        if(password != checkPassword) {
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        //POST REQUEST
        val data = UserRegisterRequest(id, password, name, school, schoolId)
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
        Intent(this, LoginActivity::class.java).also {
            startActivity(it)
        }
    }
}
