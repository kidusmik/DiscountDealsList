package com.kidusmichaelworku.discountdealslist.fragment.favorites

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.kidusmichaelworku.discountdealslist.database.DealsModel
import com.kidusmichaelworku.discountdealslist.database.GreenDealsDatabase
import com.kidusmichaelworku.discountdealslist.database.GreenDealsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GreenDealsRepository
    private lateinit var readAll : LiveData<List<DealsModel>>
    init {
        val dealsDAO = GreenDealsDatabase.getInstance(application).dealsdao()
        repository = GreenDealsRepository(dealsDAO)
        viewModelScope.launch(Dispatchers.IO) {
            readAll = repository.getAllDeals()
        }
    }

    fun getDeals(): LiveData<List<DealsModel>> {
        return readAll
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

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is favorites Fragment"
//    }
//    val text: LiveData<String> = _text
}