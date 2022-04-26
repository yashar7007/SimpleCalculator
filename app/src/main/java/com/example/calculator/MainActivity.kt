package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }



    fun buNumberEvent(view: View) {
        val EntryData = findViewById<TextView>(R.id.etShowValues)
        if (isNewOp==true){
            EntryData.setText("")
        }
        isNewOp=false
        val buSelected = view as Button
        var buClickValue: String = EntryData.text.toString()
        when (buSelected.id) {
            R.id.bu0 -> {
                buClickValue += "0"
            }
            R.id.bu1 -> {
                buClickValue += "1"
            }
            R.id.bu2 -> {
                buClickValue += "2"
            }
            R.id.bu3 -> {
                buClickValue += "3"
            }
            R.id.bu4 -> {
                buClickValue += "4"
            }
            R.id.bu5 -> {
                buClickValue += "5"
            }
            R.id.bu6 -> {
                buClickValue += "6"
            }
            R.id.bu7 -> {
                buClickValue += "7"
            }
            R.id.bu8 -> {
                buClickValue += "8"
            }
            R.id.bu9 -> {
                buClickValue += "9"
            }
            R.id.buDot -> {
                buClickValue += "."
            }
            R.id.buPlusMin -> {
                buClickValue = "-" + buClickValue
            }
            R.id.buAC -> {
                buClickValue = ""
  //              isNewOp=true
            }
        }
        EntryData.setText(buClickValue)
    }

    var op="*"
    var oldNumber=""
    var isNewOp=true
    fun buOpEvent(view: View) {
        val EntryData = findViewById<TextView>(R.id.etShowValues)
        val buSelected = view as Button
        when (buSelected.id) {
            R.id.buMul -> {
                 op="*"
            }
            R.id.buDiv -> {
                 op="/"
            }
            R.id.buMinus -> {
                 op="-"
            }
            R.id.buSum -> {
                 op="+"
            }
        }
        oldNumber=EntryData.text.toString()
        isNewOp=true
    }
    fun buEqualEvent(view: View){
        val EntryData = findViewById<TextView>(R.id.etShowValues)
        val newNumber=EntryData.text.toString()
        var totalNumber:Double?=null
        when(op){
            "*"->{
                totalNumber=oldNumber.toDouble() * newNumber.toDouble()
            }
            "/"->{
                totalNumber=oldNumber.toDouble() / newNumber.toDouble()
            }
            "-"->{
                totalNumber=oldNumber.toDouble() - newNumber.toDouble()
            }
            "+"->{
                totalNumber=oldNumber.toDouble() + newNumber.toDouble()
            }


        }
        EntryData.setText(totalNumber.toString())
        isNewOp=true
    }
    fun buPercent(view: View){
        val EntryData = findViewById<TextView>(R.id.etShowValues)
        val newNumber=EntryData.text.toString()
        var number:Double
        if (oldNumber!=null){
            number = (newNumber.toDouble()*oldNumber.toDouble())/100
        }else{
            number = EntryData.text.toString().toDouble()/100
        }
   //     val number = EntryData.text.toString().toDouble()/100
        val df = DecimalFormat("#.##")
        EntryData.setText(number.toString())
        isNewOp=true
    }
}