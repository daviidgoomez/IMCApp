package com.pmdm.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.internal.ViewUtils
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

   private lateinit var viewMale: CardView
   private lateinit var viewFemale: CardView
   private lateinit var tvHeight: TextView
   private lateinit var rsHeight: Slider
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
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
    }

    private fun initListeners() {
        viewMale.setOnClickListener { setGenderColor() }
        viewFemale.setOnClickListener { setGenderColor() }
        rsHeight.addOnChangeListener{_,value,_ ->
            //tvHeight.text = value.toString()
            tvHeight.text = DecimalFormat("#.##").format(value) + "c m"
        }
    }

}