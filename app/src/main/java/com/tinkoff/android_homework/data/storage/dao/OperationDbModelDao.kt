package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel


/**
 * Data Access Object (DAO) для работы с финансовыми операциями в базе данных.
 *
 * Предоставляет методы для CRUD операций.
 */
@Dao
interface OperationDbModelDao {

    /**
     * Получение всех записей из БД о финансовых операций.
     *
     * @return Список финансовых операций из data-слоя (storage)
     */
    @Query("SELECT * FROM ${OperationDbModel.OPERATION_TABLE_NAME}")
    suspend fun getAll(): List<OperationDbModel>

    /**
     * Вставка нескольких строк в таблицу базы данных для хранения финансовых операций.
     *
     * При повторении данных в БД, детальной описание финансовой операции заменяется на новое.
     *
     * @param operations Финансовые операции из data-слоя (storage)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: OperationDbModel)
}
