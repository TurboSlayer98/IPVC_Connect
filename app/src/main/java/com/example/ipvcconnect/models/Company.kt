package com.example.ipvcconnect.models

data class Company(
    val id: Int,
    val name: String,
    val address: String,
    val description: String,
    val placements_available: Int,
    val placements_ocupied: Int,
    val phone: String,
    val email: String,
    val website: String,
    val latitude: Double,
    val longitude: Double,
    val comments: List<Comment>
) 