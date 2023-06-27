package com.kidusmichaelworku.discountdealslist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavoritesModel::class, DealModel::class], version = 1, exportSchema = false)
abstract class GreenDealsDatabase : RoomDatabase() {
    abstract fun favoritesDAO(): FavoritesDAO
    abstract fun dealDAO(): DealDAO

    companion object {
        private var instance: GreenDealsDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): GreenDealsDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, GreenDealsDatabase::class.java,
                    "green_deals_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!
        }
    }
}