package com.himanshuw.yff.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.himanshuw.yff.database.dao.AssetDao
import com.himanshuw.yff.database.dao.BigDecimalTypeConverter
import com.himanshuw.yff.database.entities.Asset
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.math.BigDecimal

@Database(entities = [Asset::class], version = 1)
@TypeConverters(BigDecimalTypeConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun assetDao(): AssetDao

    private class WordDatabaseCallback(
            private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.assetDao())
                }
            }
        }

        suspend fun populateDatabase(wordDao: AssetDao) {
            // Delete all content here.

            // Add sample words.
            val asset = Asset(name = "Mortgage", type = "Liability", value = BigDecimal(2700000))
            wordDao.insert(asset)
            wordDao.insert(asset)

            // TODO: Add your own words!
        }
    }


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "yff_database"
                ).addCallback(WordDatabaseCallback(scope))
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}