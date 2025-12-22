package com.tinkoff.android_homework.data.network.mappers.total

import com.tinkoff.android_homework.data.network.entities.total.TotalDTO
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class TotalDtoMapper @Inject constructor(): (TotalDTO) -> TotalDbModel {
    override fun invoke(totalDTO: TotalDTO): TotalDbModel {
        return TotalDbModel(
            id = totalDTO.id.toLong(),
            total = totalDTO.total,
        )
    }
}
