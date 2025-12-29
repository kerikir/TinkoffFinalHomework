package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/** Локальный источник данных для получения списка финансовых операций. */
class OperationsLocalDataSourceImpl @Inject constructor(
    private val operationDao: OperationDbModelDao
) : OperationsLocalDataSource {

    /**
     * Подписка на изменение списка всех финансовых операций.
     *
     * @return Поток со списком всех финансовых операций.
     */
    override fun subscribeOperations(): Flow<List<OperationDbModel>> {
        return operationDao.getAllFlow()
    }


    /**
     * Вставка нескольких строк в таблицу базы данных для хранения финансовых операций.
     *
     * @param operations Финансовые операции из data-слоя (storage).
     */
    override suspend fun insertOperations(vararg operations: OperationDbModel) {
        operationDao.insertAll(*operations)
    }
}