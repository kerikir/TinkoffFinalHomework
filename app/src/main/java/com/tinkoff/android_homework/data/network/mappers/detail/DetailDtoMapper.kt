package com.tinkoff.android_homework.data.network.mappers.detail

import com.tinkoff.android_homework.data.network.entities.details.DetailDTO
import com.tinkoff.android_homework.data.network.mappers.models.NetworkOperationTypeMapper
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import java.util.UUID
import javax.inject.Inject


/**
 * Преобразователь детального описания финансовой операции из типа data-слоя (network)
 * в тип data-слоя (storage).
 *
 * @param operationTypeMapper Преобразователь из типа операции data-слоя (network)
 * в тип операций data-слоя (storage)
 */
class DetailDtoMapper @Inject constructor(
    private val operationTypeMapper: NetworkOperationTypeMapper
) : (DetailDTO) -> DetailDbModel {

    /**
     *  Преобразователь детального описания финансовой операции из типа data-слоя (network)
     *  в тип data-слоя (storage).
     *
     *  @param detail Детальное описание финансовой операции data-слоя (network).
     *  @return Детальное описание финансовой операции data-слоя (storage).
     */
    override fun invoke(detail: DetailDTO): DetailDbModel {
        return DetailDbModel(
            id = UUID.randomUUID().timestamp(),
            type = operationTypeMapper(detail.type),
            comment = detail.comment,
            positions = detail.positions
        )
    }
}