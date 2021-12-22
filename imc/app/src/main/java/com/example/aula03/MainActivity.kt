package com.example.aula03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var etAge : AppCompatEditText
    private lateinit var etWeight : AppCompatEditText
    private lateinit var etHeight : AppCompatEditText
    private lateinit var btnCalculate : AppCompatButton
    private lateinit var tvImc : AppCompatTextView
    private lateinit var tvResult : AppCompatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etAge = findViewById(R.id.et_age)
        etWeight = findViewById(R.id.et_weight)
        etHeight = findViewById(R.id.et_height)
        btnCalculate = findViewById(R.id.btn_calculate)
        tvImc = findViewById(R.id.tv_imc)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener {
            val format = DecimalFormat("##.00")

            val imc = calculateIMC()
            val result = rangeIMC()

            tvImc.text = format.format(imc)
            tvResult.text = result
            tvImc.visibility = View.VISIBLE
            tvResult.visibility = View.VISIBLE

        }
    }

    private fun calculateIMC(): Double {

        val height = etHeight.text.toString().toDouble()
        val weight = etWeight.text.toString().toDouble()
        val result = weight / (height * height)

        return result
    }

    private fun rangeIMC(): String {
        val value = calculateIMC()

        return when {
            value < 18.5 -> "Abaixo do Peso"
            value >= 18.5 && value < 25.0 -> "Peso Normal"
            value >= 25.0 && value < 30.0 -> "Sobrepeso"
            value >= 30.0 && value < 35.0 -> "Obresidade Grau 1"
            value >= 35.0 && value < 40.0 -> "Obresidade Grau 2"
            else -> "Obresidade Mórbida"
        }
    }
}
