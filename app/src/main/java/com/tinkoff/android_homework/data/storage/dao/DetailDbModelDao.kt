package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel


/**
 * Объект доступа к данным о детальном описании финансовой операции.
 */
@Dao
interface DetailDbModelDao {

    // TODO ошибка с разными идентификаторами и типами

    /**
     * Получение всех записей из БД о детальном описании финансовых операций.
     *
     * @return Список детальных описаний финансовых операций из data-слоя (storage)
     */
    @Query("SELECT * FROM ${DetailDbModel.DETAILS_TABLE_NAME} WHERE id = :id")
    suspend fun getById(id: Long): DetailDbModel

    /**
     * Вставка нескольких строк в таблицу базы данных для хранения
     * детального описания финансовой операции.
     *
     * При повторении данных в БД, детальной описание финансовой операции заменяется на новое.
     *
     * @param operations Детальное описание финансовых операций из data-слоя (storage)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: DetailDbModel)
}