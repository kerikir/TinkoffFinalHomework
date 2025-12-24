package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.total.TotalDTO


/** Описание удаленного источника данных для получения общей суммы финансовых операций. */
interface TotalRemoteDataSource {

    /** Получение суммы всех финансовых операций */
    suspend fun getTotal(): TotalDTO
}