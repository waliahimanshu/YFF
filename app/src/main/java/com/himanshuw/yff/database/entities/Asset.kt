package com.himanshuw.yff.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = "Asset")
data class Asset(
        @PrimaryKey(autoGenerate = true) val id: Int = 0,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "type") val type: String?,
        @ColumnInfo(name = "value") val value: BigDecimal
)