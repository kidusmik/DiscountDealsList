package com.kidusmichaelworku.discountdealslist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update


@Dao
interface DealsDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertDeal(dealsModel: DealsModel)

    @Query("SELECT * FROM favorites_table")
    suspend fun getAllDeals(): LiveData<List<DealsModel>>

    @Query("SELECT * FROM favorites_table WHERE lmd_id == :id")
    suspend fun getSelectedDeal(id: Int): DealsModel

    @Delete
    suspend fun deleteDeal(dealsModel: DealsModel)

    @Update
    suspend fun updateDeal(dealsModel: DealsModel)
}