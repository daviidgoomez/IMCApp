package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton

class ImcResultActivity : AppCompatActivity() {

    private lateinit var calcButton: AppCompatButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        initComponent()
        initUI()
       initListeners()
    }

    private fun initComponent() {
        calcButton = findViewById(R.id.calcButton)
    }

    private fun initUI() {

    }

    private fun initListeners() {
        calcButton.setOnClickListener {
            val res:Double = intent.extras?.getDouble("resultado") ?: 0.0
            calcButton.text = "Este es el $res"
        }
    }

}