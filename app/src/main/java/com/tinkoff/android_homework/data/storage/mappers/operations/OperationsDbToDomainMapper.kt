package com.tinkoff.android_homework.data.storage.mappers.operations

import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.domain.main.entities.Operation
import com.tinkoff.android_homework.domain.main.entities.Operations
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class OperationsDbToDomainMapper @Inject constructor() : (List<OperationDbModel>) -> Operations {

    override fun invoke(operations: List<OperationDbModel>): Operations {
        return Operations(
            operations = operations.map { operation ->
                Operation(operation.type, operation.name, operation.amount)
            }
        )
    }
}
