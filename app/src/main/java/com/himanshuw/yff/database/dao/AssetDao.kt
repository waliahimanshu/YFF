package com.himanshuw.yff.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.himanshuw.yff.database.entities.Asset

@Dao
interface AssetDao {
    @Query("SELECT * FROM asset")
    fun getAll(): LiveData<List<Asset>>

    @Query("SELECT * FROM asset WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Asset>

    @Query("SELECT * FROM asset WHERE type LIKE :type ")
    fun findByType(type: String): Asset

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insert(users: Asset)

    @Insert()
    suspend fun insertAll(vararg users: Asset)

    @Delete
    suspend fun delete(user: Asset)
}