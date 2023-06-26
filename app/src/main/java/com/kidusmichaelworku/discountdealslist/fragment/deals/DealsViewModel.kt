package com.kidusmichaelworku.discountdealslist.fragment.deals

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kidusmichaelworku.discountdealslist.database.DealModel
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.database.GreenDealsDatabase
import com.kidusmichaelworku.discountdealslist.database.GreenDealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DealsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository
    private var readAll : LiveData<List<DealModel>>

    init {
        val favoritesDAO = GreenDealsDatabase.getInstance(application).favoritesDAO()
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealDAO()

        repository = GreenDealsRepository(favoritesDAO, dealsDAO)
        readAll = repository.getAllDeal()
    }

    fun getDeals(): LiveData<List<DealModel>> {
        return readAll
    }
    fun updateDeal(dealModel: DealModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDeal(dealModel)
        }
    }

    fun deleteDeal(dealModel: DealModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDeal(dealModel)
        }
    }
    fun insertDeal(deal: DealModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertDeal(deal)
        }
    }

    fun addFavorites(deal: FavoritesModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertFavorites(deal)
        }
    }

    fun getDealsSortedByStore(): LiveData<List<DealModel>>{
        return repository.getDealsSortedByStore()
    }

    fun getDealsSortedByDate(): LiveData<List<DealModel>>{
        return repository.getDealsSortedByDate()
    }
}