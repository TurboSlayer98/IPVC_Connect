package com.example.ipvcconnect.models

import kotlinx.serialization.Serializable

@Serializable
data class Comment(
    val id: Int,
    val companyId: Int,
    val text: String,
    val createdAt: String
) 