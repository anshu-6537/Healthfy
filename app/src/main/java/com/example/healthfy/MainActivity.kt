package com.example.healthfy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button1 =findViewById<Button>(R.id.button1)
        button1.setOnClickListener {
            intent = Intent(this , InfoActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}