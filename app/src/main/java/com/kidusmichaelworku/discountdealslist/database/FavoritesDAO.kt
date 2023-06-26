package com.kidusmichaelworku.discountdealslist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface FavoritesDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavorite(favoritesModel: FavoritesModel)

    @Query("SELECT * FROM favorites_table")
    fun getAllFavorites(): LiveData<List<FavoritesModel>>

//    @Query("SELECT * FROM favorites_table WHERE lmd_id == :id")
//    fun getSelectedFavorite(id: Int): FavoritesModel

    @Delete
    fun deleteFavorite(favoritesModel: FavoritesModel)

    @Update
    fun updateFavorite(favoritesModel: FavoritesModel)
}