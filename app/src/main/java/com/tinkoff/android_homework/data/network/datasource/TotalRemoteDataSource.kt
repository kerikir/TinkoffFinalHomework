package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.total.TotalDTO


/** Описание удаленного источника данных для получения общей суммы финансовых операций. */
interface TotalRemoteDataSource {

    /**
     * Получение суммы всех финансовых операций из удаленного источника данных.
     *
     * @return Общая сумма финансовых операций из data-слоя (network)
     */
    suspend fun getTotal(): TotalDTO
}