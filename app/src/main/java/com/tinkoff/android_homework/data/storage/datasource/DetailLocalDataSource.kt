package com.tinkoff.android_homework.data.storage.datasource

import com.tinkoff.android_homework.data.storage.entities.DetailDbModel


/** Описание локального источника данных для получения детального описания финансовой операции. */
interface DetailLocalDataSource {

    /** Получение информации о финансовой операции */
    suspend fun getDetail(id: Int): DetailDbModel
}