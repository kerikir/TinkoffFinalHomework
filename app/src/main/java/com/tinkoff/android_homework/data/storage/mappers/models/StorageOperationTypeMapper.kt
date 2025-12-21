package com.tinkoff.android_homework.data.storage.mappers.models

import com.tinkoff.android_homework.data.storage.models.StorageOperationType
import com.tinkoff.android_homework.domain.main.models.OperationType
import javax.inject.Inject


class StorageOperationTypeMapper @Inject constructor() : (StorageOperationType) -> OperationType {

    override fun invoke(storageOperationType: StorageOperationType): OperationType {
        return when (storageOperationType) {
            StorageOperationType.INCOME -> OperationType.INCOME
            StorageOperationType.OUTCOME -> OperationType.OUTCOME
        }
    }
}