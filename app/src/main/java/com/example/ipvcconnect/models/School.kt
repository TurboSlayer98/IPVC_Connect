package com.example.ipvcconnect.models

import kotlinx.serialization.Serializable

@Serializable
data class School(
    val id: Int,
    val name: String,
    val address: String,
    val description: String,
    val imageUrl: String
) 