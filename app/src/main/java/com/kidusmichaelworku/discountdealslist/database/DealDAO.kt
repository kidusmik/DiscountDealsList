package com.kidusmichaelworku.discountdealslist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface DealDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDeal(dealModel: DealModel)

    @Query("SELECT * FROM deals_table")
    fun getAllDeals(): LiveData<List<DealModel>>

//    @Query("SELECT * FROM deals_table WHERE lmd_id == :id")
//    fun getSelectedDeal(id: Int): DealModel

    @Delete
    fun deleteDeal(dealModel: DealModel)

    @Update
    fun updateDeal(dealModel: DealModel)

    @Query("SELECT * from deals_table ORDER BY CAST(end_date AS FLOAT) ASC")
    fun getDealsSortedByDate(): LiveData<List<DealModel>>

    @Query("SELECT * from deals_table ORDER BY  store ASC")
    fun getDealsSortedByStore(): LiveData<List<DealModel>>
}