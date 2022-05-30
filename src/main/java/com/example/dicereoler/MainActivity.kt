package com.example.dicereoler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button =  findViewById(R.id.button) // cria uma variavel para achar o id do button que executar o click
        rollButton.setOnClickListener { // função de um click e que retorna a mesma pagina
            rollDices() // função que faz gerar os numeros aleatoris
        }
    }


    private fun rollDices() {
        //Criou um novo objeto Dice com 6 lados e jogue os dados
        val dice = Dice(6)
        val diceRoll = dice.roll()

        //Encontrou a ImageView no layout
        val diceImage: ImageView = findViewById(R.id.imageView)

       //Determinou qual ID de recurso drawable usar com base na jogada de dados
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Atualizou o ImageView com o ID de recurso drawable correto
        diceImage.setImageResource(drawableResource)

        //Atualizou a descrição do conteúdo
        diceImage.contentDescription = diceRoll.toString()


    }


    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }
}