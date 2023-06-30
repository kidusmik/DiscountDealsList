package com.kidusmichaelworku.discountdealslist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DealDAO {

    /**
     * Inserts a single Deal entity to the database
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDeal(dealModel: DealModel)

    /**
     * Fetches all the Deals from the database
     */
    @Query("SELECT * FROM deals_table")
    fun getAllDeals(): LiveData<List<DealModel>>

    /**
     * Fetches all the Deals sorted by Expiry date
     */
    @Query("SELECT * from deals_table ORDER BY CAST(end_date AS FLOAT) ASC")
    fun getDealsSortedByDate(): LiveData<List<DealModel>>

    /**
     * Fetches all the Deals sorted by Store
     */
    @Query("SELECT * from deals_table ORDER BY  store ASC")
    fun getDealsSortedByStore(): LiveData<List<DealModel>>
}