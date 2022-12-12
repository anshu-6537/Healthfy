package com.example.healthfy

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)


        val name = findViewById<EditText>(R.id.Entername)
        val age = findViewById<EditText>(R.id.Enterage)
        val height = findViewById<EditText>(R.id.Enterheight)
        val weight = findViewById<EditText>(R.id.Enterweight)



        val btn_click_me = findViewById<Button>(R.id.submit)
        //Toast.makeText(this,,Toast.LENGTH_SHORT).show()
        btn_click_me.setOnClickListener {
            val intent = Intent(this, displayInfo::class.java)

            intent.putExtra(displayInfo.name, name.text.toString())
            intent.putExtra("age", age.text.toString())
            intent.putExtra("height", height.text.toString())
            intent.putExtra("weight", weight.text.toString())
            //Toast.makeText(this,height.text.toString(),Toast.LENGTH_LONG).show()

            startActivity(intent)
        }
    }
}