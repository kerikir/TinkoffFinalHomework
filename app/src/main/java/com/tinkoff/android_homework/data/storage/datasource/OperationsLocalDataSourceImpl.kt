package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class OperationsLocalDataSourceImpl @Inject constructor(
    private val operationDao: OperationDbModelDao
) : OperationsLocalDataSource {

    override fun subscribeOperations(): Flow<List<OperationDbModel>> {
        return operationDao.getAllFlow()
    }

    override suspend fun insertOperations(vararg operations: OperationDbModel) {
        operationDao.insertAll(*operations)
    }
}