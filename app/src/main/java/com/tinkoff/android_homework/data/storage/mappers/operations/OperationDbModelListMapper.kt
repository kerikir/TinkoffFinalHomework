package com.tinkoff.android_homework.data.storage.mappers.operations

import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.data.storage.mappers.models.StorageOperationTypeMapper
import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.domain.main.entities.Operations
import javax.inject.Inject


/**
 * Преобразователь финансовой операции из типа data-слоя (storage) в тип domain-слоя.
 *
 * @param operationTypeMapper Преобразователь из типа операции data-слоя (storage)
 * в тип операций domain-слоя
 */
class OperationDbModelListMapper @Inject constructor(
    private val operationTypeMapper: StorageOperationTypeMapper
) : (List<OperationDbModel>) -> Operations {

    /**
     *  Преобразователь финансовой операции из типа data-слоя (storage) в тип domain-слоя.
     *
     *  @param operations Финансовая операция data-слоя.
     *  @return Финансовая операция domain-слоя.
     */
    override fun invoke(operations: List<OperationDbModel>): Operations {
        return Operations(
            operations = operations.map { operation ->
                Operation(operationTypeMapper(operation.type),
                    operation.name, operation.amount)
            }
        )
    }
}