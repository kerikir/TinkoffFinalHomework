package com.tinkoff.android_homework.presentation.model

import com.tinkoff.android_homework.presentation.model.operations.OperationType


/**
 * Детальное описание финансовой операции.
 *
 * Модель данных для presentation слоя.
 */
data class DetailItem (
    /** Тип финансовой операции */
    val type: OperationType,
    /** Комментарий к финансовой операции для отображения */
    val comment: String,
    /** Список позиций (что входит в сумму операции) */
    val positions: List<String>,
)
