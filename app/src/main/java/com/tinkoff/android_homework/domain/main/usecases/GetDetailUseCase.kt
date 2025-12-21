package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Detail

// TODO сменить назавние Use Case на метод репозитория

/**
 * Описание Use Case для получения информации о финансовой операции.
 *
 * Интерфейс Use Case в domain слое.
 */
interface GetDetailUseCase {

    suspend fun getDetail(id: Int): Detail
}