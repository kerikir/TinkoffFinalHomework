package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import kotlinx.coroutines.flow.Flow


/**
 * Data Access Object (DAO) для работы с общей суммой финансовых операций в базе данных.
 *
 * Предоставляет методы для CRUD операций.
 */
@Dao
interface TotalDbModelDao {

    /**
     * Подписка на изменение записи из БД об общей сумме финансовых операций.
     *
     * @return Поток общей суммы финансовых операций из data-слоя (storage)
     */
    @Query("SELECT * FROM ${TotalDbModel.TOTAL_TABLE_NAME}")
    fun getTotal(): Flow<TotalDbModel>


    /**
     * Вставка общей суммы финансовых операци в таблицу базы данных.
     *
     * При повторении данных в БД, общая сумма финансовой операции заменяется на новое.
     *
     * @param totalDbModel Общая сумма финансовых операций из data-слоя (storage)
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(totalDbModel: TotalDbModel)
}