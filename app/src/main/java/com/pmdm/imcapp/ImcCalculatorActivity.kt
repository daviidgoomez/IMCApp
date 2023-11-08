package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class ImcCalculatorActivity : AppCompatActivity() {

   private lateinit var viewMale: CardView
   private lateinit var viewFemale: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
    }



    private fun initComponents() {
        viewFemale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
    }

}