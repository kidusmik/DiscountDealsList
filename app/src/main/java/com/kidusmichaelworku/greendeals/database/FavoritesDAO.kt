package com.kidusmichaelworku.greendeals.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface FavoritesDAO {
    /**
     * Inserts a single favorites into the database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavorite(favoritesModel: FavoritesModel)

    /**
     * Fetches all the Favorites from the database
     */
    @Query("SELECT * FROM favorites_table")
    fun getAllFavorites(): LiveData<List<FavoritesModel>>

    /**
     * Deletes a Deals from the database
     */
    @Delete
    fun deleteFavorite(favoritesModel: FavoritesModel)
}