package com.tinkoff.android_homework.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel.Companion.OPERATION_TABLE_NAME
import com.tinkoff.android_homework.data.storage.models.OperationType


/**
 * Финансовая операция.
 *
 * Модель данных для data слоя (storage).
 *
 * Имя таблицы - operation_table.
 * Поля: id, type, name, amount.
 */
@Entity(tableName = OPERATION_TABLE_NAME)
data class OperationDbModel(
    /**
     * Идентификатор в базе данных для финансовой операции.
     * Первичный ключ.
     */
    @PrimaryKey()
    val id: Long,
    /** Тип финансовой операции */
    val type: OperationType,
    /**
     * Название финансовой операции.
     * Имя столбца в БД - name.
     */
    @ColumnInfo(name = "name")
    val name: String,
    /**
     * Сумма финансовой операции.
     * Имя столбца в БД - amount.
     */
    @ColumnInfo(name = "amount")
    val amount: Int,
) {

    /** Хранение констант */
    companion object {
        /** Имя таблицы в базе данных */
        const val OPERATION_TABLE_NAME = "operation_table"
    }
}
