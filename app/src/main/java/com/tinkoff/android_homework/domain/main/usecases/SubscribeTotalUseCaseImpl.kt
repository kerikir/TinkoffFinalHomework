package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Total
import com.tinkoff.android_homework.domain.main.repos.TotalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * Use Case для подписки на изменение суммы финансовых операций.
 *
 * Use Case в domain слое.
 * Реализация бизнес-логики.
 *
 * @param repository Откуда будут приходить данные
 */
class SubscribeTotalUseCaseImpl @Inject constructor(
    private val repository: TotalRepository,
) : SubscribeTotalUseCase {

    /**
     * Подписка на изменение общей суммы финансовых операций
     *
     * @return Поток с общей суммой финансовых операций
     */
    override suspend operator fun invoke(): Flow<Total> {
        return repository.subscribeTotal()
    }
}