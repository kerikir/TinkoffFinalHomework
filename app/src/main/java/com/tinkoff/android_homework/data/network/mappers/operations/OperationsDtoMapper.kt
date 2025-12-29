package com.tinkoff.android_homework.data.network.mappers.operations

import com.tinkoff.android_homework.data.network.entities.operations.OperationsDTO
import com.tinkoff.android_homework.data.network.mappers.models.NetworkOperationTypeMapper
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import javax.inject.Inject


/**
 * Преобразователь списка финансовых операций из типа data-слоя (network)
 * в тип data-слоя (storage).
 *
 * @param operationTypeMapper Преобразователь из типа операции data-слоя (network)
 * в тип операций data-слоя (storage)
 */
class OperationsDtoMapper @Inject constructor(
    private val operationTypeMapper: NetworkOperationTypeMapper
) : (OperationsDTO) -> List<OperationDbModel> {

    /**
     *  Преобразователь списка финансовых операций из типа data-слоя (network)
     *  в тип data-слоя (storage).
     *
     *  @param operationsDTO Список финансовых операций data-слоя (network).
     *  @return Список финансовых операций data-слоя (storage).
     */
    override fun invoke(operationsDTO: OperationsDTO): List<OperationDbModel> {
        return operationsDTO.operations.mapIndexed { index, operation ->
            OperationDbModel(
                id = operation.id.toLong(),
                type = operationTypeMapper(operation.type),
                name = operation.name,
                amount = operation.amount
            )
        }
    }
}