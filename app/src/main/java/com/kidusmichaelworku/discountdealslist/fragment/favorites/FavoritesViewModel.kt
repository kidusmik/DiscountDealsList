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
    private var readAll : LiveData<List<DealsModel>>
    init {
        val dealsDAO = GreenDealsDatabase.getDatabase(application).dealsDAO()
        repository = GreenDealsRepository(dealsDAO)
        readAll = repository.getAllDeals()
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