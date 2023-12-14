package com.android.ex4_makepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // 아이디 인텐트 받아오기
        val userId_Data = intent.getStringExtra("id_DataFromSignInActivity")
        val user_Id = findViewById<TextView>(R.id.tv_userId)
        // 이름 인텐트 받아오기
//        val userName_Data = intent.getStringExtra("Name_DataFromSignInActivity")
//        val user_Name = findViewById<TextView>(R.id.tv_userName)

        // 받아온 인텐트데이터로 TextView 설정
        user_Id.setText(userId_Data)
//        user_Name.setText(userName_Data)



        // 종료버튼
        val btn_close = findViewById<Button>(R.id.btn_finish)
        btn_close.setOnClickListener {
            finish()
        }

    }
}