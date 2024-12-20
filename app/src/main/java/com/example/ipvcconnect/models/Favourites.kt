package com.example.ipvcconnect.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favourites")
class Favourites (
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    @ColumnInfo(name = "company_id") val company_id: Int,
    @ColumnInfo(name = "favourite") val favourite: Boolean
)