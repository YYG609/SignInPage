package com.android.ex4_makepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
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
        // when 조건문에 ((1..5).random())을 넣어줘도 된다
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
        // 위에서 한 것 처럼 데이터 받아서 입력해줘도 되고, 밑 if로 해도 됨 / if로 하면 예외처리 기능도 되는 듯하다
//        if(intent.hasExtra("id_DataFromSignInActivity")){
//            user_Id.text = "아이디 : " + intent.getStringExtra("id_DataFromSignInActivity")
//        }

        // 종료버튼
        val btn_close = findViewById<ConstraintLayout>(R.id.btn_close)
        btn_close.setOnClickListener {
            finish()
        }
    }
}