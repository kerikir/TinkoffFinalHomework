package com.tinkoff.android_homework.data.network.services

import com.tinkoff.android_homework.data.network.entities.operations.OperationsDTO
import retrofit2.http.GET

/**
 * @author d.shtaynmets
 */
interface OperationsService {

    @GET("android_for_begginers_back_end/main/operations.json")
    suspend fun getOperations(): OperationsDTO

}
