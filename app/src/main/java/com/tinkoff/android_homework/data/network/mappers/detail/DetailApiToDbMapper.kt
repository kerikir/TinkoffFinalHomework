package com.tinkoff.android_homework.data.network.mappers.detail

import com.tinkoff.android_homework.data.network.entities.details.DetailDTO
import com.tinkoff.android_homework.data.network.mappers.models.NetworkOperationTypeMapper
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import java.util.UUID
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class DetailApiToDbMapper @Inject constructor(
    private val operationTypeMapper: NetworkOperationTypeMapper
) : (DetailDTO) -> DetailDbModel {

    override fun invoke(detail: DetailDTO): DetailDbModel {
        return DetailDbModel(
            id = UUID.randomUUID().timestamp(),
            type = operationTypeMapper(detail.type),
            comment = detail.comment,
            positions = detail.positions
        )
    }
}