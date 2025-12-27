package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Operations


/**
 * Описание Use Case для получения списка финансовых операций.
 *
 * Интерфейс Use Case в domain слое.
 */
interface GetOperationsUseCase {
    
    suspend operator fun invoke(): Operations
}
