package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Operations
import kotlinx.coroutines.flow.Flow


/**
 * Описание Use Case для получения списка финансовых операций.
 *
 * Интерфейс Use Case в domain слое.
 */
interface SubscribeOperationsUseCase {

    /**
     * Подписка на изменение списка всех финансовых операций
     *
     * @return Поток со списком всех финансовых операций
     */
    suspend operator fun invoke(): Flow<Operations>
}
