package com.example.ipvcconnect.models

data class Company(
    var id: Int,
    var name: String,
    var address: String,
    var description: String,
    var placements_available: Int,
    var placements_ocupied: Int,
    var phone: String,
    var email: String,
    var website: String,
    var latitude: Double,
    var longitude: Double,
    val comments: List<Comment>
) 