package com.tinkoff.android_homework.data.repo.operations

import com.tinkoff.android_homework.data.network.datasource.DetailRemoteDataSource
import com.tinkoff.android_homework.data.network.datasource.OperationsRemoteDataSource
import com.tinkoff.android_homework.data.network.mappers.operations.OperationsDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.network.services.OperationsDtoService
import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.mappers.operations.OperationDbModelListMapper
import com.tinkoff.android_homework.domain.main.entities.Operations
import com.tinkoff.android_homework.domain.main.repos.OperationsRepository
import javax.inject.Inject


/**
 * Реализация возможных действий с дополнительной информацией о финансовой операции.
 */
class OperationsRepositoryImpl @Inject constructor(
    private val operationsRemoteDataSource: OperationsRemoteDataSource,
    private val operationDbModelDao: OperationDbModelDao,
    private val operationsApiToDbMapper: OperationsDtoMapper,
    private val operationDbModelListMapper: OperationDbModelListMapper,
    private val internetChecker: InternetChecker
) : OperationsRepository {

    override suspend fun getOperations(): Operations {
        if (internetChecker.isInternetAvailable()) {
            val operationsApi = operationsRemoteDataSource.getOperations()
            operationDbModelDao.insertAll(*operationsApiToDbMapper.invoke(operationsApi).toTypedArray())
        }
        return operationDbModelListMapper.invoke(operationDbModelDao.getAll())
    }
}