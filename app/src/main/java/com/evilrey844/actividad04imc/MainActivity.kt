package com.evilrey844.actividad04imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var buttonCalculadora1: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculadora1 = findViewById<Button>(R.id.Calculadora1)
        buttonCalculadora1.setOnClickListener {

            val intent = Intent(this, Calculadora1::class.java)
            startActivity(intent)

        }

    }
}