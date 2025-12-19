package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Operations

// TODO сменить назавние Use Case на метод репозитория

/**
 * Описание Use Case для получения списка финансовых операций.
 *
 * Интерфейс Use Case в domain слое.
 */
interface SubscribeOperationsUseCase {

    suspend fun invoke(): Operations
}
