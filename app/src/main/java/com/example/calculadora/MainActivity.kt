package com.example.interestcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadora.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etPrincipal = findViewById<EditText>(R.id.etPrincipal)
        val etRate = findViewById<EditText>(R.id.etRate)
        val etTime = findViewById<EditText>(R.id.etTime)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        btnCalculate.setOnClickListener {
            val principal = etPrincipal.text.toString().toDoubleOrNull()
            val rate = etRate.text.toString().toDoubleOrNull()
            val time = etTime.text.toString().toDoubleOrNull()

            if (principal == null || rate == null || time == null) {
                Toast.makeText(this, "Por favor, ingrese todos los valores", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val amount = principal * Math.pow(1 + rate / 100, time)
            val interest = amount - principal

            tvResult.text = "Monto Total (A): $amount\nMonto de Interés (I): $interest"
        }

        btnClear.setOnClickListener {
            etPrincipal.text.clear()
            etRate.text.clear()
            etTime.text.clear()
            tvResult.text = ""
        }
    }
}
