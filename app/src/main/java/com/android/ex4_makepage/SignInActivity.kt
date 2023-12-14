package com.android.ex4_makepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // 버튼 코드에 연결
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signup = findViewById<Button>(R.id.btn_signUp)

        btn_login.setOnClickListener {
            // 아이디, 비밀번호 각 EditText랑 연결
            val user_Id = findViewById<EditText>(R.id.et_id)
            val user_Pw = findViewById<EditText>(R.id.et_pw)

            // 액티비티 전환 명시적 인텐트
            val intent = Intent(this, HomeActivity::class.java)

            // 입력받은 아이디, 비밀번호 데이터 값
            val userId_Data = user_Id.text.toString()
            val userPw_Data = user_Pw.text.toString()

            // 입력받은 아이디의 키-밸류 인텐트(HomeActivity로)
            intent.putExtra("id_DataFromSignInActivity", userId_Data)

            // 아이디나 비밀번호에 값이 없을 경우엔 토스트 외 반응x
            if(userId_Data.isEmpty() || userPw_Data.isEmpty()){
                Toast.makeText(applicationContext,"아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"로그인 성공", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }

        // 회원가입 버튼 클릭 시 SignUpActivity로 전환해주는 인텐트
        btn_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}