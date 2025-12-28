package com.tinkoff.android_homework.domain.main.repos

import com.tinkoff.android_homework.domain.main.entities.Operations
import kotlinx.coroutines.flow.Flow


/**
 * Описание возможных действий с списком финансовых операций.
 *
 * Интерфейс репозитория в domain слое.
 */
interface OperationsRepository {

    /** Подписка на измененеи списка всех финансовых операций */
    suspend fun subscribeOperations(): Flow<Operations>
}