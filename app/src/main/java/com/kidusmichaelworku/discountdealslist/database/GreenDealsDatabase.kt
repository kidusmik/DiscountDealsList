package com.kidusmichaelworku.discountdealslist.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [DealsModel::class], version = 1, exportSchema = false)
abstract class GreenDealsDatabase : RoomDatabase() {

    abstract fun dealsdao(): DealsDAO

    companion object {
        private var instance: GreenDealsDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): GreenDealsDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(ctx.applicationContext, GreenDealsDatabase::class.java,
                    "green_deals_database")
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!

        }

        private val roomCallback = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                populateDatabase(instance!!)
            }
        }

        private fun populateDatabase(db: GreenDealsDatabase) {
            val dealsdao = db.dealsdao()
            val deal1 = DealsModel(1275984,
                "timesprime.com","https://www.timesprime.com/",
                "Times Prime Membership @ just &#8377;1199",
                "Times Prime Membership",
                "Get it at just &#8377;1199","","",
                "Entertainment,Entertainment Subscription","No","N",
                "https://www.timesprime.com/",
                "https://smartlink.linkmydeals.com/?account_id=18950&network=&url=https%3A%2F%2Fwww.timesprime.com%2F",
                "https://static.timesprime.com/2x/youtube-logo-box.png","Deal","Offer","Hot Offer","new",
                "2023-06-19","2023-06-27")

            val deal2 = DealsModel(12345678, "toliday.in","https://www.toliday.in/","Get Flat &#8377;300 discount on Flight and Hotel Booking","Get &#8377;300 OFF","This voucher is valid on Flight and Hotel Booking","FLAT300","","Travel,Domestic Flights,International Flights,Hotels","No","N","https://toliday.in/","https://smartlink.linkmydeals.com/?account_id=18950&network=&url=https%3A%2F%2Ftoliday.in%2F","https://toliday.in/coupon-code/10.png","Code","Price-Off","&#8377;300","new","2023-02-01","2023-06-25")

            CoroutineScope (Dispatchers.IO).launch {
                dealsdao.insertDeal(deal1)
                dealsdao.insertDeal(deal2)
            }
        }
    }
}