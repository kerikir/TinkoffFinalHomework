package com.tinkoff.android_homework.presentation.mappers.models

import com.tinkoff.android_homework.domain.main.models.OperationType
import com.tinkoff.android_homework.presentation.model.operations.PresentationOperationType
import javax.inject.Inject


/**
 * Преобразователь из типа операции domain-слоя в тип операций presentation-слоя.
 */
class PresentationOperationTypeMapper @Inject constructor() : (OperationType) -> PresentationOperationType {

    /**
     *  Преобразователь из типа операции domain-слоя в тип операций presentation-слоя.
     *
     *  @param operationType Тип финансовой операции domain-слоя.
     *  @return Тип финансовой операции presentation-слоя.
     */
    override fun invoke(operationType: OperationType): PresentationOperationType {
        return when (operationType) {
            OperationType.INCOME -> PresentationOperationType.INCOME
            OperationType.OUTCOME -> PresentationOperationType.OUTCOME
        }
    }
}