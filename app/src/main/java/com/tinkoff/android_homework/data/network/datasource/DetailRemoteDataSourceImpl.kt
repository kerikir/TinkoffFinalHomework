package com.tinkoff.android_homework.data.network.datasource

import com.tinkoff.android_homework.data.network.entities.details.DetailDTO
import com.tinkoff.android_homework.data.network.services.DetailDtoService
import javax.inject.Inject


/** Удаленный источник данных для получения детального описания финансовой операции. */
class DetailRemoteDataSourceImpl @Inject constructor (
    private val detailDtoService: DetailDtoService
) : DetailRemoteDataSource {

    /**
     * Получение информации о финансовой операции
     *
     * @param id Идентификатор финансовой операции.
     * @return Детальное описание финансовой операции из data-слоя (network)
     */
    override suspend fun getDetail(id: Int): DetailDTO {
        return detailDtoService.getDetail(id)
    }
}