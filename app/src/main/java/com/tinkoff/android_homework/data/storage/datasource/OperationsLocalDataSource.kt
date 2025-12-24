package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.entities.OperationDbModel

/** Описание локального источника данных для получения списка финансовых операций. */
interface OperationsLocalDataSource {

    /** Получение всех финансовых операций */
    suspend fun getOperations(): List<OperationDbModel>
}