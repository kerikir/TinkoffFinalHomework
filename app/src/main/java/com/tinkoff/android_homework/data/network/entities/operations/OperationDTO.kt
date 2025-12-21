package com.tinkoff.android_homework.data.network.entities.operations

import com.tinkoff.android_homework.data.network.models.NetworkOperationType
import kotlinx.serialization.Serializable


/**
 * Финансовая операция.
 *
 * Автоматическое преобразование из JSON в Kotlin и наоборот.
 *
 * Модель данных для data слоя (network).
 *
 * Поля JSON: id, type, name, amount.
 */
@Serializable
data class OperationDTO(
    /** Уникальный идентификатор финансовой операции */
    val id: Int,
    /** Тип финансовой операции */
    val type: NetworkOperationType,
    /** Название финансовой операции */
    val name: String,
    /** Сумма финансовой операции */
    val amount: Int,
)