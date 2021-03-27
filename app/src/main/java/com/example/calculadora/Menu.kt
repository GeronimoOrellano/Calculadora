package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_AppCompat)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        irCalculadora()
        irBroma()

    }
    fun irCalculadora (){
        calcular.setOnClickListener {
            val ventanaCalculadora: Intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(ventanaCalculadora)
        }
    }
    fun irBroma (){
        noCalcular.setOnClickListener {
            val ventanaNoCalculadora: Intent= Intent(applicationContext,noCalculadora::class.java)
            startActivity(ventanaNoCalculadora)
        }
    }
}