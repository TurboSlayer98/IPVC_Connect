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

class EmpresasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_empresas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.empresas_activity)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cursoNome = intent.getStringExtra("CURSO_NOME") ?: "Curso"
        findViewById<TextView>(R.id.textView1).text = "Empresas - $cursoNome"

        findViewById<ImageButton>(R.id.button1).setOnClickListener {
            finish()
        }

        // Lista de empresas baseada no curso selecionado
        val empresas = when (cursoNome) {
            "Engenharia Informática" -> listOf(
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

            "Enfermagem" -> listOf(
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
                    nome = "Hospital da Luz Viana",
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

            "Gestão" -> listOf(
                Empresa(
                    nome = "Deloitte",
                    descricao = "Consultoria empresarial",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. da Boavista 1837, 4100-133 Porto",
                    telefone = "225439100",
                    email = "ptrecruitment@deloitte.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                // Continue adicionando mais empresas para cada curso
            )

            "Design de Jogos Digitais" -> listOf(
                Empresa(
                    nome = "Miniclip",
                    descricao = "Desenvolvimento de jogos mobile",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Constituição 345, 4200-199 Porto",
                    telefone = "220123456",
                    email = "jobs@miniclip.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Gamesoft",
                    descricao = "Desenvolvimento de jogos",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua Nova de Santa Cruz 571, 4710-409 Braga",
                    telefone = "253111222",
                    email = "careers@gamesoft.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.5503,
                    longitude = -8.4289
                ),
                Empresa(
                    nome = "Fabamaq",
                    descricao = "Jogos de casino",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua do Heroísmo 333, 4300-096 Porto",
                    telefone = "225898989",
                    email = "hr@fabamaq.com",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1489,
                    longitude = -8.5891
                ),
                Empresa(
                    nome = "Science4you",
                    descricao = "Jogos educativos",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Rua do Quelhas 23, 1200-015 Lisboa",
                    telefone = "213456789",
                    email = "jobs@science4you.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 38.7071,
                    longitude = -9.1526
                ),
                Empresa(
                    nome = "Nerd Monkeys",
                    descricao = "Estúdio indie de jogos",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua das Flores 100, 4050-262 Porto",
                    telefone = "222333444",
                    email = "jobs@nerdmonkeys.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Turismo" -> listOf(
                Empresa(
                    nome = "Hotel Axis Viana",
                    descricao = "Hotelaria",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Av. Cap. Gaspar de Castro, 4900-462 Viana do Castelo",
                    telefone = "258802000",
                    email = "recursos.humanos@axishoteis.com",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Pousada de Viana",
                    descricao = "Hotelaria de luxo",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Monte de Santa Luzia, 4901-909 Viana do Castelo",
                    telefone = "258800370",
                    email = "careers@pousadas.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.7019,
                    longitude = -8.8344
                ),
                Empresa(
                    nome = "FeelViana",
                    descricao = "Resort e spa",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Praia do Cabedelo, 4935-161 Viana do Castelo",
                    telefone = "258333000",
                    email = "jobs@feelviana.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.6789,
                    longitude = -8.8234
                ),
                Empresa(
                    nome = "Agência Abreu",
                    descricao = "Agência de viagens",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. dos Aliados 207, 4000-067 Porto",
                    telefone = "222043570",
                    email = "recursos.humanos@abreu.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1489,
                    longitude = -8.6107
                ),
                Empresa(
                    nome = "TopAtlântico",
                    descricao = "Agência de viagens",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Sá da Bandeira 615, 4000-437 Porto",
                    telefone = "222074630",
                    email = "careers@topatlantico.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1489,
                    longitude = -8.6107
                )
            )

            "Biotecnologia" -> listOf(
                Empresa(
                    nome = "Bial",
                    descricao = "Indústria farmacêutica",
                    localizacao = "Trofa",
                    curso = cursoNome,
                    morada = "À Av. da Siderurgia Nacional, 4745-457 Coronado",
                    telefone = "229866100",
                    email = "rh@bial.com",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.2833,
                    longitude = -8.5833
                ),
                // Continuar com mais empresas...
            )
            // Gestão Artística e Cultural
            "Gestão Artística e Cultural" -> listOf(
                Empresa(
                    nome = "Teatro Municipal Sá de Miranda",
                    descricao = "Teatro municipal",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua Sá de Miranda, 4900-533 Viana do Castelo",
                    telefone = "258809300",
                    email = "teatro@cm-viana-castelo.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Centro Cultural de Viana",
                    descricao = "Centro cultural",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Praça da Liberdade, 4900-040 Viana do Castelo",
                    telefone = "258822377",
                    email = "cultura@cm-viana-castelo.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Fundação Bienal de Arte de Cerveira",
                    descricao = "Fundação cultural",
                    localizacao = "Vila Nova de Cerveira",
                    curso = cursoNome,
                    morada = "Av. das Comunidades Portuguesas, 4920-275 Vila Nova de Cerveira",
                    telefone = "251794633",
                    email = "geral@bienaldecerveira.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.9400,
                    longitude = -8.7450
                ),
                Empresa(
                    nome = "Museu de Artes Decorativas",
                    descricao = "Museu municipal",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Largo de S. Domingos, 4900-330 Viana do Castelo",
                    telefone = "258809305",
                    email = "museu@cm-viana-castelo.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Casa das Artes",
                    descricao = "Centro cultural",
                    localizacao = "Vila Nova de Famalicão",
                    curso = cursoNome,
                    morada = "Av. Dr. Carlos Bacelar, 4760-103 Vila Nova de Famalicão",
                    telefone = "252371297",
                    email = "casadasartes@vilanovadefamalicao.org",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.4118,
                    longitude = -8.5229
                )
            )
            // Organização e Gestão Empresariais
            "Organização e Gestão Empresariais" -> listOf(
                Empresa(
                    nome = "Sonae MC",
                    descricao = "Grupo empresarial",
                    localizacao = "Matosinhos",
                    curso = cursoNome,
                    morada = "Rua João Mendonça 529, 4464-501 Senhora da Hora",
                    telefone = "229561000",
                    email = "careers@sonaemc.com",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1812,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Jerónimo Martins",
                    descricao = "Grupo empresarial",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Rua Actor António Silva 7, 1649-033 Lisboa",
                    telefone = "217532000",
                    email = "recursos.humanos@jeronimo-martins.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "Grupo Amorim",
                    descricao = "Grupo empresarial",
                    localizacao = "Santa Maria da Feira",
                    curso = cursoNome,
                    morada = "Rua de Meladas 380, 4536-902 Mozelos",
                    telefone = "227475400",
                    email = "careers@amorim.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.0054,
                    longitude = -8.5441
                ),
                Empresa(
                    nome = "Grupo RAR",
                    descricao = "Grupo empresarial",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Manuel Pinto de Azevedo 818, 4100-320 Porto",
                    telefone = "226086100",
                    email = "geral@rar.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Grupo Visabeira",
                    descricao = "Grupo empresarial",
                    localizacao = "Viseu",
                    curso = cursoNome,
                    morada = "Rua do Palácio do Gelo 1, 3500-606 Viseu",
                    telefone = "232483000",
                    email = "careers@grupovisabeira.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 40.6566,
                    longitude = -7.9125
                )
            )
            // Informática de Gestão
            "Informática de Gestão" -> listOf(
                Empresa(
                    nome = "Sage Portugal",
                    descricao = "Software de gestão",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Edifício Sage, Rua Eng. Frederico Ulrich 2650, 4470-605 Moreira da Maia",
                    telefone = "221202400",
                    email = "recrutamento@sage.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.2358,
                    longitude = -8.6446
                ),
                Empresa(
                    nome = "PHC Software",
                    descricao = "Software empresarial",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Lagoas Park, Edifício 3, Piso 2, 2740-266 Porto Salvo",
                    telefone = "214724340",
                    email = "careers@phc.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "Quidgest",
                    descricao = "Sistemas de informação",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "R. Castilho 63, 1250-068 Lisboa",
                    telefone = "213870563",
                    email = "recrutamento@quidgest.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "Eticadata",
                    descricao = "Software de gestão",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua Fernando Pessoa 299, 4750-696 Barcelos",
                    telefone = "253200300",
                    email = "careers@eticadata.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.5503,
                    longitude = -8.4289
                ),
                Empresa(
                    nome = "Artsoft",
                    descricao = "Software empresarial",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Rua Carlos Alves 3, 1600-515 Lisboa",
                    telefone = "217107240",
                    email = "rh@artsoft.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.7223,
                    longitude = -9.1393
                )
            )
            // Treino Desportivo
            "Treino Desportivo" -> listOf(
                Empresa(
                    nome = "Sporting Clube de Braga",
                    descricao = "Clube desportivo",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Parque Desportivo SCB, 4710-000 Braga",
                    telefone = "253206860",
                    email = "geral@scbraga.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.5503,
                    longitude = -8.4289
                ),
                Empresa(
                    nome = "Vitória Sport Clube",
                    descricao = "Clube desportivo",
                    localizacao = "Guimarães",
                    curso = cursoNome,
                    morada = "Estádio D. Afonso Henriques, 4810-432 Guimarães",
                    telefone = "253520710",
                    email = "geral@vitoriasc.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.4425,
                    longitude = -8.2966
                ),
                Empresa(
                    nome = "Rio Ave FC",
                    descricao = "Clube desportivo",
                    localizacao = "Vila do Conde",
                    curso = cursoNome,
                    morada = "Rua D. Sancho I, 4480-876 Vila do Conde",
                    telefone = "252640590",
                    email = "geral@rioave-fc.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.3504,
                    longitude = -8.7441
                ),
                Empresa(
                    nome = "Gil Vicente FC",
                    descricao = "Clube desportivo",
                    localizacao = "Barcelos",
                    curso = cursoNome,
                    morada = "Estádio Cidade de Barcelos, 4750-000 Barcelos",
                    telefone = "253081981",
                    email = "geral@gilvicentefc.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.5389,
                    longitude = -8.6155
                ),
                Empresa(
                    nome = "Moreirense FC",
                    descricao = "Clube desportivo",
                    localizacao = "Moreira de Cónegos",
                    curso = cursoNome,
                    morada = "Parque Desportivo Comendador Joaquim de Almeida Freitas, 4815-911 Moreira de Cónegos",
                    telefone = "253582790",
                    email = "geral@moreirensefc.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.3875,
                    longitude = -8.3489
                )
            )
            // Marketing e Comunicação Empresarial
            "Marketing e Comunicação Empresarial" -> listOf(
                Empresa(
                    nome = "Havas Portugal",
                    descricao = "Agência de publicidade",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua José Falcão 151, 4050-317 Porto",
                    telefone = "225322000",
                    email = "careers@havas.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "BBDO Portugal",
                    descricao = "Agência de marketing",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Júlio Dinis 247, 4050-324 Porto",
                    telefone = "226079800",
                    email = "jobs@bbdo.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Ogilvy Portugal",
                    descricao = "Agência de publicidade",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Edifício Adamastor, Av. D. João II 46, 1990-095 Lisboa",
                    telefone = "218925000",
                    email = "careers@ogilvy.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "Fuel Publicidade",
                    descricao = "Agência de marketing digital",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua do Almada 200, 4050-030 Porto",
                    telefone = "220123456",
                    email = "rh@fuel.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1489,
                    longitude = -8.6107
                ),
                Empresa(
                    nome = "Wunderman Thompson",
                    descricao = "Agência de comunicação",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Av. 24 de Julho 62, 1200-869 Lisboa",
                    telefone = "213219200",
                    email = "careers@wundermanthompson.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 38.7071,
                    longitude = -9.1526
                )
            )
            // Agronomia
            "Agronomia" -> listOf(
                Empresa(
                    nome = "Syngenta Portugal",
                    descricao = "Agricultura e biotecnologia",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. D. João II, Torre Fernão de Magalhães, 1990-084 Porto",
                    telefone = "217943200",
                    email = "careers.portugal@syngenta.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Cooperativa Agrícola de Viana",
                    descricao = "Cooperativa agrícola",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Bandeira 344, 4900-561 Viana do Castelo",
                    telefone = "258822288",
                    email = "geral@caviana.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Agros",
                    descricao = "Indústria agrícola",
                    localizacao = "Vila do Conde",
                    curso = cursoNome,
                    morada = "Rua 5 de Outubro 293, 4480-739 Vila do Conde",
                    telefone = "252240220",
                    email = "recursos.humanos@agros.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.3504,
                    longitude = -8.7441
                ),
                Empresa(
                    nome = "Vitacress Portugal",
                    descricao = "Produção agrícola",
                    localizacao = "Odemira",
                    curso = cursoNome,
                    morada = "Avenida República 101, 7630-174 Odemira",
                    telefone = "283320120",
                    email = "careers@vitacress.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 37.5988,
                    longitude = -8.6397
                ),
                Empresa(
                    nome = "Deifil Agro",
                    descricao = "Consultoria agrícola",
                    localizacao = "Ponte de Lima",
                    curso = cursoNome,
                    morada = "Rua Conde de Bertiandos, 4990-078 Ponte de Lima",
                    telefone = "258909100",
                    email = "geral@deifil.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.7667,
                    longitude = -8.5833
                )
            )

            else -> emptyList()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmpresasAdapter(empresas)
    }
}