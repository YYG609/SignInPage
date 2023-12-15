package com.android.ex4_makepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // TextView 연결
        val user_Id = findViewById<TextView>(R.id.tv_userId)

        // ImageView 연결
        val profileImage = findViewById<ImageView>(R.id.iv_signInLogo)

        // profileImage를 랜덤 출력
        when (Random.nextInt(1, 6)) {
            1 -> profileImage.setImageResource(R.drawable.lv1)
            2 -> profileImage.setImageResource(R.drawable.lv2)
            3 -> profileImage.setImageResource(R.drawable.lv3)
            4 -> profileImage.setImageResource(R.drawable.lv4)
            5 -> profileImage.setImageResource(R.drawable.lv5)
        }

        // 아이디 인텐트 받아오기
        val userId_Data = intent.getStringExtra("id_DataFromSignInActivity")

        // 받아온 인텐트 데이터로 TextView 설정
        user_Id.setText(userId_Data)

        // 종료버튼
        val btn_close = findViewById<Button>(R.id.btn_finish)
        btn_close.setOnClickListener {
            finish()
        }
    }
}