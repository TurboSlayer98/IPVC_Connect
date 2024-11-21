package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CursosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_cursos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.cursos_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val escolaNome = intent.getStringExtra("ESCOLA_NOME") ?: "Escola"
        findViewById<TextView>(R.id.textView1).text = "Cursos - $escolaNome"

        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Lista de cursos baseada na escola selecionada
        val cursos = when(escolaNome) {
            "ESTG" -> listOf(
                Curso("Engenharia Informática", "Licenciatura - 3 anos", "ESTG"),
                Curso("Gestão", "Licenciatura - 3 anos", "ESTG"),
                Curso("Design de Jogos Digitais", "Licenciatura - 3 anos", "ESTG"),
                Curso("Engenharia Civil e do Ambiente", "Licenciatura - 3 anos", "ESTG"),
                Curso("Engenharia Alimentar", "Licenciatura - 3 anos", "ESTG"),
                Curso("Engenharia Mecânica", "Licenciatura - 3 anos", "ESTG"),
                Curso("Engenharia da Computação Gráfica e Multimédia", "Licenciatura - 3 anos", "ESTG"),
                Curso("Engenharia Eletrónica e Redes de Computadores", "Licenciatura - 3 anos", "ESTG"),
                Curso("Turismo", "Licenciatura - 3 anos", "ESTG")
            )
            "ESE" -> listOf(
                Curso("Educação Básica", "Licenciatura - 3 anos", "ESE"),
                Curso("Educação Social Gerontológica", "Licenciatura - 3 anos", "ESE"),
                Curso("Arte e Design", "Licenciatura - 3 anos", "ESE"),
                Curso("Gestão Artística e Cultural", "Licenciatura - 3 anos", "ESE")
            )
            "ESS" -> listOf(
                Curso("Enfermagem", "Licenciatura - 4 anos", "ESS"),
                Curso("Biotecnologia", "Licenciatura - 3 anos", "ESS")
            )
            "ESDL" -> listOf(
                Curso("Desporto e Lazer", "Licenciatura - 3 anos", "ESDL"),
                Curso("Treino Desportivo", "Licenciatura - 3 anos", "ESDL")
            )
            "ESCE" -> listOf(
                Curso("Contabilidade e Fiscalidade", "Licenciatura - 3 anos", "ESCE"),
                Curso("Marketing e Comunicação Empresarial", "Licenciatura - 3 anos", "ESCE"),
                Curso("Organização e Gestão Empresariais", "Licenciatura - 3 anos", "ESCE"),
                Curso("Informática de Gestão", "Licenciatura - 3 anos", "ESCE")
            )
            "ESAS" -> listOf(
                Curso("Agronomia", "Licenciatura - 3 anos", "ESAS"),
                Curso("Enfermagem Veterinária", "Licenciatura - 3 anos", "ESAS"),
                Curso("Engenharia do Ambiente", "Licenciatura - 3 anos", "ESAS")
            )
            else -> emptyList()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CursosAdapter(cursos)
    }
}