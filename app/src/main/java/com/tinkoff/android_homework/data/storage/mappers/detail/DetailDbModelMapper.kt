package com.tinkoff.android_homework.data.storage.mappers.detail

import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import com.tinkoff.android_homework.data.storage.mappers.models.StorageOperationTypeMapper
import com.tinkoff.android_homework.domain.main.entities.Detail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Преобразователь детального описания финансовой операции из типа data-слоя (storage)
 * в тип domain-слоя.
 *
 * @param operationTypeMapper Преобразователь из типа операции data-слоя (storage) в тип операций domain-слоя
 */
class DetailDbModelMapper @Inject constructor(
    private val operationTypeMapper: StorageOperationTypeMapper
) : (Flow<DetailDbModel>) -> Flow<Detail> {

    /**
     *  Преобразователь детального описания финансовой операции из типа data-слоя (storage)
     *  в тип domain-слоя.
     *
     *  @param detailDbModel Детальное описание финансовой операции data-слоя.
     *  @return Детальное описание финансовой операции domain-слоя.
     */
    fun map(detailDbModel: DetailDbModel): Detail {
        return Detail(
            type = operationTypeMapper(detailDbModel.type),
            amount = detailDbModel.amount,
            comment = detailDbModel.comment,
            positions = detailDbModel.positions
        )
    }


    /**
     *  Преобразователь потока детального описания финансовой операции из типа data-слоя (storage)
     *  в поток типа domain-слоя.
     *
     *  @param detailDbModelFlow Поток детального описания финансовой операции data-слоя.
     *  @return Поток детального описания финансовой операции domain-слоя.
     */
    override operator fun invoke(detailDbModelFlow: Flow<DetailDbModel>): Flow<Detail> {
        return detailDbModelFlow.map { map(it) }
    }
}