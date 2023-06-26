package com.kidusmichaelworku.discountdealslist.fragment.deals

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kidusmichaelworku.discountdealslist.database.DealsModel
import com.kidusmichaelworku.discountdealslist.database.GreenDealsDatabase
import com.kidusmichaelworku.discountdealslist.database.GreenDealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DealsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository
    init {
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealsdao()
        repository = GreenDealsRepository(dealsDAO)
    }

    fun updateDeal(dealsModel: DealsModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateDeals(dealsModel)
        }
    }

    fun deleteDeal(dealsModel: DealsModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteDeals(dealsModel)
        }
    }
    fun addDeal(deal: DealsModel){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertDeals(deal)
        }
    }
}