package com.example.ipvcconnect.models

import kotlinx.serialization.Serializable

@Serializable
data class Course(
    val id: Int,
    val name: String,
    val description: String,
    val school_id: Int
) 