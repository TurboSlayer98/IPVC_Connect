package com.example.ipvcconnect.dataaccessobjects

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ipvcconnect.models.Favourites
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    fun getFavourites(): Flow<List<Favourites>>

    @Insert
    suspend fun addFavourite(favourite: Favourites)
}