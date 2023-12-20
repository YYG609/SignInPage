package com.android.ex4_makepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // 회원가입 버튼 연결
        val btn_SignUp = findViewById<Button>(R.id.btn_signUpConfirm)

        btn_SignUp.setOnClickListener {
            // 이름, 아이디, 비밀번호 각 EditText와 연결
            val user_Name = findViewById<EditText>(R.id.et_name)
            val user_Id = findViewById<EditText>(R.id.et_id)
            val user_Pw = findViewById<EditText>(R.id.et_pw)

            // 이름, 아이디, 비밀번호 데이터 값
            val userName_Data = user_Name.text.toString()
            val userId_Data = user_Id.text.toString()
            val userPw_Data = user_Pw.text.toString()

            // 이름, 아이디, 비밀번호 값이 없을 경우엔 토스트 외 반응x
            if (userName_Data.trim().isEmpty() || userId_Data.trim().isEmpty() || userPw_Data.trim().isEmpty()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            } else {
                // 다 적었으면 finish()로 SignInActivity화면으로 돌아간다
                Toast.makeText(this, "회원가입 완료!", Toast.LENGTH_SHORT).show()

                // 아이디와 비밀번호 SignInActivity 인텐트 구문
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("userId", userId_Data)
                intent.putExtra("userPw", userPw_Data)
                setResult(RESULT_OK, intent)

                finish()
            }
        }
    }
}