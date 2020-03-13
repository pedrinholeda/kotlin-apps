package com.pedro.seekbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var texto : TextView
    lateinit var seekBar: SeekBar
    lateinit var botao: Button
    lateinit var  cola: TextView
    lateinit var  score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cola = findViewById(R.id.cola)
        texto = findViewById(R.id.valorAtual)
        seekBar = findViewById(R.id.seekBar)
        botao = findViewById(R.id.button)
        score = findViewById(R.id.score)

        var rnds: Int = (0..100).random()
        texto.text = "" + rnds
        score.text = "" + 0


        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                cola.text = "Cola: " + progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//                Toast.makeText(applicationContext, "Começou", Toast.LENGTH_SHORT).show()

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//                Toast.makeText(applicationContext, "parou", Toast.LENGTH_SHORT).show()
            }
        })

        botao.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                var barra = seekBar.progress.toInt()
                var diferenca = abs(barra - rnds)
                var points = 100 - diferenca

                if (diferenca == 0){

                    Toast.makeText(applicationContext, "Perfeito!", Toast.LENGTH_SHORT ).show()
                    points += 100
                } else if (diferenca < 5) {
                    points += 50
                    Toast.makeText(applicationContext, "UHH Quase!", Toast.LENGTH_SHORT ).show()
                } else if (diferenca < 50) {
                    Toast.makeText(applicationContext, "Continue tentando", Toast.LENGTH_SHORT ).show()
                }else{
                    Toast.makeText(applicationContext, "Nem chegou perto", Toast.LENGTH_SHORT ).show()
                }

//                score.text.toString().toInt() =+ points
                score.text = "" + points
                rnds = (0..100).random()
                texto.text = "" + rnds
            }

        })

    }

}
