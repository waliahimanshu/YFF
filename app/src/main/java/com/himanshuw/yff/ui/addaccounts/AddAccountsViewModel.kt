package com.himanshuw.yff.ui.addaccounts

import android.app.Application
import androidx.lifecycle.*
import com.himanshuw.yff.database.AppDatabase
import com.himanshuw.yff.database.entities.Asset
import com.himanshuw.yff.database.repository.AssetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.math.BigDecimal

class AddAccountsViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: AssetRepository

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> = _text
    private val allWords: LiveData<List<Asset>>

    init {
        val wordsDao = AppDatabase.getDatabase(application, viewModelScope).assetDao()
        repository = AssetRepository(wordsDao)
        allWords = repository.allWords
        insert()
    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(asset: Asset? = null) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(Asset(name = "Mortgage", type = "liability", value = BigDecimal.valueOf(275000)))
    }
}