package com.kidusmichaelworku.discountdealslist.fragment.deals_detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.kidusmichaelworku.discountdealslist.database.FavoritesModel
import com.kidusmichaelworku.discountdealslist.database.GreenDealsDatabase
import com.kidusmichaelworku.discountdealslist.database.GreenDealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DealDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository

    init {
        val favoritesDAO = GreenDealsDatabase.getInstance(application).favoritesDAO()
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealDAO()

        repository = GreenDealsRepository(favoritesDAO, dealsDAO)
    }

//    fun getSelectedDeal(id: Int): LiveData<FavoritesModel> {
//        val deal = MutableLiveData<FavoritesModel>()
//        viewModelScope.launch(Dispatchers.IO) {
//            val data = repository.getSelectedFavorite(id)
//            deal.postValue(data)
//        }
//        return deal
//    }
}


