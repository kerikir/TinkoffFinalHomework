package com.tinkoff.android_homework.data.network.mappers.models

import com.tinkoff.android_homework.data.network.models.NetworkOperationType
import com.tinkoff.android_homework.data.storage.models.StorageOperationType
import javax.inject.Inject


/**
 * Преобразователь из типа операции data-слоя (network) в тип операций data-слоя (storage).
 */
class NetworkOperationTypeMapper @Inject constructor() : (NetworkOperationType) -> StorageOperationType {

    /**
     *  Преобразователь из типа операции data-слоя (network) в тип операций data-слоя (storage).
     *
     *  @param networkOperationType Тип финансовой операции data-слоя (network).
     *  @return Тип финансовой операции data-слоя (storage).
     */
    override fun invoke(networkOperationType: NetworkOperationType): StorageOperationType {
        return when (networkOperationType) {
            NetworkOperationType.INCOME -> StorageOperationType.INCOME
            NetworkOperationType.OUTCOME -> StorageOperationType.OUTCOME
        }
    }
}