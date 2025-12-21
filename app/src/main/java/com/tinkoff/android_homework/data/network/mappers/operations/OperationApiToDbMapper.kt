package com.tinkoff.android_homework.data.network.mappers.operations

import com.tinkoff.android_homework.data.network.entities.operations.OperationsApi
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class OperationApiToDbMapper @Inject constructor() : (OperationsApi) -> List<OperationDbModel> {

    override fun invoke(operationsApi: OperationsApi): List<OperationDbModel> {
        return operationsApi.operation.mapIndexed { index, operation ->
            OperationDbModel(
                id = operation.id.toLong(),
                type = operation.type,
                name = operation.name,
                amount = operation.amount
            )
        }
    }
}
