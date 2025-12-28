package com.tinkoff.android_homework.domain.main.repos

import com.tinkoff.android_homework.domain.main.entities.Total
import kotlinx.coroutines.flow.Flow


/**
 * Описание возможных действий с суммой всех финансовых операций.
 *
 * Интерфейс репозитория в domain слое.
 */
interface TotalRepository {

    /** Подписка на изменение суммы всех финансовых операций */
    suspend fun subscribeTotal(): Flow<Total>
}