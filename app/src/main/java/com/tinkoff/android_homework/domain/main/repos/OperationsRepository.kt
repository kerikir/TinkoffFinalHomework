package com.tinkoff.android_homework.domain.main.repos

import com.tinkoff.android_homework.domain.main.entities.Operations


/**
 * Описание возможных действий.
 *
 * Интерфейс репозитория в domain слое.
 */
interface OperationsRepository {

    /** Получение всех финансовых операций */
    suspend fun getOperations(): Operations
}