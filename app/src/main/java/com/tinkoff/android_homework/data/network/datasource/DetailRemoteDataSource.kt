package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.details.DetailDTO


/** Описание удаленного источника данных для получения детального описания финансовой операции. */
interface DetailRemoteDataSource {

    /** Получение информации о финансовой операции */
    suspend fun getDetail(id: Int): DetailDTO
}