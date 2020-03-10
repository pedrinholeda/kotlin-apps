package com.pedro.ratingbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var texto: TextView
    lateinit var ratingBar: RatingBar
    lateinit var  botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        texto = findViewById(R.id.valorSelecionado)
        ratingBar = findViewById(R.id.ratingBar)
        botao = findViewById(R.id.button)

        ratingBar.setOnRatingBarChangeListener {ratingBar, rating, fromUser ->  rating
            texto.text="" + rating
        }

        botao.setOnClickListener{
            Toast.makeText(applicationContext, "valor selecionado: " + ratingBar.rating, Toast.LENGTH_SHORT).show()
        }
    }
}
