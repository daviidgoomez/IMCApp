package com.pmdm.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView

class ImcResultActivity : AppCompatActivity() {

private lateinit var recalcButton: AppCompatButton
private lateinit var tituloPeso: TextView
private lateinit var resultadoPeso:TextView
private lateinit var descripcionPeso: TextView
//private lateinit var colorTitulo: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_result)
        initComponent()
        initUI()
       initListeners()
    }

    private fun initComponent() {
        recalcButton = findViewById(R.id.recalcButton)
        tituloPeso = findViewById(R.id.tituloPeso)
        resultadoPeso = findViewById(R.id.resultadoPeso)
        descripcionPeso = findViewById(R.id.descripcionPeso)
     //   colorTitulo = findViewById(R.id.tituloPeso)
    }

    private fun initUI() {
        val titulo:String =intent.extras?.getString("Título").orEmpty()
        tituloPeso.text = titulo
        val res:String? = intent.extras?.getString("Resultado")
        resultadoPeso.text = res.toString()
        val desc =
            intent.extras?.getString("Descripción").orEmpty()
        descripcionPeso.text = desc
      //  val color =
         //   intent.extras?.getString("Color").orEmpty()
     //   colorTitulo.text = color

    }

    private fun initListeners() {
    recalcButton.setOnClickListener{
        navigateRecalc()
    }
    }

    private fun navigateRecalc() {
        val intent = Intent (this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

}