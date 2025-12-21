package com.tinkoff.android_homework.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel.Companion.TOTAL_TABLE_NAME


/**
 * Общая сумма финансовых операций.
 *
 * Модель данных для data слоя (storage).
 *
 * Имя таблицы - total_table.
 * Поля: id, total.
 */
@Entity(tableName = TOTAL_TABLE_NAME)
data class TotalDbModel(
    /**
     * Идентификатор в базе данных для общей суммы финансовых операций.
     * Первичный ключ.
     */
    @PrimaryKey
    val id: Long,
    /** Сумма всех операций */
    val total: Int,
) {

    /** Хранение констант */
    companion object {
        /** Имя таблицы в базе данных */
        const val TOTAL_TABLE_NAME = "total_table"
    }
}