package com.example.ipvcconnect

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CursosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cursos)

        val escolaNome = intent.getStringExtra("ESCOLA_NOME") ?: "Escola"
        findViewById<TextView>(R.id.textView1).text = "Cursos - $escolaNome"

        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        val cursos = when(escolaNome) {
            "ESTG" -> listOf(
                Curso("Engenharia Informática", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia Informática")
                    }
                },
                Curso("Gestão", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Gestão")
                    }
                },
                Curso("Design de Jogos Digitais", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Design de Jogos Digitais")
                    }
                },
                Curso("Engenharia Civil e do Ambiente", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia Civil e do Ambiente")
                    }
                },
                Curso("Engenharia Alimentar", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia Alimentar")
                    }
                },
                Curso("Engenharia Mecânica", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia Mecânica")
                    }
                },
                Curso("Engenharia da Computação Gráfica e Multimédia", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia da Computação Gráfica e Multimédia")
                    }
                },
                Curso("Engenharia Eletrónica e Redes de Computadores", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia Eletrónica e Redes de Computadores")
                    }
                },
                Curso("Turismo", "Licenciatura - 3 anos", "ESTG").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Turismo")
                    }
                }
            )
            "ESE" -> listOf(
                Curso("Educação Básica", "Licenciatura - 3 anos", "ESE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Educação Básica")
                    }
                },
                Curso("Educação Social Gerontológica", "Licenciatura - 3 anos", "ESE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Educação Social Gerontológica")
                    }
                },
                Curso("Arte e Design", "Licenciatura - 3 anos", "ESE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Arte e Design")
                    }
                },
                Curso("Gestão Artística e Cultural", "Licenciatura - 3 anos", "ESE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Gestão Artística e Cultural")
                    }
                }
            )
            "ESS" -> listOf(
                Curso("Enfermagem", "Licenciatura - 4 anos", "ESS").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Enfermagem")
                    }
                },
                Curso("Biotecnologia", "Licenciatura - 3 anos", "ESS").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Biotecnologia")
                    }
                }
            )
            "ESDL" -> listOf(
                Curso("Desporto e Lazer", "Licenciatura - 3 anos", "ESDL").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Desporto e Lazer")
                    }
                },
                Curso("Treino Desportivo", "Licenciatura - 3 anos", "ESDL").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Treino Desportivo")
                    }
                }
            )
            "ESCE" -> listOf(
                Curso("Contabilidade e Fiscalidade", "Licenciatura - 3 anos", "ESCE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Contabilidade e Fiscalidade")
                    }
                },
                Curso("Marketing e Comunicação Empresarial", "Licenciatura - 3 anos", "ESCE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Marketing e Comunicação Empresarial")
                    }
                },
                Curso("Organização e Gestão Empresariais", "Licenciatura - 3 anos", "ESCE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Organização e Gestão Empresariais")
                    }
                },
                Curso("Informática de Gestão", "Licenciatura - 3 anos", "ESCE").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Informática de Gestão")
                    }
                }
            )
            "ESAS" -> listOf(
                Curso("Agronomia", "Licenciatura - 3 anos", "ESAS").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Agronomia")
                    }
                },
                Curso("Enfermagem Veterinária", "Licenciatura - 3 anos", "ESAS").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Enfermagem Veterinária")
                    }
                },
                Curso("Engenharia do Ambiente", "Licenciatura - 3 anos", "ESAS").apply {
                    intent = Intent(this@CursosActivity, EmpresasActivity::class.java).apply {
                        putExtra("CURSO_NOME", "Engenharia do Ambiente")
                    }
                }
            )
            else -> emptyList()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CursosAdapter(cursos)
    }
}