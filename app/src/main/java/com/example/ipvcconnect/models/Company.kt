package com.example.ipvcconnect.models

import kotlinx.serialization.Serializable

@Serializable
data class Company(
    val id: Int,
    val name: String,
    val address: String,
    val description: String,
    val placements: Int,
    val phone: String,
    val email: String,
    val imageUrl: String,
    val comments: List<Comment> = emptyList()
) 