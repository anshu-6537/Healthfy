package com.example.healthfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_display_info.*


class displayInfo : AppCompatActivity() {
    companion object {

        const val name = "name_extra"
        const val height = "height_extra"
        const val weight = "weight_extra"
        const val age = "age_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)

//parsing values to respective view
        //val dispName = intent.getStringExtra(name)
        //val dispAge = intent.getStringExtra(age)
        val dispHeight = intent.getStringExtra(height)
        val dispWeight = intent.getStringExtra(weight)

            //Toast.makeText(this,dispHeight,Toast.LENGTH_LONG).show()
        displayage.text = intent.getStringExtra(age)
        displayheight.text = dispHeight.toString()
        displayweight.text = dispWeight
        //Toast.makeText(this,dispHeight,Toast.LENGTH_LONG).show()
        //Toast.makeText(this,dispAge,Toast.LENGTH_LONG).show()
        //Toast.makeText(this,dispWeight,Toast.LENGTH_LONG).show()




//converting string to double and calculating BMI

        //val heightvalue = dispHeight?.toDouble()
        //val weightvalue = dispWeight?.toDouble()

        //val bmivalue= weightvalue?.div((heightvalue?.times(heightvalue)!!))?.times(10000)

        //displaybmi.text= bmivalue.toString()

    }
}