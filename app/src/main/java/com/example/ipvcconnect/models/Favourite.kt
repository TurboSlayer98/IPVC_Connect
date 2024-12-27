package com.example.ipvcconnect.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
data class Favourite (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "company_id") val company_id: Int
)