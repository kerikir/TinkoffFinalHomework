package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import kotlinx.coroutines.flow.Flow


/** Описание локального источника данных для получения общей суммы финансовых операций. */
interface TotalLocalDataSource {

    /**
     * Подписка на изменение записи из локального источника данных об общей сумме финансовых операций.
     *
     * @return Поток общей суммы финансовых операций из data-слоя (storage)
     */
    fun subscribeTotal(): Flow<TotalDbModel>


    /**
     * Сохранение общей суммы финансовых операци в локальном источнике данных.
     *
     * @param totalDbModel Общая сумма финансовых операций из data-слоя (storage)
     */
    suspend fun insertTotal(totalDbModel: TotalDbModel)
}