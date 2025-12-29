package com.tinkoff.android_homework.domain.main.repos

import com.tinkoff.android_homework.domain.main.entities.Detail
import kotlinx.coroutines.flow.Flow


/**
 * Описание возможных действий с дополнительной информацией о финансовой операции.
 *
 * Интерфейс репозитория в domain слое.
 */
interface DetailRepository {

    /**
     * Подписка на изменение дополнительной информации о финансовой операции
     *
     * @param id Идентификатор финансовой операции
     * @return Поток с информацией о финансовой операции
     */
    fun subscribeDetail(id: Int): Flow<Detail>
}