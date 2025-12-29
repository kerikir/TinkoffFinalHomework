package com.tinkoff.android_homework.data.storage.mappers.operations

import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.data.storage.mappers.models.StorageOperationTypeMapper
import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.domain.main.entities.Operations
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Преобразователь финансовой операции из типа data-слоя (storage) в тип domain-слоя.
 *
 * @param operationTypeMapper Преобразователь из типа операции data-слоя (storage)
 * в тип операций domain-слоя
 */
class OperationDbModelListMapper @Inject constructor(
    private val operationTypeMapper: StorageOperationTypeMapper
) : (Flow<List<OperationDbModel>>) -> Flow<Operations> {

    /**
     *  Преобразователь финансовой операции из типа data-слоя (storage) в тип domain-слоя.
     *
     *  @param operations Финансовая операция data-слоя (storage).
     *  @return Финансовая операция domain-слоя.
     */
    fun map(operations: List<OperationDbModel>): Operations {
        return Operations(
            operations = operations.map { operation ->
                Operation(operationTypeMapper(operation.type),
                    operation.name, operation.amount)
            }
        )
    }


    /**
     *  Преобразователь потока со списком финансовых операций из типа data-слоя (storage)
     *  в поток типа domain-слоя.
     *
     *  @param operationsDbModelFlow Поток со списком финансовых операций data-слоя (storage).
     *  @return Поток со списком финансовых операций domain-слоя.
     */
    override fun invoke(operationsDbModelFlow: Flow<List<OperationDbModel>>): Flow<Operations> {
        return operationsDbModelFlow.map { map(it) }
    }
}