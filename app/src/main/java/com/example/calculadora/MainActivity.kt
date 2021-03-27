package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_no_calculadora.*

class MainActivity : AppCompatActivity() {

    private var num1: Double =0.0
    private var num2: Double =0.0
    private var etapa: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numeroUno.setOnClickListener {numeroCliqueado("1") }
        numeroDos.setOnClickListener {numeroCliqueado("2")}
        numeroTres.setOnClickListener {numeroCliqueado("3")}
        numeroCuatro.setOnClickListener {numeroCliqueado("4" )}
        numeroCinco.setOnClickListener {numeroCliqueado("5")}
        numeroSeis.setOnClickListener {numeroCliqueado("6")}
        numeroSiete.setOnClickListener {numeroCliqueado("7")}
        numeroOcho.setOnClickListener {numeroCliqueado("8")}
        numeroNueve.setOnClickListener {numeroCliqueado("9")}
        cero.setOnClickListener {numeroCliqueado("0")}
        punto.setOnClickListener {numeroCliqueado(".")}

        suma.setOnClickListener {operacionPresionada(SUMA)}
        resta.setOnClickListener {operacionPresionada(RESTA)}
        dividir.setOnClickListener {operacionPresionada(DIVISION)}
        multiplicar.setOnClickListener {operacionPresionada(MULTIPLICACION)}

        borrar.setOnClickListener {
            num1=0.0
            num2=0.0
            etapa=0
            vista.text="0" }

        igual.setOnClickListener {
            var resultado  = when(etapa){
                SUMA -> num1 + num2
                RESTA -> num1 - num2
                MULTIPLICACION -> num1 * num2
                DIVISION -> num1 / num2
            else -> 0 }
            vista.text = resultado.toString()
            num1= vista.text.toString().toDouble()
            num2=0.0
            etapa=0 }
        VolverMenuDeCalculadora()
    }
    private fun numeroCliqueado(num: String) {
          if (etapa < 7) {
              if (vista.text=="0"){ vista.text= "$num"}
              else { vista.text = "${vista.text}$num" }
              if (etapa == 0) { num1 = vista.text.toString().toDouble() }
              else { num2 = vista.text.toString().toDouble() }
          }
          else { num1 = vista.text.toString().toDouble()
          num2=0.0
          etapa=6}
    }
    fun operacionPresionada (op: Int){
        if (etapa<=1){
            etapa= op
            vista.text="0" }
        else { num1= vista.text.toString().toDouble()
            num2=0.0
            etapa=0
            vista.text="0" }
    }
    companion object{
                const val SUMA=1
                const val RESTA=2
                const val MULTIPLICACION=3
                const val DIVISION=4
    }
    fun VolverMenuDeCalculadora (){
        volverMenuCalculadora.setOnClickListener {
            val ventanaMenu: Intent = Intent(applicationContext,Menu::class.java)
            startActivity(ventanaMenu)
        }
    }
}

