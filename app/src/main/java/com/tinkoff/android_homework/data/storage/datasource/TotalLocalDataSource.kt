package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import kotlinx.coroutines.flow.Flow

/** Описание локального источника данных для получения общей суммы финансовых операций. */
interface TotalLocalDataSource {

    /** Подписка на изменение суммы всех финансовых операций */
    suspend fun subscribeTotal(): Flow<List<TotalDbModel>>
}