package com.kidusmichaelworku.discountdealslist.database

import androidx.lifecycle.LiveData

class GreenDealsRepository(private val favoritesDAO: FavoritesDAO, private val dealDAO: DealDAO) {

    fun insertFavorites(favoritesModel: FavoritesModel) =
        favoritesDAO.insertFavorite(favoritesModel)

    fun deleteFavorites(favoritesModel: FavoritesModel) =
        favoritesDAO.deleteFavorite(favoritesModel)

    fun getAllFavorites(): LiveData<List<FavoritesModel>> = favoritesDAO.getAllFavorites()

    fun insertDeal(DealModel: DealModel) =
        dealDAO.insertDeal(DealModel)

    fun getAllDeal(): LiveData<List<DealModel>> = dealDAO.getAllDeals()

    fun getDealsSortedByDate(): LiveData<List<DealModel>> = dealDAO.getDealsSortedByDate()

    fun getDealsSortedByStore(): LiveData<List<DealModel>> = dealDAO.getDealsSortedByStore()
//    fun getSelectedDeal(id: Int): DealModel = dealDAO.getSelectedDeal(id)
}