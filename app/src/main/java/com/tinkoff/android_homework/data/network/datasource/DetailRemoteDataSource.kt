package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.details.DetailDTO


/** Описание удаленного источника данных для получения детального описания финансовой операции. */
interface DetailRemoteDataSource {

    /**
     * Получение информации о финансовой операции из удаленного источника данных..
     *
     * @param id Идентификатор финансовой операции.
     * @return Детальное описание финансовой операции из data-слоя (network).
     */
    suspend fun getDetail(id: Int): DetailDTO
}