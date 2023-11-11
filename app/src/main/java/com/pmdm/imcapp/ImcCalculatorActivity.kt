package com.pmdm.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

   private var weight:Int = 0
    private var age:Int = 0

   private lateinit var viewMale: CardView
   private lateinit var viewFemale: CardView
   private lateinit var tvHeight: TextView
   private lateinit var rsHeight: Slider
   private lateinit var textPeso: TextView
   private lateinit var textEdad: TextView
   private lateinit var btnSubtractWeightAdd: FloatingActionButton
   private lateinit var btnSubtractWeightRemove: FloatingActionButton
   private lateinit var btnSubtractAgeAdd: FloatingActionButton
   private lateinit var btnSubtractAgeRemove: FloatingActionButton
   private lateinit var calcButton: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()

    }

    private fun setCardBackgroundColor(isComponentSelected:Boolean): Int {
        val colorReference = if(isComponentSelected) {
            R.color.bg_comp_sel //true
        } else {
            R.color.bg_comp //false
        }
        return ContextCompat.getColor(this,colorReference)
    }
    private fun setGenderColor() {
       val isMaleSelected:Boolean = true

        viewMale.setCardBackgroundColor(setCardBackgroundColor(isMaleSelected)) //true
        viewFemale.setCardBackgroundColor(setCardBackgroundColor(!isMaleSelected)) //false
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        textPeso = findViewById(R.id.textPeso)
        textEdad = findViewById(R.id.textEdad)
        btnSubtractWeightAdd = findViewById(R.id.btnSubtractWeightAdd)
        btnSubtractWeightRemove = findViewById(R.id.btnSubtractWeightRemove)
        btnSubtractAgeAdd = findViewById(R.id.btnSubtractAgeAdd)
        btnSubtractAgeRemove = findViewById(R.id.btnAgeRemove)
        calcButton = findViewById(R.id.calcButton)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setGenderColor() }
        viewFemale.setOnClickListener { setGenderColor() }
        rsHeight.addOnChangeListener{_,value,_ ->
            //tvHeight.text = value.toString()
            tvHeight.text = DecimalFormat("#.##").format(value) + "cm"
        }
        btnSubtractWeightAdd.setOnClickListener {
            weight +=1
            setWeight()
        }

        btnSubtractAgeAdd.setOnClickListener{
            age +=1
            setAge()
        }

        btnSubtractWeightRemove.setOnClickListener{
            weight -=1
            setWeight()
        }

        btnSubtractAgeRemove.setOnClickListener{
            age -=1
            setWeight()
        }
        calcButton.setOnClickListener {
            val imcResult = calculateIMC()
            navigate2result(imcResult)
        }
    }

    private fun setWeight() {
    textPeso.text = weight.toString()
    }

    private fun setAge() {
        textEdad.text = age.toString()
    }

    private fun calculateIMC() :Double  {
       //Me aseguro de que tvHeight.text es un valor Double
        val height = tvHeight.text.toString().toDoubleOrNull() ?: 0.0

        //Evita la división por cero
        if(height == 0.0) {
            //Maneja el caso en el que la altura puede ser 0
            return 0.0
        }
        return (weight/height) * (weight/height)
    }

    private fun navigate2result(result: Double) {
        val intent = Intent(this, ImcResultActivity::class.java)
        intent.putExtra("result", result)
        startActivity(intent)
    }

}