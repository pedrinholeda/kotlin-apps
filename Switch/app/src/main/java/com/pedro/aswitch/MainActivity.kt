package com.pedro.aswitch

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var botao: Button
    lateinit var interruptor: Switch

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.status)
        botao = findViewById(R.id.button)
        interruptor = findViewById(R.id.switch1)


        interruptor.setOnCheckedChangeListener{
            buttonView, isChecked -> isChecked
            var ligadoOuDesligado = " "
            if (isChecked){
                ligadoOuDesligado = "Ligado"
//                fundo.setBackgroundColor(R.color.claro)
//                texto.setTextColor(R.color.escuro)
            } else{
                ligadoOuDesligado = "Desligado"
//                fundo.setBackgroundColor(R.color.escuro)
//                texto.setTextColor(R.color.claro)
            }
            texto.text = ligadoOuDesligado
        }

        botao.setOnClickListener( object : View.OnClickListener{
            override fun onClick(v: View?) {
                var ligadoOuDesligado = " "
                if (interruptor.isChecked){
                    ligadoOuDesligado = "Ligado"
                } else{
                    ligadoOuDesligado = "Desligado"
                }

                Toast.makeText(applicationContext, "Switch está: " + ligadoOuDesligado, Toast.LENGTH_LONG).show()

            }
        })
    }
}
