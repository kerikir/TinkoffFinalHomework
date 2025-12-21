package com.tinkoff.android_homework.data.storage.mappers.detail

import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import com.tinkoff.android_homework.data.storage.mappers.models.StorageOperationTypeMapper
import com.tinkoff.android_homework.domain.main.entities.Detail
import javax.inject.Inject


/**
 * Преобразователь детального описания финансовой операции из типа data-слоя (storage)
 * в тип domain-слоя.
 *
 * @param operationTypeMapper Преобразователь из типа операции data-слоя (storage) в тип операций domain-слоя
 */
class DetailDbModelMapper @Inject constructor(
    private val operationTypeMapper: StorageOperationTypeMapper
) : (DetailDbModel) -> Detail {

    /**
     *  Преобразователь детального описания финансовой операции из типа data-слоя (storage)
     *  в тип domain-слоя.
     *
     *  @param detailDbModel Детальное описание финансовой операции data-слоя.
     *  @return Детальное описание финансовой операции domain-слоя.
     */
    override fun invoke(detailDbModel: DetailDbModel): Detail {
        return Detail(
            type = operationTypeMapper(detailDbModel.type),
            comment = detailDbModel.comment,
            positions = detailDbModel.positions
        )
    }
}
