package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DetailLocalDataSourceImpl @Inject constructor(
    private val detailDao: DetailDbModelDao
) : DetailLocalDataSource {

    override fun subscribeDetail(id: Int): Flow<DetailDbModel> {
        return detailDao.getDetailFlow(id)
    }

    override suspend fun insertDetail(vararg detailOperations: DetailDbModel) {
        detailDao.insertAll(*detailOperations)
    }
}