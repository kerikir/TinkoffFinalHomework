package com.tinkoff.android_homework.domain.main.entities

// TODO убрать тип операции из слоя presentation
import com.tinkoff.android_homework.presentation.model.operations.OperationType

/**
 * Детальное описание финансовой операции.
 * Модель данных для domain слоя.
 */
data class Detail(
    /** Тип финансовой операции */
    val type: OperationType,
    /** Комментарий к финансовой операции для отображения */
    val comment: String,
    /** Список позиций (что входит в сумму операции) */
    val positions: List<String>,
)