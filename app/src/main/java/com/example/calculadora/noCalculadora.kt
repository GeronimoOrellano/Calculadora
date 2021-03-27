package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_no_calculadora.*

class noCalculadora : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_no_calculadora)
        volverMenuDeBroma()
    }
    fun volverMenuDeBroma (){
        volverDeBroma.setOnClickListener {
            val ventanaMenuDeBroma: Intent = Intent(applicationContext,Menu::class.java)
            startActivity(ventanaMenuDeBroma)
        }
    }
}