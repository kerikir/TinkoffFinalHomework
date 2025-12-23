package com.tinkoff.android_homework.data.storage.database.utils

import androidx.room.TypeConverter


/**
 * Конвертер типов для сохранения списка строк в базе данных
 */
class ListStringConverter {

    @TypeConverter
    fun fromString(stringListString: String): List<String> {
        return stringListString.split(",").map { it }
    }

    @TypeConverter
    fun toString(stringList: List<String>): String {
        return stringList.joinToString(separator = ",")
    }
}