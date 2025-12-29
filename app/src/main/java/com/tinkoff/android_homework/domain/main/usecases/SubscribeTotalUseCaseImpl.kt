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
 * @param totalRepository Откуда будут приходить данные
 */
class SubscribeTotalUseCaseImpl @Inject constructor(
    private val totalRepository: TotalRepository,
) : SubscribeTotalUseCase {

    /**
     * Подписка на изменение общей суммы финансовых операций
     *
     * @return Поток с общей суммой финансовых операций
     */
    override operator fun invoke(): Flow<Total> {
        return totalRepository.subscribeTotal()
    }
}