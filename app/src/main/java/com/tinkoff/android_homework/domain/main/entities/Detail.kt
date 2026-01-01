package com.tinkoff.android_homework.domain.main.entities

import com.tinkoff.android_homework.domain.main.models.OperationType


/**
 * Детальное описание финансовой операции.
 *
 * Модель данных для domain слоя.
 */
data class Detail(
    /** Тип финансовой операции */
    val type: OperationType,
    /** Сумма финансовой операции */
    val amount: Int,
    /** Комментарий к финансовой операции для отображения */
    val comment: String,
    /** Список позиций (что входит в сумму операции) */
    val positions: List<String>,
)