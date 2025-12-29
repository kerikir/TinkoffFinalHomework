package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/** Локальный источник данных для получения общей суммы финансовых операций. */
class TotalLocalDataSourceImpl @Inject constructor(
    private val totalDao: TotalDbModelDao
) : TotalLocalDataSource {

    /**
     * Подписка на изменение записи из локального источника данных об общей сумме финансовых операций.
     *
     * @return Поток общей суммы финансовых операций из data-слоя (storage)
     */
    override fun subscribeTotal(): Flow<TotalDbModel> {
        return totalDao.getTotalFlow()
    }


    /**
     * Сохранение общей суммы финансовых операци в локальном источнике данных.
     *
     * @param totalDbModel Общая сумма финансовых операций из data-слоя (storage)
     */
    override suspend fun insertTotal(totalDbModel: TotalDbModel) {
        totalDao.insert(totalDbModel)
    }
}