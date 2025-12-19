package com.tinkoff.android_homework.domain.main.repos

import com.tinkoff.android_homework.domain.main.entities.Detail


/**
 * Описание возможных действий с дополнительной информацией о финансовой операции.
 *
 * Интерфейс репозитория в domain слое.
 */
interface DetailRepository {

    /** Получение информации о финансовой операции */
    suspend fun getDetail(id: Int): Detail
}