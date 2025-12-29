package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class TotalLocalDataSourceImpl @Inject constructor(
    private val totalDao: TotalDbModelDao
) : TotalLocalDataSource {

    override fun subscribeTotal(): Flow<TotalDbModel> {
        return totalDao.getTotalFlow()
    }

    override suspend fun insertTotal(totalDbModel: TotalDbModel) {
        totalDao.insert(totalDbModel)
    }
}