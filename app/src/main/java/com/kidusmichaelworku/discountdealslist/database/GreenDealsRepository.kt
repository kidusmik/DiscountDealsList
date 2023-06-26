package com.kidusmichaelworku.discountdealslist.database

import androidx.lifecycle.LiveData

class GreenDealsRepository(private val dealsDAO: DealsDAO) {

    suspend fun insertDeals(dealsModel: DealsModel) =
        dealsDAO.insertDeal(dealsModel)

    suspend fun updateDeals(dealsModel: DealsModel) =
        dealsDAO.updateDeal(dealsModel)

    suspend fun deleteDeals(dealsModel: DealsModel) =
        dealsDAO.deleteDeal(dealsModel)

    fun getAllDeals(): LiveData<List<DealsModel>> = dealsDAO.getAllDeals()

    suspend fun getSelectedDeal(id: Int): DealsModel = dealsDAO.getSelectedDeal(id)
}