package com.tinkoff.android_homework.data.network.entities.details

import com.tinkoff.android_homework.data.network.models.OperationType
import kotlinx.serialization.Serializable

/**
 * Детальное описание финансовой операции.
 *
 * Модель данных для data слоя (network).
 *
 * Поля JSON: type, amount, comment, positions.
 */
@Serializable
data class DetailDTO(
    /** Тип финансовой операции */
    val type: OperationType,
    /** Сумма финансовой операции */
    val amount: Int,
    /** Комментарий к финансовой операции для отображения */
    val comment: String,
    /** Список позиций (что входит в сумму операции) */
    val positions: List<String>
)
