package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Operations
import com.tinkoff.android_homework.domain.main.repos.OperationsRepository
import javax.inject.Inject


/**
 * Use Case для получения списка финансовых операций.
 *
 * Use Case в domain слое.
 * Реализация бизнес-логики.
 *
 * @param repository Откуда будут приходить данные
 */
class GetOperationsUseCaseImpl @Inject constructor(
    private val repository: OperationsRepository
) : GetOperationsUseCase {

    // Вызов Use Case как обычной функции
    override suspend operator fun invoke(): Operations {
        return repository.getOperations()
    }
}