package com.tinkoff.android_homework.domain.main.entities

import com.tinkoff.android_homework.presentation.model.operations.OperationType

/**
 * Финансовая операция.
 *
 * Модель данных для domain слоя.
 */
data class Operation(
    /** Тип финансовой операции */
    val type: OperationType,
    /** Название финансовой операции */
    val name: String,
    /** Сумма финансовой операции */
    val amount: Int,
)
