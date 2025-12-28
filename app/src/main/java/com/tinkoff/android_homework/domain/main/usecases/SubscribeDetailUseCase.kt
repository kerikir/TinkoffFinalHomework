package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Detail
import kotlinx.coroutines.flow.Flow


/**
 * Описание Use Case для получения информации о финансовой операции.
 *
 * Интерфейс Use Case в domain слое.
 */
interface SubscribeDetailUseCase {

    suspend operator fun invoke(id: Int): Flow<Detail>
}