package com.tinkoff.android_homework.domain.main.entities

import com.tinkoff.android_homework.domain.main.models.OperationType


/**
 * Финансовая операция.
 *
 * Модель данных для domain слоя.
 */
data class Operation(
    /** Уникальный идентификатор финансовой операции */
    val id: Int,
    /** Тип финансовой операции */
    val type: OperationType,
    /** Название финансовой операции */
    val name: String,
    /** Сумма финансовой операции */
    val amount: Int,
)
