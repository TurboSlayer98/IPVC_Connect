package com.example.ipvcconnect

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class EmpresasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empresas)

        val cursoNome = intent.getStringExtra("CURSO_NOME") ?: "Curso"
        Log.d("EmpresasActivity", "Curso recebido: $cursoNome")
        findViewById<TextView>(R.id.textView1).text = "Empresas - $cursoNome"

        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Lista de empresas baseada no curso selecionado
        val empresas = when(cursoNome) {
            "Engenharia Informática" -> {
                Log.d("EmpresasActivity", "Encontradas empresas para Engenharia Informática")
                listOf(
                    Empresa(
                        nome = "Critical Software",
                        descricao = "Desenvolvimento de software crítico",
                        localizacao = "Braga",
                        curso = cursoNome,
                        morada = "Rua Padre António Vieira 38, 4715-293 Braga",
                        telefone = "253123456",
                        email = "contact@critical.pt",
                        vagasDisponiveis = 3,
                        vagasOcupadas = 2,
                        latitude = 41.5454,
                        longitude = -8.4265
                    ),
                    Empresa(
                        nome = "Primavera BSS",
                        descricao = "Software de gestão empresarial",
                        localizacao = "Braga",
                        curso = cursoNome,
                        morada = "Rua D. João I 90, 4715-293 Braga",
                        telefone = "253987654",
                        email = "contact@primavera.pt",
                        vagasDisponiveis = 5,
                        vagasOcupadas = 1,
                        latitude = 41.5517,
                        longitude = -8.4229
                    ),
                    Empresa(
                        nome = "Accenture",
                        descricao = "Consultoria e desenvolvimento",
                        localizacao = "Porto",
                        curso = cursoNome,
                        morada = "Av. da Boavista 1837, 4100-133 Porto",
                        telefone = "220123456",
                        email = "careers@accenture.pt",
                        vagasDisponiveis = 4,
                        vagasOcupadas = 3,
                        latitude = 41.1579,
                        longitude = -8.6291
                    ),
                    Empresa(
                        nome = "Farfetch",
                        descricao = "Plataforma de moda de luxo",
                        localizacao = "Braga",
                        curso = cursoNome,
                        morada = "Rua do Carmo 78, 4700-309 Braga",
                        telefone = "253456789",
                        email = "jobs@farfetch.com",
                        vagasDisponiveis = 2,
                        vagasOcupadas = 4,
                        latitude = 41.5503,
                        longitude = -8.4289
                    ),
                    Empresa(
                        nome = "Bosch",
                        descricao = "Tecnologia e inovação",
                        localizacao = "Braga",
                        curso = cursoNome,
                        morada = "Rua Max Grundig 35, 4705-820 Braga",
                        telefone = "253789123",
                        email = "careers@bosch.pt",
                        vagasDisponiveis = 6,
                        vagasOcupadas = 2,
                        latitude = 41.5612,
                        longitude = -8.4321
                    )
                )
            }

            "Enfermagem" -> {
                Log.d("EmpresasActivity", "Encontradas empresas para Enfermagem")
                listOf(
                    Empresa(
                        nome = "Hospital de Viana",
                        descricao = "Hospital público",
                        localizacao = "Viana do Castelo",
                        curso = cursoNome,
                        morada = "Estrada de Santa Luzia, 4901-858 Viana do Castelo",
                        telefone = "258802100",
                        email = "recursos.humanos@ulsam.min-saude.pt",
                        vagasDisponiveis = 4,
                        vagasOcupadas = 2,
                        latitude = 41.7019,
                        longitude = -8.8344
                    ),
                    Empresa(
                        nome = "Hospital CUF Porto",
                        descricao = "Hospital privado",
                        localizacao = "Porto",
                        curso = cursoNome,
                        morada = "Estrada da Circunvalação 14341, 4100-180 Porto",
                        telefone = "220039000",
                        email = "careers@cuf.pt",
                        vagasDisponiveis = 3,
                        vagasOcupadas = 3,
                        latitude = 41.1812,
                        longitude = -8.6291
                    ),
                    Empresa(
                        nome = "Hospital de Braga",
                        descricao = "Hospital público",
                        localizacao = "Braga",
                        curso = cursoNome,
                        morada = "Sete Fontes, 4710-243 Braga",
                        telefone = "253027000",
                        email = "recursos.humanos@hb.min-saude.pt",
                        vagasDisponiveis = 5,
                        vagasOcupadas = 1,
                        latitude = 41.5647,
                        longitude = -8.4018
                    ),
                    Empresa(
                        nome = "Hospital Lusíadas Porto",
                        descricao = "Hospital privado",
                        localizacao = "Porto",
                        curso = cursoNome,
                        morada = "Rua Calouste Gulbenkian 171, 4050-145 Porto",
                        telefone = "220911000",
                        email = "careers@lusiadas.pt",
                        vagasDisponiveis = 2,
                        vagasOcupadas = 4,
                        latitude = 41.1579,
                        longitude = -8.6291
                    ),
                    Empresa(
                        nome = "Hospital da Luz",
                        descricao = "Hospital privado",
                        localizacao = "Viana do Castelo",
                        curso = cursoNome,
                        morada = "Rua Conde de Aurora 50, 4900-430 Viana do Castelo",
                        telefone = "258009000",
                        email = "careers@hospitaldaluz.pt",
                        vagasDisponiveis = 3,
                        vagasOcupadas = 2,
                        latitude = 41.6946,
                        longitude = -8.8362
                    )
                )
            }

            // Continuar com outros cursos...

            else -> {
                Log.d("EmpresasActivity", "Nenhuma empresa encontrada para o curso: $cursoNome")
                emptyList()
            }
        }

        Log.d("EmpresasActivity", "Número de empresas encontradas: ${empresas.size}")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmpresasAdapter(empresas)
    }
}