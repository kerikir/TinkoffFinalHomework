package com.tinkoff.android_homework.data.network.mappers.models

import com.tinkoff.android_homework.data.network.models.NetworkOperationType
import com.tinkoff.android_homework.domain.main.models.OperationType
import javax.inject.Inject


/**
 * Преобразователь из типа операции data-слоя (network) в тип операций domain-слоя.
 */
class NetworkOperationTypeMapper @Inject constructor() : (NetworkOperationType) -> OperationType {

    /**
     *  Преобразователь из типа операции data-слоя (network) в тип операций domain-слоя.
     *
     *  @param networkOperationType Тип финансовой операции data-слоя.
     *  @return Тип финансовой операции domain-слоя.
     */
    override fun invoke(networkOperationType: NetworkOperationType): OperationType {
        return when (networkOperationType) {
            NetworkOperationType.INCOME -> OperationType.INCOME
            NetworkOperationType.OUTCOME -> OperationType.OUTCOME
        }
    }
}