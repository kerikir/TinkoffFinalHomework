package com.tinkoff.android_homework.presentation.model.operations


/**
 * Финансовая операция.
 *
 * Модель данных для presentation слоя.
 *
 * Модель данных для отображения в Recycler View.
 */
data class OperationItem(
    /** Тип финансовой операции */
    val presentationOperationType: PresentationOperationType,
    /** Название финансовой операции */
    val operationTitle: String,
    /** Сумма финансовой операции */
    val operationSum: Int
)