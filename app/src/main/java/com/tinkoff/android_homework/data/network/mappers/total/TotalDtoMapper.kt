package com.tinkoff.android_homework.data.network.mappers.total

import com.tinkoff.android_homework.data.network.entities.total.TotalDTO
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import javax.inject.Inject


/**
 * Преобразователь общей суммы финансовых операций из типа data-слоя (network)
 * в тип data-слоя (storage).
 */
class TotalDtoMapper @Inject constructor(): (TotalDTO) -> TotalDbModel {

    /**
     *  Преобразователь общей суммы финансовых операций из типа data-слоя (network)
     *  в тип data-слоя (storage).
     *
     *  @param totalDTO Общая сумма финансовых операций data-слоя (network).
     *  @return Общая сумма финансовых операций data-слоя (storage).
     */
    override fun invoke(totalDTO: TotalDTO): TotalDbModel {
        return TotalDbModel(
            id = totalDTO.id.toLong(),
            total = totalDTO.total,
        )
    }
}