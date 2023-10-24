package com.evilrey844.actividad04imc

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider

class IMCActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)

        val textViewPeso = findViewById<TextView>(R.id.textViewNumeroPeso)
        val textViewEdad = findViewById<TextView>(R.id.textViewNumeroEdad)
        val rangeSliderAltura = findViewById<RangeSlider>(R.id.rangeSliderAltura)
        val altura = rangeSliderAltura.values[0]  // Debería obtener el valor seleccionado en el RangeSlider

        // Configura los botones inmediatamente después de obtener las referencias a los TextViews
        configurarBotones(textViewPeso, textViewEdad)

        configurarSeleccionDeGeneroYAltura()

        val botonCalcular = findViewById<Button>(R.id.botonCalcular)
        botonCalcular.setOnClickListener {
            try {
                val peso = textViewPeso.text.toString().toDouble()
                val altura = textViewEdad.text.toString().toDouble()

                val imc = calcularIMC(peso, altura)

                // Uso un Intent para iniciar ResultIMCActivity
                val intent = Intent(this, ResultIMCActivity::class.java)
                // Se el resultado del cálculo del IMC como un extra
                intent.putExtra("RESULTADO_IMC", imc)
                // Inicio ResultIMCActivity
                startActivity(intent)

            } catch (e: NumberFormatException) {
                Toast.makeText(
                    this,
                    "Por favor, introduce números válidos para el peso y la altura.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun configurarBotones(textViewPeso: TextView, textViewEdad: TextView) {
        val botonMasPeso = findViewById<Button>(R.id.botonMasPeso)
        val botonMenosPeso = findViewById<Button>(R.id.botonMenosPeso)
        val botonMasEdad = findViewById<Button>(R.id.botonMasEdad)
        val botonMenosEdad = findViewById<Button>(R.id.botonMenosEdad)

        botonMasPeso.setOnClickListener {
            val pesoActual = textViewPeso.text.toString().toInt()
            textViewPeso.text = (pesoActual + 1).toString()
        }

        botonMenosPeso.setOnClickListener {
            val pesoActual = textViewPeso.text.toString().toInt()
            if (pesoActual > 0) {
                textViewPeso.text = (pesoActual - 1).toString()
            }
        }

        botonMasEdad.setOnClickListener {
            val edadActual = textViewEdad.text.toString().toInt()
            textViewEdad.text = (edadActual + 1).toString()
        }

        botonMenosEdad.setOnClickListener {
            val edadActual = textViewEdad.text.toString().toInt()
            if (edadActual > 0) {
                textViewEdad.text = (edadActual - 1).toString()
            }
        }
    }

    private fun configurarSeleccionDeGeneroYAltura() {
        // Variable para almacenar si el usuario ha seleccionado "Hombre" o "Mujer"
        var generoSeleccionado: String? = null

        // Variable para almacenar si el usuario ha ingresado una altura
        var alturaIngresada: Boolean = false

        // Obtener las referencias a los CardView
        val cardView1 = findViewById<CardView>(R.id.cardView1)
        val cardView2 = findViewById<CardView>(R.id.cardView2)
        val cardView3 = findViewById<CardView>(R.id.cardView3)

        // Configura los botones de "Hombre" y "Mujer" para actualizar la variable generoSeleccionado
        cardView1.setOnClickListener {
            generoSeleccionado = "Hombre"
        }

        cardView2.setOnClickListener {
            generoSeleccionado = "Mujer"
        }

        // Configura el CardView de la altura para actualizar la variable alturaIngresada
        cardView3.setOnClickListener {
            alturaIngresada = true
        }
    }

    private fun calcularIMC(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }
}



