package com.tinkoff.android_homework.data.repo.operations

import com.tinkoff.android_homework.data.network.datasource.OperationsRemoteDataSource
import com.tinkoff.android_homework.data.network.mappers.operations.OperationsDtoMapper
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import com.tinkoff.android_homework.data.storage.datasource.OperationsLocalDataSource
import com.tinkoff.android_homework.data.storage.mappers.operations.OperationDbModelListMapper
import com.tinkoff.android_homework.domain.main.entities.Operations
import com.tinkoff.android_homework.domain.main.repos.OperationsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject


/**
 * Реализация возможных действий с списком финансовых операций.
 */
class OperationsRepositoryImpl @Inject constructor(
    private val operationsRemoteDataSource: OperationsRemoteDataSource,
    private val operationsLocalDataSource: OperationsLocalDataSource,
    private val operationsDtoMapper: OperationsDtoMapper,
    private val operationDbModelListMapper: OperationDbModelListMapper,
    private val internetChecker: InternetChecker
) : OperationsRepository {

    /**
     * Получение потока со списком финансовых операций.
     *
     * @return Поток со списоком финансовых операций domain-слоя
     */
    override fun subscribeOperations(): Flow<Operations> {

        // Получаем все операции из БД
        return operationDbModelListMapper(operationsLocalDataSource.subscribeOperations())
            .onStart {
                refreshFromNetwork()
            }
    }


    /**
     * Получение информации о списке финансовых операций из сети.
     */
    private suspend fun refreshFromNetwork() {
        // Проверка на подключение интернета
        if (internetChecker.isInternetAvailable()) {
            // Загружаем информацию из сети
            val operationsDto = operationsRemoteDataSource.getOperations()
            // Сохраняем информацию в БД
            operationsLocalDataSource.insertOperations(
                *operationsDtoMapper(operationsDto).toTypedArray()
            )
        }
    }
}