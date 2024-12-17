package com.example.ipvcconnect.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comments")
data class Comment(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "user") val user: String,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "company_id") val company_id: Int
)

