package com.tinkoff.android_homework.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel.Companion.DETAILS_TABLE_NAME
import com.tinkoff.android_homework.data.storage.models.StorageOperationType


/**
 * Детальное описание финансовой операции.
 *
 * Модель данных для data слоя (storage).
 *
 * Имя таблицы - details_table.
 * Поля: id, type, comment, positions.
 */
@Entity(tableName = DETAILS_TABLE_NAME)
data class DetailDbModel(
    /**
     * Идентификатор в базе данных для детального описания финансовой операции.
     * Первичный ключ.
     */
    @PrimaryKey
    val id: Long,
    /** Тип финансовой операции */
    val type: StorageOperationType,
    /** Комментарий к финансовой операции для отображения */
    val comment: String,
    /** Список позиций (что входит в сумму операции) */
    val positions: List<String>,
) {

    /** Хранение констант */
    companion object {
        /** Имя таблицы в базе данных */
        const val DETAILS_TABLE_NAME = "details_table"
    }
}
