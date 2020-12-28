package com.himanshuw.yff.database.dao

import androidx.room.TypeConverter
import java.math.BigDecimal


class BigDecimalTypeConverter {

    @TypeConverter
    fun bigDecimalToString(input: BigDecimal?): String {
        return input?.toPlainString().orEmpty()
    }

    @TypeConverter
    fun stringToBigDecimal(input: String?): BigDecimal {
        if (input.isNullOrBlank()) return BigDecimal.valueOf(0.0)
        return input.toBigDecimalOrNull() ?: BigDecimal.valueOf(0.0)
    }
}