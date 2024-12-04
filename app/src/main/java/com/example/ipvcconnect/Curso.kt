package com.example.ipvcconnect

import android.content.Intent

data class Curso(
    val nome: String,
    val descricao: String,
    val escola: String,
    var intent: Intent? = null
) 