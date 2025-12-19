package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Operations
import com.tinkoff.android_homework.domain.main.repos.OperationsRepository
import javax.inject.Inject


/**
 * @author d.shtaynmets
 */
interface SubscribeOperationsUseCase {

    suspend fun invoke(): Operations
}

class SubscribeOperationsUseCaseImpl @Inject constructor(
    private val repository: OperationsRepository
) : SubscribeOperationsUseCase {

    override suspend fun invoke(): Operations {
        return repository.getOperations()
    }
}
