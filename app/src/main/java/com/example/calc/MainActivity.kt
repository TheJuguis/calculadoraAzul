package com.example.calc


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.calc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var firstValue: Double = 0.0
    var operator: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root


        setContentView(view)


        binding.btnDEL.setOnClickListener{
            binding.pantalla.setText(binding.pantalla.text.dropLast(1))
            //  Toast.makeText(this, "test", Toast.LENGTH_LONG).show()
        }

        binding.btnAC.setOnClickListener{
            binding.pantalla.text.clear()
        }

        binding.btnIgual.setOnClickListener{
            when(operator){
                "Multiplicar" -> {
                    binding.pantalla.setText("${firstValue * binding.pantalla.text.toString().toDouble()}")
                }
                "Dividir" -> {
                    binding.pantalla.setText("${firstValue / binding.pantalla.text.toString().toDouble()}")
                }
                "Sumar" -> {
                    binding.pantalla.setText("${firstValue + binding.pantalla.text.toString().toDouble()}")
                }
                "Restar" -> {
                    binding.pantalla.setText("${firstValue - binding.pantalla.text.toString().toDouble()}")
                }

                else -> {}
            }
        }

        binding.btnPorcentaje.setOnClickListener{
            binding.pantalla.setText("${binding.pantalla.text.toString().toDouble() / 100 }")
        }

    }

    fun presionoUnBoton(view: View){
        val button = view as Button

        when(button.id){

            binding.btnPunto.id->{
                if (!binding.pantalla.text.contains('.')) {
                    binding.pantalla.text.append(".")
                }
            }

            binding.btn0.id -> { binding.pantalla.text.append("0")}
            binding.btn1.id -> { binding.pantalla.text.append("1")}
            binding.btn2.id -> { binding.pantalla.text.append("2")}
            binding.btn3.id -> { binding.pantalla.text.append("3")}
            binding.btn4.id -> { binding.pantalla.text.append("4")}
            binding.btn5.id -> { binding.pantalla.text.append("5")}
            binding.btn6.id -> { binding.pantalla.text.append("6")}
            binding.btn7.id -> { binding.pantalla.text.append("7")}
            binding.btn8.id -> { binding.pantalla.text.append("8")}
            binding.btn9.id -> { binding.pantalla.text.append("9")}
            binding.btnPunto.id -> { binding.pantalla.text.append(".")}
            else -> {Toast.makeText(this, "else", Toast.LENGTH_LONG).show()}
        }
    }

    fun operatorClicked(view: View){
        val button = view as Button
        operator = when(button.id){
            binding.btnMult.id -> { "Multiplicar" }
            binding.btnDiv.id -> { "Dividir" }
            binding.btnSuma.id -> { "Sumar" }
            binding.btnResta.id -> { "Restar" }
            else -> { "" }
        }

        firstValue = binding.pantalla.text.toString().toDouble()

        binding.pantalla.text.clear()


    }
}