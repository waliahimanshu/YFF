package com.himanshuw.yff.database.repository

import androidx.lifecycle.LiveData
import com.himanshuw.yff.database.dao.AssetDao
import com.himanshuw.yff.database.entities.Asset

class AssetRepository(private val assetDao: AssetDao) {

    // Room executes all queries    on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Asset>> = assetDao.getAll()

    suspend fun insert(assert: Asset) {
        assetDao.insert(assert)
    }
}