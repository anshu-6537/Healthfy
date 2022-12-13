package com.example.healthfy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.healthfy.databinding.ActivityReadDataBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_read_data.*


class readData : AppCompatActivity() {
    companion object {

        const val bmi = "BMI_EXTRA"
    }
    private lateinit var binding: ActivityReadDataBinding
    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bmiVALUE = intent.getStringExtra(bmi)
        bmivalue.text = bmiVALUE


        val temp =bmiVALUE?.toDouble()
        val bmiV= temp?.toInt()
        if (bmiV != null) {
            Toast.makeText(this,bmiV.toString(),Toast.LENGTH_LONG).show()
        }
        bmiVALUE = bmiV.toString()
//        val userName : String = binding.toString()
        readdata(bmiVALUE)
    }

    private fun readdata(bmiVALUE: String) {

        database = FirebaseDatabase.getInstance().getReference("BMI")
        database.child(bmiVALUE).get().addOnSuccessListener {

            if(it.exists()){

    //reading data
                val breakfast = it.child("Breakfast").value
                val midmeal = it.child("MidMeal").value
                val lunch = it.child("Lunch").value
                val snacks = it.child("Snacks").value
                val dinner = it.child("Dinner").value

                Toast.makeText(this,"Successfully read",Toast.LENGTH_LONG).show()
    //setting textView
                binding.breakfastmenu.text = breakfast.toString()
                binding.MidMealmenu.text = midmeal.toString()
                binding.Lunchmenu.text = lunch.toString()
                binding.Snacksmenu.text = snacks.toString()
                binding.Dinnermenu.text = dinner.toString()


            }
            else{
                Toast.makeText(this,"value doesn't exists",Toast.LENGTH_LONG).show()


            }
        }.addOnFailureListener {

            Toast.makeText(this,"data can't be read",Toast.LENGTH_LONG).show()
        }
    }
}

