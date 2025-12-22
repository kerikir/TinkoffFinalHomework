package com.tinkoff.android_homework.data.storage.mappers.models

import com.tinkoff.android_homework.data.storage.models.StorageOperationType
import com.tinkoff.android_homework.domain.main.models.OperationType
import javax.inject.Inject


/**
 * Преобразователь из типа операции data-слоя (storage) в тип операций domain-слоя.
 */
class StorageOperationTypeMapper @Inject constructor() : (StorageOperationType) -> OperationType {

    /**
     *  Преобразователь из типа операции data-слоя (storage) в тип операций domain-слоя.
     *
     *  @param storageOperationType Тип финансовой операции data-слоя.
     *  @return Тип финансовой операции domain-слоя.
     */
    override fun invoke(storageOperationType: StorageOperationType): OperationType {
        return when (storageOperationType) {
            StorageOperationType.INCOME -> OperationType.INCOME
            StorageOperationType.OUTCOME -> OperationType.OUTCOME
        }
    }
}