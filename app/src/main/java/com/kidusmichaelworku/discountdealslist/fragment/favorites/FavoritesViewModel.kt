package com.kidusmichaelworku.discountdealslist.fragment.favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.database.GreenDealsDatabase
import com.kidusmichaelworku.discountdealslist.database.GreenDealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository
    private var readAll : LiveData<List<FavoritesModel>>
    init {
        val favoritesDAO = GreenDealsDatabase.getInstance(application).favoritesDAO()
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealDAO()
        repository = GreenDealsRepository(favoritesDAO, dealsDAO)
        readAll = repository.getAllFavorites()
    }

    fun getDeals(): LiveData<List<FavoritesModel>> {
        return readAll
    }

    fun updateDeal(favoritesModel: FavoritesModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateFavorites(favoritesModel)
        }
    }

    fun deleteDeal(favoritesModel: FavoritesModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavorites(favoritesModel)
        }
    }
    fun addDeal(deal: FavoritesModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFavorites(deal)
        }
    }
}