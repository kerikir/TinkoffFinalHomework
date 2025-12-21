package com.tinkoff.android_homework.data.network.entities.total

import kotlinx.serialization.Serializable


/**
 * Общая сумма финансовых операций.
 *
 * Автоматическое преобразование из JSON в Kotlin и наоборот.
 *
 * Модель данных для data слоя (network).
 *
 * Поля JSON: id, total.
 */
@Serializable
data class TotalDTO(
    /** Уникальный идентификатор суммы финансовых операций */
    val id: Int,
    /** Сумма всех операций */
    val total: Int
)