package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Detail


/**
 * Описание Use Case для получения информации о финансовой операции.
 *
 * Интерфейс Use Case в domain слое.
 */
interface GetDetailUseCase {

    // TODO сделать invoke как перегрузку оператора
    suspend fun invoke(id: Int): Detail
}