package com.example.ipvcconnect.dataaccessobjects

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ipvcconnect.models.Favourite
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {
    @Query("SELECT * FROM favourites")
    fun getFavourites(): Flow<List<Favourite>>

    @Insert
    suspend fun addFavourite(favourite: Favourite)

    @Query("DELETE FROM favourites WHERE id = :favouriteId")
    suspend fun removeFavourite(favouriteId: Int)
}