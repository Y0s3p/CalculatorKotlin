package com.example.yosep.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log10

class MainActivity : AppCompatActivity() {

    var acumulado : Double = 0.0
    var progresivo : Double = 0.0
    var valor : Double = 1.0
    var memoria = 0
    var resultado : Double = 0.0
    var op : String = ""
    var resultadoHEX : String = ""
    var totalHEX = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun showValues(v : View){

        when(v.id){

            R.id.button0 -> {
                display.text = display.text.toString() + "0"
            }
            R.id.button1 -> {
                display.text = display.text.toString() + "1"
            }
            R.id.button2 -> {
                display.text = display.text.toString() + "2"
            }
            R.id.button3 -> {
                display.text = display.text.toString() + "3"
            }
            R.id.button4 -> {
                display.text = display.text.toString() + "4"
            }
            R.id.button5 -> {
                display.text = display.text.toString() + "5"
            }
            R.id.button6 -> {
                display.text = display.text.toString() + "6"
            }
            R.id.button7 -> {
                display.text = display.text.toString() + "7"
            }
            R.id.button8 -> {
                display.text = display.text.toString() + "8"
            }
            R.id.button9 -> {
                display.text = display.text.toString() + "9"
            }
            R.id.buttonA -> {
                display.text = display.text.toString() + "A"
            }
            R.id.buttonB -> {
                display.text = display.text.toString() + "B"
            }
            R.id.buttonC -> {
                display.text = display.text.toString() + "C"
            }
            R.id.buttonD -> {
                display.text = display.text.toString() + "D"
            }
            R.id.buttonE -> {
                display.text = display.text.toString() + "E"
            }
            R.id.buttonF -> {
                display.text = display.text.toString() + "F"
            }
            R.id.buttonDot -> {
                display.text = display.text.toString() + "."

            }
            R.id.buttonPlus -> {
                display.text = display.text.toString() + "+"

            }
            R.id.buttonMinus -> {
                display.text = display.text.toString() + "-"

            }
            R.id.buttonMultiplication -> {
                display.text = display.text.toString() + "*"

            }
            R.id.buttonDivision -> {
                display.text = display.text.toString() + "/"

            }

        }

    }


    fun operacion(v : View){

        when(v.id){

            R.id.buttonPlus -> {
                acumulado += display.text.toString().toInt()
                display.setText("")
                op = "+"
            }

            R.id.buttonMinus -> {

                acumulado += display.text.toString().toInt()
                display.setText("")
                op = "-"

            }

            R.id.buttonMultiplication -> {

                acumulado = (acumulado+1) * display.text.toString().toInt()
                display.setText("")
                op = "*"

            }

            R.id.buttonDivision -> {

                acumulado = display.text.toString().toDouble()
                display.setText("")
                op = "/"

            }

        }

    }


    fun getOperacion(v : View){

        progresivo = display.text.toString().toDouble()

        if (op.equals("+")){

            resultado = acumulado + progresivo
            display.setText(resultado.toString())

        }else if (op.equals("-")){

            resultado = acumulado - progresivo
            display.setText(resultado.toString())

        }else if (op.equals("*")){

            resultado = acumulado * progresivo
            display.setText(resultado.toString())

        }else if (op.equals("/")){

            resultado = acumulado / progresivo
            display.setText(resultado.toString())

        }


        acumulado = resultado;

    }


    fun delete(v : View){

        display.text = ""
        acumulado = 0.0
        progresivo = 0.0

    }

    fun delMemoria(v : View){

        memoria = 0

    }

    fun addMemoria(v : View){

        if (display.text.equals(resultado.toString())){

            memoria += resultado.toInt()

        }else{

            memoria += display.text.toString().toInt()

        }



    }

    fun getMemoria(v : View){

        display.text = memoria.toString()

    }

    fun getHexMemoria(v : View){

        display.text = java.lang.Integer.toHexString(memoria)


    }

    fun getOperacionHex(v : View){

        when(op){

            "+"->{

                totalHEX = resultadoHEX.toInt() + display.text.toString().toInt()
                display.setText(java.lang.Integer.toHexString(totalHEX))

            }

            "-"->{

                totalHEX = resultadoHEX.toInt() + display.text.toString().toInt()
                display.setText(java.lang.Integer.toHexString(totalHEX))

            }

            "*"->{

                totalHEX = resultadoHEX.toInt() + display.text.toString().toInt()
                display.setText(java.lang.Integer.toHexString(totalHEX))

            }

            "/"->{

                totalHEX = resultadoHEX.toInt() + display.text.toString().toInt()
                display.setText(java.lang.Integer.toHexString(totalHEX))

            }

        }

    }

    fun operacionHEx(v : View){

        when(v.id){

            R.id.buttonPlus -> {
                resultadoHEX = java.lang.Long.parseLong(display.text.toString(), 16).toString()
                display.text = ""
                op = "+"
            }

            R.id.buttonMinus -> {

                resultadoHEX = java.lang.Long.parseLong(display.text.toString(), 16).toString()
                display.text = ""
                op = "-"

            }

            R.id.buttonMultiplication -> {

                resultadoHEX = java.lang.Long.parseLong(display.text.toString(), 16).toString()
                display.setText("")
                op = "*"

            }

            R.id.buttonDivision -> {

                resultadoHEX = java.lang.Long.parseLong(display.text.toString(), 16).toString()
                display.setText("")
                op = "/"

            }

        }

    }



}
