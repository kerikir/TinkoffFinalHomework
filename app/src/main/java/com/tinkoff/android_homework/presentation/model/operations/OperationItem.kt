package com.tinkoff.android_homework.presentation.model.operations


/**
 * Финансовая операция.
 *
 * Модель данных для presentation слоя.
 */
data class OperationItem(
    /** Тип финансовой операции */
    val operationType: OperationType,
    /** Название финансовой операции */
    val operationTitle: String,
    /** Сумма финансовой операции */
    val operationSum: Int
)