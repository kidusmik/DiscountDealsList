package com.kidusmichaelworku.discountdealslist.database

import android.app.Application
import androidx.lifecycle.LiveData

class GreenDealsRepository(private val dealsDAO: DealsDAO) {

    fun insertDeals(dealsModel: DealsModel) =
        dealsDAO.insertDeal(dealsModel)

    fun updateDeals(dealsModel: DealsModel) =
        dealsDAO.updateDeal(dealsModel)

    fun deleteDeals(dealsModel: DealsModel) =
        dealsDAO.deleteDeal(dealsModel)

    fun getAllDeals(): LiveData<List<DealsModel>> = dealsDAO.getAllDeals()
}