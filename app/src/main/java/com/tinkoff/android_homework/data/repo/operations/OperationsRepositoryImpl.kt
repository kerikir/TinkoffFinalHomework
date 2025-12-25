package com.tinkoff.android_homework.data.repo.operations

import com.tinkoff.android_homework.data.network.datasource.OperationsRemoteDataSource
import com.tinkoff.android_homework.data.network.mappers.operations.OperationsDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.mappers.operations.OperationDbModelListMapper
import com.tinkoff.android_homework.domain.main.entities.Operations
import com.tinkoff.android_homework.domain.main.repos.OperationsRepository
import javax.inject.Inject


/**
 * Реализация возможных действий с списком финансовых операций.
 */
class OperationsRepositoryImpl @Inject constructor(
    private val operationsRemoteDataSource: OperationsRemoteDataSource,
    private val operationDbModelDao: OperationDbModelDao,
    private val operationsDtoMapper: OperationsDtoMapper,
    private val operationDbModelListMapper: OperationDbModelListMapper,
    private val internetChecker: InternetChecker
) : OperationsRepository {

    /**
     * Получение списка финансовых операций.
     *
     * @return Список финансовых операций domain-слоя
     */
    override suspend fun getOperations(): Operations {

        // Проверка на подключение интернета
        if (internetChecker.isInternetAvailable()) {
            // Загружаем информацию из сети
            val operationsDto = operationsRemoteDataSource.getOperations()
            // Сохраняем информацию в БД
            operationDbModelDao.insertAll(*operationsDtoMapper(operationsDto).toTypedArray())
        }

        // Получаем все операции из БД
        return operationDbModelListMapper(operationDbModelDao.getAll())
    }
}