package com.example.ipvcconnect

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EscolasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolas)

        // Botão de voltar
        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Lista de escolas
        val escolas = listOf(
            Escola(
                "ESTG",
                "Escola Superior de Tecnologia e Gestão",
                R.mipmap.estg_logo_foreground
            ),
            Escola(
                "ESE",
                "Escola Superior de Educação",
                R.mipmap.ese_logo
            ),
            Escola(
                "ESS",
                "Escola Superior de Saúde",
                R.mipmap.ess_logo
            ),
            Escola(
                "ESDL",
                "Escola Superior de Desporto e Lazer",
                R.mipmap.esdl_logo
            ),
            Escola(
                "ESCE",
                "Escola Superior de Ciências Empresariais",
                R.mipmap.esce_logo
            ),
            Escola(
                "ESAS",
                "Escola Superior Agrária",
                R.mipmap.estg_logo_foreground
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.adapter = EscolasAdapter(escolas)
    }
}