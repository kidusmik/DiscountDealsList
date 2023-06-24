package com.kidusmichaelworku.discountdealslist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [DealsModel::class],
    version = 1
)
abstract class GreenDealsDatabase : RoomDatabase() {

    abstract fun dealsDAO(): DealsDAO

    companion object {
        @Volatile
        private var INSTANCE: RoomDatabase? = null

        fun getDatabase(context: Context): RoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomDatabase::class.java,
                    "green_deals_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}