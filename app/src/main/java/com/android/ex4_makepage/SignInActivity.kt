package com.android.ex4_makepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    // ActivityResultLauncher 자료형인 getResult 변수를 전역 변수로 선언
    private lateinit var getResult: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        // 아이디, 비밀번호 각 EditText랑 연결
        val user_Id = findViewById<EditText>(R.id.et_id)
        val user_Pw = findViewById<EditText>(R.id.et_pw)

        // 버튼 코드에 연결
        val btn_login = findViewById<Button>(R.id.btn_login)
        val btn_signup = findViewById<Button>(R.id.btn_signUp)

        // 만들어준 변수 getResult에 registerForActivityResult 메서드를 활용해서
        // ActivityLauncher를 생성
        getResult = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) { result ->
            // SignUpActivity로 부터 돌아올 때의 결과 값을 받아 올 수 있는 구문
            if (result.resultCode == RESULT_OK) {
                val userId = result.data?.getStringExtra("userId") ?: ""
                val userPw = result.data?.getStringExtra("userPw") ?: ""

                // EditText에 .text를 사용하면 TypeMismatch 에러가 발생하므로 .SetText()
                user_Id.setText(userId)
                user_Pw.setText(userPw)
            }
        }

        btn_login.setOnClickListener {
            // 액티비티 전환 명시적 인텐트
            val intent = Intent(this, HomeActivity::class.java)

            // 입력받은 아이디, 비밀번호 데이터 값
            val userId_Data = user_Id.text.toString()
            val userPw_Data = user_Pw.text.toString()

            // 아이디나 비밀번호에 값이 없을 경우엔 토스트 외 반응x
            if (userId_Data.trim().isEmpty() || userPw_Data.trim().isEmpty()) {
                // 가급적 text = getString(R.string.메세지) 사용 -> value/string에 텍스트 추가
                Toast.makeText(this, getString(R.string.toast_msg_idpqErr), Toast.LENGTH_SHORT).show()

                // return@setOnClickListener 를 추가하면 뒤에 else를 안써도 된다
                // 대신 로그인 성공 조건은 있어야 됨
            } else {
                Toast.makeText(this, getString(R.string.toast_msg_login), Toast.LENGTH_SHORT).show()
                // 입력받은 아이디의 키-밸류 인텐트(HomeActivity로)
                intent.putExtra("id_DataFromSignInActivity", userId_Data)
                startActivity(intent)
            }
        }

        // 회원가입 버튼 클릭 시 SignUpActivity로 전환해주는 인텐트
        btn_signup.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            // launch는 startActivity와 동일한 기능
            getResult.launch(intent)
        }
    }
}