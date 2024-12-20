package com.example.ipvcconnect.utils

import com.example.ipvcconnect.dataaccessobjects.FavouritesDao
import com.example.ipvcconnect.database.AppDatabase

object GlobalVars {
    lateinit var database: AppDatabase
    lateinit var favouritesDao: FavouritesDao
}