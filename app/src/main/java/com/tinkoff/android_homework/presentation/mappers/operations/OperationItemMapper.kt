package com.tinkoff.android_homework.presentation.mappers.operations

import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import javax.inject.Inject


/**
 * Преобразователь финансовой операции из типа domain-слоя в тип presentation-слоя.
 */
class OperationItemMapper @Inject constructor() : (Operation) -> OperationItem {

    /**
     *  Преобразователь финансовой операции из типа domain-слоя в тип presentation-слоя.
     *
     *  @param operation Финансовая операция domain-слоя.
     *  @return Финансовая операция presentation-слоя.
     */
    override operator fun invoke(operation: Operation): OperationItem {
        return OperationItem(
            operationType = operation.type,
            operationTitle = operation.name,
            operationSum = operation.amount
        )
    }
}