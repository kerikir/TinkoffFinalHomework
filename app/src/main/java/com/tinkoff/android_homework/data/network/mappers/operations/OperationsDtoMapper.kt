package com.tinkoff.android_homework.data.network.mappers.operations

import com.tinkoff.android_homework.data.network.entities.operations.OperationsDTO
import com.tinkoff.android_homework.data.network.mappers.models.NetworkOperationTypeMapper
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class OperationsDtoMapper @Inject constructor(
    private val operationTypeMapper: NetworkOperationTypeMapper
) : (OperationsDTO) -> List<OperationDbModel> {

    override fun invoke(operationsDTO: OperationsDTO): List<OperationDbModel> {
        return operationsDTO.operation.mapIndexed { index, operation ->
            OperationDbModel(
                id = operation.id.toLong(),
                type = operationTypeMapper(operation.type),
                name = operation.name,
                amount = operation.amount
            )
        }
    }
}