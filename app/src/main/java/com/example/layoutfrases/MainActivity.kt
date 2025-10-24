package com.example.layoutfrases

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var fraseRepository = FraseRepository()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var nome = findViewById<TextView>(R.id.text_view_nome)
        var nomeRecuperacao = this.getSharedPreferences("motivacao",MODE_PRIVATE).getString("nome","Olá Paula Tejano")
        nome.text = nomeRecuperacao

        var novaFrase = findViewById<TextView>(R.id.frase)
        var botaoFrase = findViewById<Button>(R.id.Button)
        var imageminfinity = findViewById<ImageView>(R.id.image_infinity)
        var imagemhappy = findViewById<ImageView>(R.id.image_happy)
        var imagemsun = findViewById<ImageView>(R.id.image_sun)

        imageminfinity.setOnClickListener {
            imageminfinity.setColorFilter(ContextCompat.getColor(this,R.color.white))
            imagemhappy.setColorFilter(ContextCompat.getColor(this,R.color.black))
            imagemsun.setColorFilter(ContextCompat.getColor(this,R.color.black))
            var fraseSorteada = fraseRepository.getFrase(0)
            novaFrase.text = fraseSorteada
        }

        imagemhappy.setOnClickListener {
            imagemhappy.setColorFilter(ContextCompat.getColor(this,R.color.white))
            imageminfinity.setColorFilter(ContextCompat.getColor(this,R.color.black))
            imagemsun.setColorFilter(ContextCompat.getColor(this,R.color.black))
            var fraseSorteada = fraseRepository.getFrase(1)
            novaFrase.text = fraseSorteada
        }

        imagemsun.setOnClickListener {
            imagemsun.setColorFilter(ContextCompat.getColor(this,R.color.white))
            imageminfinity.setColorFilter(ContextCompat.getColor(this,R.color.black))
            imagemhappy.setColorFilter(ContextCompat.getColor(this,R.color.black))
            var fraseSorteada = fraseRepository.getFrase(2)
            novaFrase.text = fraseSorteada
        }


        botaoFrase.setOnClickListener {
            var fraseSorteada = fraseRepository.getFrase(0)
            novaFrase.text = fraseSorteada
        }
    }
}