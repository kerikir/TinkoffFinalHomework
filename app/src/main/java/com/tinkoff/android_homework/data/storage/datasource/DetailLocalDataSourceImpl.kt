package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/** Локальный источник данных для получения детального описания финансовой операции. */
class DetailLocalDataSourceImpl @Inject constructor(
    private val detailDao: DetailDbModelDao
) : DetailLocalDataSource {

    /**
     * Подписка на изменение дополнительной информации о финансовой операции.
     *
     * @param id Идентификатор финансовой операции.
     * @return Поток с информацией о финансовой операции.
     */
    override fun subscribeDetail(id: Int): Flow<DetailDbModel> {
        return detailDao.getDetailFlow(id)
    }


    /**
     * Вставка детального описания финансовых операций в локальный источник данных.
     *
     * @param detailOperations Детальное описание финансовых операций из data-слоя (storage).
     */
    override suspend fun insertDetail(vararg detailOperations: DetailDbModel) {
        detailDao.insertAll(*detailOperations)
    }
}