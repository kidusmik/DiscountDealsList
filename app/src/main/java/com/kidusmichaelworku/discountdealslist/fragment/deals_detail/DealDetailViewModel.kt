package com.kidusmichaelworku.discountdealslist.fragment.deals_detail

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

class DealDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository

    init {
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealsdao()
        repository = GreenDealsRepository(dealsDAO)
    }

    fun getSelectedDeal(id: Int): LiveData<DealsModel> {
        val deal = MutableLiveData<DealsModel>()
        viewModelScope.launch(Dispatchers.IO) {
            val data = repository.getSelectedDeal(id)
            deal.postValue(data)
        }
        return deal
    }
}


