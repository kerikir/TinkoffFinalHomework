package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.operations.OperationsDTO
import com.tinkoff.android_homework.data.network.services.OperationsDtoService
import javax.inject.Inject


/** Удаленный источник данных для получения списка финансовых операций. */
class OperationsRemoteDataSourceImpl @Inject constructor(
    private val operationsDtoService: OperationsDtoService
) : OperationsRemoteDataSource {

    /**
     * Получение всех финансовых операций
     *
     * @return Список финансовых операций из data-слоя (network)
     */
    override suspend fun getOperations(): OperationsDTO {
        return operationsDtoService.getOperations()
    }
}