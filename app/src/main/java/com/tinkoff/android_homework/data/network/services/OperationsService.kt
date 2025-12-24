package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.operations.OperationsDTO
import retrofit2.http.GET


/**
 * Описание сетевых запросов для работы с списком финансовых операций.
 */
interface OperationsService {

    /**
     * Получение списка финансовых операций с сервера.
     *
     * GET-запрос.
     *
     * @return Список финансовых операций. из data-слоя (network)
     */
    @GET("android_for_begginers_back_end/main/operations.json")
    suspend fun getOperations(): OperationsDTO
}