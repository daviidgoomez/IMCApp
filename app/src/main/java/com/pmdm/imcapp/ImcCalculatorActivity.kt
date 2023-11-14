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


    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var weight: Int = 40
    private var age: Int = 18

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

    private fun setCardBackgroundColor(isComponentSelected: Boolean): Int {
        val colorReference = if (isComponentSelected) {
            R.color.bg_comp_sel //true
        } else {
            R.color.bg_comp //false
        }
        return ContextCompat.getColor(this, colorReference)
    }

    private fun setGenderColor() {

        viewMale.setCardBackgroundColor(setCardBackgroundColor(isMaleSelected)) //true
        viewFemale.setCardBackgroundColor(setCardBackgroundColor(!isMaleSelected)) //false
    }

    private fun color() {
        isMaleSelected = !isMaleSelected;
        isFemaleSelected = !isFemaleSelected
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
        viewMale.setOnClickListener {
            color()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            color()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            //tvHeight.text = value.toString()
            tvHeight.text = DecimalFormat("#.##").format(value) + "cm"
        }
        btnSubtractWeightAdd.setOnClickListener {
            weight += 1
            setWeight()
        }

        btnSubtractAgeAdd.setOnClickListener {
            age += 1
            setAge()
        }

        btnSubtractWeightRemove.setOnClickListener {
            weight -= 1
            setWeight()
        }

        btnSubtractAgeRemove.setOnClickListener {
            age -= 1
            setAge()
        }
        calcButton.setOnClickListener {
            val imcResult = calculateIMC()
          //  navigate2result(titulo, desc, res)
        }
    }

    private fun navigate2result(titulo:String ,desc:String,res:Double) {
        val intent = Intent (this,ImcResultActivity::class.java)
        intent.putExtra("titulo",titulo)
        intent.putExtra("desc",desc)
        intent.putExtra("res",res)
        startActivity(intent)
    }


    private fun setWeight() {
        textPeso.text = weight.toString()
    }

    private fun setAge() {
        textEdad.text = age.toString()
    }

    private fun calculateIMC() {

        var peso: Double = tvHeight.toString().toDouble();
        var altura: Double = tvHeight.toString().toDouble();
        altura = (altura / 100)
        altura = altura * altura
        var res: Double = peso / (altura);

        var desc: String
        var titulo: String




       // navigate2result(titulo,desc,res)


    }


}
