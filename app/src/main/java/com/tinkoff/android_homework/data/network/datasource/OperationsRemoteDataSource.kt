package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.operations.OperationsDTO


/** Описание удаленного источника данных для получения списка финансовых операций. */
interface OperationsRemoteDataSource {

    /** Получение всех финансовых операций */
    suspend fun getOperations(): OperationsDTO
}