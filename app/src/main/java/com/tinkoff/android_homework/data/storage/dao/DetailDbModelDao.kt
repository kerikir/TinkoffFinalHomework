package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import kotlinx.coroutines.flow.Flow


/**
 * Объект доступа к данным о детальном описании финансовой операции.
 */
@Dao
interface DetailDbModelDao {

    /**
     * Подписка на изменение записи из БД о детальном описании финансовой операции.
     *
     * @return Поток с детальным описанием финансовой операции из data-слоя (storage).
     */
    @Query("SELECT * FROM ${DetailDbModel.DETAILS_TABLE_NAME} WHERE id = :id")
    fun getById(id: Long): Flow<DetailDbModel>

    
    /**
     * Вставка нескольких строк в таблицу базы данных для хранения
     * детального описания финансовых операций.
     *
     * При повторении данных в БД, детальное описание финансовой операции заменяется на новое.
     *
     * @param operations Детальное описание финансовых операций из data-слоя (storage)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: DetailDbModel)
}