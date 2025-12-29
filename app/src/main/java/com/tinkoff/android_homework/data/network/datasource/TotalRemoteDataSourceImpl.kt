package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.total.TotalDTO
import com.tinkoff.android_homework.data.network.services.TotalDtoService
import javax.inject.Inject


/** Удаленный источник данных для получения общей суммы финансовых операций. */
class TotalRemoteDataSourceImpl @Inject constructor(
    private val totalDtoService: TotalDtoService
) : TotalRemoteDataSource {

    /**
     * Получение суммы всех финансовых операций из удаленного источника данных.
     *
     * @return Общая сумма финансовых операций из data-слоя (network)
     */
    override suspend fun getTotal(): TotalDTO {
        return totalDtoService.getTotal()
    }
}