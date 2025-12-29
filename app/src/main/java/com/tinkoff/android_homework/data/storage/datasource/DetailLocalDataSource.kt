package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import kotlinx.coroutines.flow.Flow


/** Описание локального источника данных для получения детального описания финансовой операции. */
interface DetailLocalDataSource {

    /**
     * Подписка на изменение дополнительной информации о финансовой операции.
     *
     * @param id Идентификатор финансовой операции.
     * @return Поток с информацией о финансовой операции.
     */
    suspend fun subscribeDetail(id: Int): Flow<DetailDbModel>
}