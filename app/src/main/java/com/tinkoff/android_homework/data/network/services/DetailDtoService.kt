package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.details.DetailDTO
import retrofit2.http.GET
import retrofit2.http.Path


/**
 * Описание сетевых запросов для работы с детальным описанием финансовых операций.
 */
interface DetailDtoService {

    /**
     * Получение детального описания финансовой операции с сервера.
     *
     * GET-запрос.
     *
     * @param id Идентификатор финансовой операции.
     * @return Детальное описание финансовой операции из data-слоя (network)
     */
    @GET("android_for_begginers_back_end/main/detail/{id}.json")
    suspend fun getDetail(
        @Path("id") id: Int
    ): DetailDTO
}