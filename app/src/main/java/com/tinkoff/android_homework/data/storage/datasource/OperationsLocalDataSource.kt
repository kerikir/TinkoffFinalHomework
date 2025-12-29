package com.tinkoff.android_homework.data.storage.datasource

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.domain.main.entities.Operations
import kotlinx.coroutines.flow.Flow


/** Описание локального источника данных для получения списка финансовых операций. */
interface OperationsLocalDataSource {

    /**
     * Подписка на изменение списка всех финансовых операций.
     *
     * @return Поток со списком всех финансовых операций.
     */
    fun subscribeOperations(): Flow<Operations>


    /**
     * Вставка нескольких строк в таблицу базы данных для хранения финансовых операций.
     *
     * @param operations Финансовые операции из data-слоя (storage).
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOperations(vararg operations: OperationDbModel)
}