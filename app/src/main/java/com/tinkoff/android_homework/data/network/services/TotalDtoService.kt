package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.total.TotalDTO
import retrofit2.http.GET


/**
 * Описание сетевых запросов для работы общей суммой финансовых операций.
 */
interface TotalDtoService {

    /**
     * Получение общей суммы финансовых операций с сервера.
     *
     * GET-запрос.
     *
     * @return Общая сумма финансовых операций из data-слоя (network)
     */
    @GET("android_for_begginers_back_end/main/total.json")
    suspend fun getTotal(): TotalDTO
}