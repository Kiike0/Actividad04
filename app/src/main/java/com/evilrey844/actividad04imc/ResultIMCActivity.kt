package com.evilrey844.actividad04imc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultIMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        //  el resultado del cálculo del IMC del Intent
        val imc = intent.getDoubleExtra("RESULTADO_IMC", 0.0)

        // Obtengo una referencia al TextView
        val textViewResultado = findViewById<TextView>(R.id.textViewResultado)

        // Obtengo el mensaje correspondiente al rango del IMC
        val mensaje = obtenerMensajeSegunIMC(imc)

        // Se muestra el resultado y el mensaje en el TextView
        textViewResultado.text = "Tu IMC es: $imc. $mensaje"
    }

    fun obtenerMensajeSegunIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "Se encuentra dentro del rango de peso insuficiente."
            imc < 24.9 -> "Se encuentra dentro del rango de peso normal o saludable."
            imc < 29.9 -> "Se encuentra dentro del rango de sobrepeso."
            else -> "Se encuentra dentro del rango de obesidad."
        }
    }
}