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
                        site = "https://www.criticalsoftware.com",
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
                        telefone = "253309900",
                        email = "careers@primaverabss.com",
                        site = "https://www.primaverabss.com",
                        vagasDisponiveis = 5,
                        vagasOcupadas = 0,
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
                        site = "https://www.accenture.com",
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
                        site = "https://www.farfetch.com",
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
                        site = "https://www.bosch.com",
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
                        site = "http://www.ulsam.min-saude.pt",
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
                        site = "https://www.cuf.pt",
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
                        site = "https://www.hospitaldebraga.pt",
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
                        site = "https://www.lusiadas.pt",
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
                        site = "https://www.hospitaldaluz.pt",
                        vagasDisponiveis = 3,
                        vagasOcupadas = 2,
                        latitude = 41.6946,
                        longitude = -8.8362
                    )
                )
            }

            "Engenharia da Computação Gráfica e Multimédia" -> listOf(
                Empresa(
                    nome = "Blizzard",
                    descricao = "Desenvolvimento de jogos",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Lionesa 446, 4465-671 Leça do Balio",
                    telefone = "229969700",
                    email = "careers@blizzard.com",
                    vagasDisponiveis = 4,
                    site = "https://www.blizzard.com",
                    vagasOcupadas = 1,
                    latitude = 41.2000,
                    longitude = -8.6333
                ),
                Empresa(
                    nome = "Pixelmatters",
                    descricao = "Design e desenvolvimento digital",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Sá da Bandeira 651, 4000-437 Porto",
                    telefone = "220101510",
                    email = "hello@pixelmatters.com",
                    site = "www.pixelmatters.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1489,
                    longitude = -8.6107
                ),
                Empresa(
                    nome = "Fabamaq",
                    descricao = "Desenvolvimento de jogos",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua do Heroísmo 333, 4300-096 Porto",
                    telefone = "225898989",
                    email = "hr@fabamaq.com",
                    site = "www.fabamaq.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.1489,
                    longitude = -8.5891
                ),
                Empresa(
                    nome = "Sword Health",
                    descricao = "Tecnologia de saúde digital",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Sá da Bandeira 651, 4000-437 Porto",
                    telefone = "220107510",
                    email = "careers@swordhealth.com",
                    site = "www.swordhealth.com",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1489,
                    longitude = -8.6107
                ),
                Empresa(
                    nome = "Xpand IT",
                    descricao = "Consultoria tecnológica",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua do Rosário 174, 4050-521 Porto",
                    telefone = "222073910",
                    email = "recruitment@xpand-it.com",
                    site = "www.xpand-it.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1489,
                    longitude = -8.6107
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
                    site = "www.axishoteis.com",
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
                    site = "www.pousadas.pt",
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
                    site = "www.feelviana.com",
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
                    site = "www.abreu.pt",
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
                    site = "www.topatlantico.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1489,
                    longitude = -8.6107
                )
            )

            "Educação Básica" -> listOf(
                Empresa(
                    nome = "Escola Básica António Feijó",
                    descricao = "Escola pública de ensino básico",
                    localizacao = "Ponte de Lima",
                    curso = cursoNome,
                    morada = "Rua Agostinho José Taveira, 4990-072 Ponte de Lima",
                    telefone = "258909070",
                    email = "secretaria@aeaf.edu.pt",
                    site = "www.aeaf.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.7667,
                    longitude = -8.5833
                ),
                Empresa(
                    nome = "Colégio do Minho",
                    descricao = "Escola privada",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Av. dos Combatentes, 4900-563 Viana do Castelo",
                    telefone = "258800010",
                    email = "geral@colegiominho.pt",
                    site = "www.colegiominho.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Centro Escolar da Meadela",
                    descricao = "Escola básica pública",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Veiga, 4900-343 Viana do Castelo",
                    telefone = "258839160",
                    email = "ce.meadela@gmail.com",
                    site = "www.meadela.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.7019,
                    longitude = -8.8344
                ),
                Empresa(
                    nome = "Agrupamento de Escolas da Abelheira",
                    descricao = "Agrupamento escolar público",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua José Augusto Vieira, 4900-444 Viana do Castelo",
                    telefone = "258809770",
                    email = "secretaria@aeabelheira.edu.pt",
                    site = "www.aeabelheira.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Escola Básica Frei Bartolomeu dos Mártires",
                    descricao = "Escola básica pública",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua Martim Velho, 4900-452 Viana do Castelo",
                    telefone = "258800020",
                    email = "direcao@aefbm.edu.pt",
                    site = "www.aefbm.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                )
            )

            "Marketing e Comunicação Empresarial" -> listOf(
                Empresa(
                    nome = "Havas Portugal",
                    descricao = "Agência de publicidade",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua José Falcão 151, 4050-317 Porto",
                    telefone = "225322000",
                    email = "careers@havas.pt",
                    site = "www.havas.pt",
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
                    site = "www.bbdo.pt",
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
                    site = "www.ogilvy.pt",
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
                    site = "www.fuel.pt",
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
                    site = "www.wundermanthompson.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 38.7071,
                    longitude = -9.1526
                )
            )

            "Contabilidade e Fiscalidade" -> listOf(
                Empresa(
                    nome = "PwC Portugal",
                    descricao = "Auditoria e consultoria fiscal",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida da Boavista 3523, 4100-139 Porto",
                    telefone = "225433000",
                    email = "recrutamento@pwc.com",
                    site = "www.pwc.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "KPMG Portugal",
                    descricao = "Auditoria e consultoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Edifício Burgo, Avenida da Boavista 1837, 4100-133 Porto",
                    telefone = "220102300",
                    email = "careers@kpmg.pt",
                    site = "www.kpmg.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "EY Portugal",
                    descricao = "Auditoria e consultoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida da Boavista 36, 4050-112 Porto",
                    telefone = "226079500",
                    email = "careers@pt.ey.com",
                    site = "www.ey.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "BDO Portugal",
                    descricao = "Auditoria e consultoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua S. João de Brito 605 E, 4100-455 Porto",
                    telefone = "226166140",
                    email = "recrutamento@bdo.pt",
                    site = "www.bdo.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Grant Thornton Portugal",
                    descricao = "Auditoria e consultoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida da Boavista 1361, 4100-130 Porto",
                    telefone = "226002700",
                    email = "careers@pt.gt.com",
                    site = "www.gt.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Engenharia Eletrónica e Redes de Computadores" -> listOf(
                Empresa(
                    nome = "Altice Labs",
                    descricao = "Telecomunicações e redes",
                    localizacao = "Aveiro",
                    curso = cursoNome,
                    morada = "Rua Eng. José Ferreira Pinto Basto, 3810-106 Aveiro",
                    telefone = "234403200",
                    email = "contact@alticelabs.com",
                    site = "www.alticelabs.com",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 40.6333,
                    longitude = -8.6500
                ),
                Empresa(
                    nome = "Cisco Portugal",
                    descricao = "Redes e telecomunicações",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. Dom João II, 1990-084 Lisboa",
                    telefone = "214124000",
                    email = "careers@cisco.pt",
                    site = "www.cisco.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Nokia Solutions",
                    descricao = "Telecomunicações",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Av. do Forte 6, 2790-072 Carnaxide",
                    telefone = "214251000",
                    email = "recruitment.portugal@nokia.com",
                    site = "www.nokia.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "Huawei Portugal",
                    descricao = "Tecnologia e telecomunicações",
                    localizacao = "Lisboa",
                    curso = cursoNome,
                    morada = "Av. Dom João II 51B, 1990-085 Lisboa",
                    telefone = "214124100",
                    email = "recruitment.pt@huawei.com",
                    site = "www.huawei.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "NOS",
                    descricao = "Telecomunicações",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Ator António Silva 9, 1600-404 Lisboa",
                    telefone = "217824700",
                    email = "recrutamento@nos.pt",
                    site = "www.nos.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Informática de Gestão" -> listOf(
                Empresa(
                    nome = "Sage Portugal",
                    descricao = "Software de gestão",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Edifício Sage, Rua Eng. Frederico Ulrich 2650, 4470-605 Moreira da Maia",
                    telefone = "221202400",
                    email = "recrutamento@sage.pt",
                    site = "www.sage.pt",
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
                    site = "www.phc.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.7223,
                    longitude = -9.1393
                ),
                Empresa(
                    nome = "Primavera BSS",
                    descricao = "Software de gestão",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua D. João I 90, 4715-293 Braga",
                    telefone = "253309900",
                    email = "careers@primaverabss.com",
                    site = "www.primaverabss.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.5503,
                    longitude = -8.4289
                ),
                Empresa(
                    nome = "Eticadata",
                    descricao = "Software de gestão",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua Fernando Pessoa 299, 4750-696 Barcelos",
                    telefone = "253200300",
                    email = "careers@eticadata.pt",
                    site = "www.eticadata.pt",
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
                    site = "www.artsoft.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.7223,
                    longitude = -9.1393
                )
            )

            "Gestão Artística e Cultural" -> listOf(
                Empresa(
                    nome = "Casa da Música",
                    descricao = "Centro cultural e musical",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. da Boavista 604-610, 4149-071 Porto",
                    telefone = "220120220",
                    email = "rh@casadamusica.com",
                    site = "www.casadamusica.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Fundação de Serralves",
                    descricao = "Museu de arte contemporânea",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua D. João de Castro 210, 4150-417 Porto",
                    telefone = "226156500",
                    email = "recursos.humanos@serralves.pt",
                    site = "www.serralves.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Teatro Municipal Sá de Miranda",
                    descricao = "Teatro municipal",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua Sá de Miranda, 4900-533 Viana do Castelo",
                    telefone = "258809300",
                    email = "teatro@cm-viana-castelo.pt",
                    site = "www.cmviana.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
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
                    site = "www.cmviana.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
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
                    site = "www.bienal.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.9400,
                    longitude = -8.7450
                )
            )

            "Enfermagem Veterinária" -> listOf(
                Empresa(
                    nome = "Hospital Veterinário de Viana",
                    descricao = "Hospital veterinário",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Bandeira 168, 4900-514 Viana do Castelo",
                    telefone = "258822456",
                    email = "geral@hvviana.pt",
                    site = "www.hvviana.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Clínica Veterinária do Lima",
                    descricao = "Clínica veterinária",
                    localizacao = "Ponte de Lima",
                    curso = cursoNome,
                    morada = "Rua Conde de Bertiandos, 4990-078 Ponte de Lima",
                    telefone = "258941234",
                    email = "info@vetlima.pt",
                    site = "www.vetlima.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.7667,
                    longitude = -8.5833
                ),
                Empresa(
                    nome = "Centro Veterinário de Barcelos",
                    descricao = "Centro veterinário",
                    localizacao = "Barcelos",
                    curso = cursoNome,
                    morada = "Avenida dos Combatentes, 4750-279 Barcelos",
                    telefone = "253812345",
                    email = "geral@vetbarcelos.pt",
                    site = "www.vetbarcelos.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.5389,
                    longitude = -8.6155
                ),
                Empresa(
                    nome = "OneVet Group",
                    descricao = "Grupo hospitalar veterinário",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Augusto Lessa 45, 4200-098 Porto",
                    telefone = "225024600",
                    email = "careers@onevetgroup.pt",
                    site = "www.onevetgroup.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "VetNorte",
                    descricao = "Hospital veterinário",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua Nova de Santa Cruz 135, 4710-409 Braga",
                    telefone = "253123987",
                    email = "rh@vetnorte.pt",
                    site = "www.vetnorte.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.5503,
                    longitude = -8.4289
                )
            )

            "Treino Desportivo" -> listOf(
                Empresa(
                    nome = "Sporting Clube de Braga",
                    descricao = "Clube desportivo",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Parque Desportivo SCB, 4710-000 Braga",
                    telefone = "253206860",
                    email = "geral@scbraga.pt",
                    site = "www.scbraga.pt",
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
                    site = "www.vitoriasc.pt",
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
                    site = "www.rioavefc.pt",
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
                    site = "www.gilvicentefc.pt",
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
                    site = "www.moreirensefc.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.3875,
                    longitude = -8.3489
                )
            )

            "Organização e Gestão Empresariais" -> listOf(
                Empresa(
                    nome = "Sonae MC",
                    descricao = "Grupo empresarial",
                    localizacao = "Matosinhos",
                    curso = cursoNome,
                    morada = "Rua João Mendonça 529, 4464-501 Senhora da Hora",
                    telefone = "229561000",
                    email = "careers@sonaemc.com",
                    site = "www.sonaemc.com",
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
                    site = "www.jeromarmartins.pt",
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
                    site = "www.amorim.pt",
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
                    site = "www.rar.pt",
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
                    site = "www.grupovisabeira.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 40.6566,
                    longitude = -7.9125
                )
            )

            "Ambiente" -> listOf(
                Empresa(
                    nome = "Águas do Norte",
                    descricao = "Gestão de águas e resíduos",
                    localizacao = "Vila Real",
                    curso = cursoNome,
                    morada = "Rua Dom Pedro de Castro 1A, 5000-669 Vila Real",
                    telefone = "259309370",
                    email = "geral@adnorte.pt",
                    site = "www.aguasdonorte.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.3002,
                    longitude = -7.7398
                ),
                Empresa(
                    nome = "LIPOR",
                    descricao = "Gestão de resíduos",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Morena 805, 4435-996 Baguim do Monte",
                    telefone = "229770100",
                    email = "recursos.humanos@lipor.pt",
                    site = "www.lipor.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1891,
                    longitude = -8.5505
                ),
                Empresa(
                    nome = "Resulima",
                    descricao = "Tratamento de resíduos",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Aterro Sanitário do Vale do Lima e Baixo Cávado, 4935-604 Vila Fria",
                    telefone = "258240130",
                    email = "geral@resulima.pt",
                    site = "www.resulima.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "EDP Renováveis",
                    descricao = "Energia renovável",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida 24 de Julho 12A, 1249-300 Porto",
                    telefone = "210012500",
                    email = "careers@edpr.com",
                    site = "www.edpr.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Agência Portuguesa do Ambiente",
                    descricao = "Entidade governamental",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Murgueira 9, 2610-124 Porto",
                    telefone = "214728200",
                    email = "geral@apambiente.pt",
                    site = "www.apambiente.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Agronomia" -> listOf(
                Empresa(
                    nome = "Cooperativa Agrícola de Viana",
                    descricao = "Cooperativa agrícola",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Bandeira 344, 4900-561 Viana do Castelo",
                    telefone = "258822288",
                    email = "geral@caviana.pt",
                    site = "https://www.caviana.pt",
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
                    site = "https://www.agros.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.3504,
                    longitude = -8.7441
                ),
                Empresa(
                    nome = "Syngenta Portugal",
                    descricao = "Agricultura e biotecnologia",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. D. João II, Torre Fernão de Magalhães, 1990-084 Porto",
                    telefone = "217943200",
                    email = "careers.portugal@syngenta.com",
                    site = "https://www.syngenta.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Vitacress Portugal",
                    descricao = "Produção agrícola",
                    localizacao = "Odemira",
                    curso = cursoNome,
                    morada = "Avenida República 101, 7630-174 Odemira",
                    telefone = "283320120",
                    email = "careers@vitacress.pt",
                    site = "https://www.vitacress.pt",
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
                    site = "https://www.deifil.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.7667,
                    longitude = -8.5833
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
                    site = "https://www.bial.com/pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.2833,
                    longitude = -8.5833
                ),
                Empresa(
                    nome = "Hovione",
                    descricao = "Indústria farmacêutica",
                    localizacao = "Loures",
                    curso = cursoNome,
                    morada = "Sete Casas, 2674-506 Loures",
                    telefone = "219847000",
                    email = "careers@hovione.com",
                    site = "https://www.hovione.com",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.8283,
                    longitude = -9.1747
                ),
                Empresa(
                    nome = "Bluepharma",
                    descricao = "Indústria farmacêutica",
                    localizacao = "Coimbra",
                    curso = cursoNome,
                    morada = "São Martinho do Bispo, 3045-016 Coimbra",
                    telefone = "239800300",
                    email = "rh@bluepharma.pt",
                    site = "https://www.bluepharma.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 40.2033,
                    longitude = -8.4103
                ),
                Empresa(
                    nome = "Tecnimede",
                    descricao = "Indústria farmacêutica",
                    localizacao = "Sintra",
                    curso = cursoNome,
                    morada = "Rua da Tapada Grande 2, 2710-089 Sintra",
                    telefone = "219488200",
                    email = "careers@tecnimede.pt",
                    site = "https://www.tecnimede.com",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 38.7971,
                    longitude = -9.3877
                ),
                Empresa(
                    nome = "Laboratórios Vitória",
                    descricao = "Indústria farmacêutica",
                    localizacao = "Amadora",
                    curso = cursoNome,
                    morada = "Rua Elias Garcia 28, 2700-327 Amadora",
                    telefone = "214985900",
                    email = "rh@labvitoria.pt",
                    site = "https://www.labvitoria.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.7523,
                    longitude = -9.2312
                )
            )

            "Desporto e Lazer" -> listOf(
                Empresa(
                    nome = "Sport Club Vianense",
                    descricao = "Clube desportivo",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Estádio Dr. José de Matos, 4900-347 Viana do Castelo",
                    telefone = "258822497",
                    email = "geral@scvianense.pt",
                    site = "http://www.scvianense.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Ginásio Solinca",
                    descricao = "Centro de fitness",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Estrada da Papanata, 4900-470 Viana do Castelo",
                    telefone = "258800300",
                    email = "careers@solinca.pt",
                    site = "https://www.solinca.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Piscina Municipal",
                    descricao = "Centro aquático",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Avenida do Atlântico, 4900-348 Viana do Castelo",
                    telefone = "258320330",
                    email = "desporto@cm-viana-castelo.pt",
                    site = "http://www.cm-viana-castelo.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Surf Club Viana",
                    descricao = "Escola de surf",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Praia do Cabedelo, 4935-161 Viana do Castelo",
                    telefone = "258321456",
                    email = "info@surfclubviana.pt",
                    site = "http://www.surfclubviana.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.6789,
                    longitude = -8.8234
                ),
                Empresa(
                    nome = "Academia de Ténis",
                    descricao = "Escola de ténis",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua Sporting Club, 4900-348 Viana do Castelo",
                    telefone = "258789123",
                    email = "tennis@viana.pt",
                    site = "http://www.tenisviana.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.6946,
                    longitude = -8.8362
                )
            )

            "Educação Social Gerontológica" -> listOf(
                Empresa(
                    nome = "Santa Casa da Misericórdia de Viana",
                    descricao = "Instituição de solidariedade social",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Bandeira 54, 4900-514 Viana do Castelo",
                    telefone = "258822177",
                    email = "geral@scmviana.pt",
                    site = "https://www.scmviana.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Centro Social e Paroquial de Vila Nova de Anha",
                    descricao = "Centro social e paroquial",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Igreja, 4935-347 Vila Nova de Anha",
                    telefone = "258322153",
                    email = "geral@cspvnanha.pt",
                    site = "http://www.cspvnanha.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.6500,
                    longitude = -8.8000
                ),
                Empresa(
                    nome = "Centro Social da Paróquia de Areosa",
                    descricao = "Centro social",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Igreja, 4900-878 Areosa",
                    telefone = "258835125",
                    email = "geral@csareosa.pt",
                    site = "http://www.csareosa.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.7052,
                    longitude = -8.8520
                ),
                Empresa(
                    nome = "Lar de São José",
                    descricao = "Lar de idosos",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua de São José, 4900-012 Viana do Castelo",
                    telefone = "258822345",
                    email = "geral@larsaojose.pt",
                    site = "http://www.larsaojose.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Centro Social e Cultural de Vila Praia de Âncora",
                    descricao = "Centro social",
                    localizacao = "Vila Praia de Âncora",
                    curso = cursoNome,
                    morada = "Rua 5 de Outubro, 4910-456 Vila Praia de Âncora",
                    telefone = "258911789",
                    email = "geral@csccvpa.pt",
                    site = "http://www.csccvpa.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.8186,
                    longitude = -8.8586
                )
            )

            "Arte e Design" -> listOf(
                Empresa(
                    nome = "Galeria Zet",
                    descricao = "Galeria de arte",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua Manuel Espregueira 140, 4900-318 Viana do Castelo",
                    telefone = "258822111",
                    email = "info@galeriazet.pt",
                    site = "http://www.galeriazet.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Atelier Design Factory",
                    descricao = "Estúdio de design",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua do Raio 300, 4710-922 Braga",
                    telefone = "253123789",
                    email = "jobs@designfactory.pt",
                    site = "https://www.designfactory.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.5503,
                    longitude = -8.4289
                ),
                Empresa(
                    nome = "Creative Hub Porto",
                    descricao = "Espaço criativo",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua das Flores 150, 4050-262 Porto",
                    telefone = "220123789",
                    email = "info@creativehub.pt",
                    site = "https://www.creativehub.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Fundação de Serralves",
                    descricao = "Museu de arte contemporânea",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua D. João de Castro 210, 4150-417 Porto",
                    telefone = "226156500",
                    email = "recursos.humanos@serralves.pt",
                    site = "https://www.serralves.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Casa das Artes",
                    descricao = "Centro cultural",
                    localizacao = "Vila Nova de Famalicão",
                    curso = cursoNome,
                    morada = "Av. Dr. Carlos Bacelar, 4760-103 Vila Nova de Famalicão",
                    telefone = "252371297",
                    email = "casadasartes@vilanovadefamalicao.org",
                    site = "https://www.casadasartes.org",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.4118,
                    longitude = -8.5229
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
                    site = "https://www.deloitte.com/pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "PWC",
                    descricao = "Auditoria e consultoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida Fontes Pereira de Melo 16, 4000-123 Porto",
                    telefone = "225433000",
                    email = "recrutamento@pwc.com",
                    site = "https://www.pwc.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "KPMG",
                    descricao = "Serviços profissionais",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Edifício Burgo, Avenida da Boavista 1837, 4100-133 Porto",
                    telefone = "220102300",
                    email = "careers@kpmg.pt",
                    site = "https://www.kpmg.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "EY",
                    descricao = "Consultoria e auditoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida da Boavista 36, 4050-112 Porto",
                    telefone = "226079500",
                    email = "careers@pt.ey.com",
                    site = "https://www.ey.com/pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "BDO",
                    descricao = "Auditoria e consultoria",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua S. João de Brito 605 E, 4100-455 Porto",
                    telefone = "226166140",
                    email = "recrutamento@bdo.pt",
                    site = "https://www.bdo.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
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
                    site = "https://www.miniclip.com",
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
                    site = "https://www.gamesoft.pt",
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
                    site = "https://www.fabamaq.com",
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
                    site = "https://www.science4you.pt",
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
                    site = "https://www.nerdmonkeys.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Engenharia Civil e do Ambiente" -> listOf(
                Empresa(
                    nome = "Mota-Engil",
                    descricao = "Construção civil e obras públicas",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua do Rego Lameiro 38, 4300-454 Porto",
                    telefone = "225190300",
                    email = "careers@mota-engil.pt",
                    site = "https://www.mota-engil.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1494,
                    longitude = -8.5913
                ),
                Empresa(
                    nome = "Teixeira Duarte",
                    descricao = "Construção e engenharia",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Av. da Boavista 1588, 4100-115 Porto",
                    telefone = "226166570",
                    email = "rh@teixeiraduarte.pt",
                    site = "https://www.teixeiraduarte.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "DST Group",
                    descricao = "Construção e ambiente",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua de Pitancinhos, 4700-727 Braga",
                    telefone = "253307200",
                    email = "careers@dstsgps.com",
                    site = "https://www.dstsgps.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.5454,
                    longitude = -8.4265
                ),
                Empresa(
                    nome = "Casais",
                    descricao = "Construção civil",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua do Anjo 27, 4700-305 Braga",
                    telefone = "253605140",
                    email = "rh@casais.pt",
                    site = "https://www.casais.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.5503,
                    longitude = -8.4289
                ),
                Empresa(
                    nome = "Somague",
                    descricao = "Engenharia e construção",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Constituição 657, 4200-201 Porto",
                    telefone = "225574700",
                    email = "careers@somague.pt",
                    site = "https://www.somague.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Engenharia Alimentar" -> listOf(
                Empresa(
                    nome = "Nestlé Portugal",
                    descricao = "Indústria alimentar",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua Alexandre Herculano 8, 2799-554 Linda-a-Velha",
                    telefone = "214147500",
                    email = "careers@pt.nestle.com",
                    site = "https://www.nestle.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Lactogal",
                    descricao = "Indústria de laticínios",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua do Freixo 1169, 4300-219 Porto",
                    telefone = "225391700",
                    email = "rh@lactogal.pt",
                    site = "https://www.lactogal.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1489,
                    longitude = -8.5891
                ),
                Empresa(
                    nome = "Unicer",
                    descricao = "Indústria de bebidas",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Via Norte, 4465-764 Leça do Balio",
                    telefone = "229052100",
                    email = "recursos.humanos@unicer.pt",
                    site = "https://www.superbock-group.com",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.2000,
                    longitude = -8.6333
                ),
                Empresa(
                    nome = "Frulact",
                    descricao = "Indústria alimentar",
                    localizacao = "Maia",
                    curso = cursoNome,
                    morada = "Rua do Outeiro 589, 4475-150 Gemunde",
                    telefone = "229749200",
                    email = "careers@frulact.pt",
                    site = "https://www.frulact.com",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.2500,
                    longitude = -8.6167
                ),
                Empresa(
                    nome = "Sumol+Compal",
                    descricao = "Indústria de bebidas",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Estrada Nacional 250, 2665-191 Carnaxide",
                    telefone = "214241600",
                    email = "recrutamento@sumolcompal.pt",
                    site = "https://www.sumolcompal.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Engenharia Mecânica" -> listOf(
                Empresa(
                    nome = "Salvador Caetano",
                    descricao = "Indústria automóvel",
                    localizacao = "Vila Nova de Gaia",
                    curso = cursoNome,
                    morada = "Av. Vasco da Gama 1410, 4431-956 Vila Nova de Gaia",
                    telefone = "227867000",
                    email = "rh@salvadorcaetano.pt",
                    site = "https://www.salvadorcaetano.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.1333,
                    longitude = -8.6167
                ),
                Empresa(
                    nome = "Continental Mabor",
                    descricao = "Indústria de pneus",
                    localizacao = "Vila Nova de Famalicão",
                    curso = cursoNome,
                    morada = "Rua Adelino Leitão 330, 4760-652 Lousado",
                    telefone = "252499100",
                    email = "careers@conti.de",
                    site = "https://www.conti.de",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.3500,
                    longitude = -8.5333
                ),
                Empresa(
                    nome = "Efacec",
                    descricao = "Energia e transportes",
                    localizacao = "Matosinhos",
                    curso = cursoNome,
                    morada = "Via Eng Belmiro Mendes de Azevedo, 4470-605 Matosinhos",
                    telefone = "229403100",
                    email = "hr@efacec.com",
                    site = "https://www.efacec.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.2000,
                    longitude = -8.6833
                ),
                Empresa(
                    nome = "Bosch Car Multimedia",
                    descricao = "Sistemas automotivos",
                    localizacao = "Braga",
                    curso = cursoNome,
                    morada = "Rua Max Grundig 35, 4705-820 Braga",
                    telefone = "253606100",
                    email = "careers.braga@bosch.com",
                    site = "https://www.bosch.com/pt/pt/",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.5612,
                    longitude = -8.4321
                ),
                Empresa(
                    nome = "Volkswagen Autoeuropa",
                    descricao = "Indústria automóvel",
                    localizacao = "Palmela",
                    curso = cursoNome,
                    morada = "Quinta da Marquesa, 2954-024 Palmela",
                    telefone = "212123000",
                    email = "recursos.humanos@volkswagen.pt",
                    site = "https://www.volkswagen.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 38.5833,
                    longitude = -8.9000
                )
            )

            "Engenharia do Ambiente" -> listOf(
                Empresa(
                    nome = "Águas do Norte",
                    descricao = "Gestão de águas e resíduos",
                    localizacao = "Vila Real",
                    curso = cursoNome,
                    morada = "Rua Dom Pedro de Castro 1A, 5000-669 Vila Real",
                    telefone = "259309370",
                    email = "geral@adnorte.pt",
                    site = "https://www.aguasdonorte.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.3002,
                    longitude = -7.7398
                ),
                Empresa(
                    nome = "LIPOR",
                    descricao = "Gestão de resíduos",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Morena 805, 4435-996 Baguim do Monte",
                    telefone = "229770100",
                    email = "recursos.humanos@lipor.pt",
                    site = "https://www.lipor.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1891,
                    longitude = -8.5505
                ),
                Empresa(
                    nome = "Resulima",
                    descricao = "Tratamento de resíduos",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Aterro Sanitário do Vale do Lima e Baixo Cávado, 4935-604 Vila Fria",
                    telefone = "258240130",
                    email = "geral@resulima.pt",
                    site = "https://www.resulima.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "EDP Renováveis",
                    descricao = "Energia renovável",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Avenida 24 de Julho 12A, 1249-300 Porto",
                    telefone = "210012500",
                    email = "careers@edpr.com",
                    site = "https://www.edprenovaveis.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.1579,
                    longitude = -8.6291
                ),
                Empresa(
                    nome = "Agência Portuguesa do Ambiente",
                    descricao = "Entidade governamental",
                    localizacao = "Porto",
                    curso = cursoNome,
                    morada = "Rua da Murgueira 9, 2610-124 Porto",
                    telefone = "214728200",
                    email = "geral@apambiente.pt",
                    site = "https://www.apambiente.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.1579,
                    longitude = -8.6291
                )
            )

            "Educação Social Gerontológica" -> listOf(
                Empresa(
                    nome = "Santa Casa da Misericórdia de Viana",
                    descricao = "Instituição de solidariedade social",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Bandeira 54, 4900-514 Viana do Castelo",
                    telefone = "258822177",
                    email = "geral@scmviana.pt",
                    site = "https://www.scmviana.pt",
                    vagasDisponiveis = 4,
                    vagasOcupadas = 1,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Centro Social e Paroquial de Vila Nova de Anha",
                    descricao = "Centro social e paroquial",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Igreja, 4935-347 Vila Nova de Anha",
                    telefone = "258322153",
                    email = "geral@cspvnanha.pt",
                    site = "http://www.cspvnanha.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.6500,
                    longitude = -8.8000
                ),
                Empresa(
                    nome = "Centro Social da Paróquia de Areosa",
                    descricao = "Centro social",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua da Igreja, 4900-878 Areosa",
                    telefone = "258835125",
                    email = "geral@csareosa.pt",
                    site = "http://www.csareosa.pt",
                    vagasDisponiveis = 5,
                    vagasOcupadas = 0,
                    latitude = 41.7052,
                    longitude = -8.8520
                ),
                Empresa(
                    nome = "Lar de São José",
                    descricao = "Lar de idosos",
                    localizacao = "Viana do Castelo",
                    curso = cursoNome,
                    morada = "Rua de São José, 4900-012 Viana do Castelo",
                    telefone = "258822345",
                    email = "geral@larsaojose.pt",
                    site = "http://www.larsaojose.pt",
                    vagasDisponiveis = 2,
                    vagasOcupadas = 3,
                    latitude = 41.6946,
                    longitude = -8.8362
                ),
                Empresa(
                    nome = "Centro Social e Cultural de Vila Praia de Âncora",
                    descricao = "Centro social",
                    localizacao = "Vila Praia de Âncora",
                    curso = cursoNome,
                    morada = "Rua 5 de Outubro, 4910-456 Vila Praia de Âncora",
                    telefone = "258911789",
                    email = "geral@csccvpa.pt",
                    site = "http://www.csccvpa.pt",
                    vagasDisponiveis = 3,
                    vagasOcupadas = 2,
                    latitude = 41.8186,
                    longitude = -8.8586
                )
            )

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
