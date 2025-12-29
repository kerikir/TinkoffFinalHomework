package com.tinkoff.android_homework.data.network.entities.operations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Список финансовых операций.
 *
 * Автоматическое преобразование из JSON в Kotlin и наоборот.
 *
 * Модель данных для data слоя (network).
 *
 * Поля JSON: operation.
 */
@Serializable
data class OperationsDTO(
    /** Список финансовых операций */
    @SerialName("operation")
    val operations: List<OperationDTO>,
)