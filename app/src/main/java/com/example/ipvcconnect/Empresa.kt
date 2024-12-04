package com.example.ipvcconnect

data class Empresa(
    val nome: String,
    val descricao: String,
    val localizacao: String,
    val curso: String,
    val morada: String,
    val telefone: String,
    val email: String,
    val site: String,
    val vagasDisponiveis: Int,
    val vagasOcupadas: Int,
    val latitude: Double,
    val longitude: Double
) 