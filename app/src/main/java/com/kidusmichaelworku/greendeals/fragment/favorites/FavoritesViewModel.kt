package com.kidusmichaelworku.greendeals.fragment.favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kidusmichaelworku.greendeals.database.FavoritesModel
import com.kidusmichaelworku.greendeals.database.GreenDealsDatabase
import com.kidusmichaelworku.greendeals.database.GreenDealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository
    private var readAll: LiveData<List<FavoritesModel>>

    init {
        val favoritesDAO = GreenDealsDatabase.getInstance(application).favoritesDAO()
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealDAO()
        repository = GreenDealsRepository(favoritesDAO, dealsDAO)
        readAll = repository.getAllFavorites()
    }

    fun getDeals(): LiveData<List<FavoritesModel>> {
        return readAll
    }

    fun deleteDeal(favoritesModel: FavoritesModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteFavorites(favoritesModel)
        }
    }
}