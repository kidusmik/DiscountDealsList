package com.kidusmichaelworku.discountdealslist.database

import android.app.Application
import androidx.lifecycle.LiveData

class GreenDealsRepository(private val dealsDAO: DealsDAO) {

    suspend fun insertDeals(dealsModel: DealsModel) =
        dealsDAO.insertDeal(dealsModel)

    suspend fun updateDeals(dealsModel: DealsModel) =
        dealsDAO.updateDeal(dealsModel)

    suspend fun deleteDeals(dealsModel: DealsModel) =
        dealsDAO.deleteDeal(dealsModel)

    suspend fun getAllDeals(): LiveData<List<DealsModel>> = dealsDAO.getAllDeals()
}