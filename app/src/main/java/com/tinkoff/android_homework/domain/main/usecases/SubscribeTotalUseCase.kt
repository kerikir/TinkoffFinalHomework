package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Total
import kotlinx.coroutines.flow.Flow


/**
 * Описание Use Case для подписки на изменение суммы финансовых операций.
 *
 * Интерфейс Use Case в domain слое.
 */
interface SubscribeTotalUseCase {

    /**
     * Подписка на изменение общей суммы финансовых операций
     *
     * @return Поток с общей суммой финансовых операций
     */
    suspend operator fun invoke(): Flow<Total>
}