package com.tinkoff.android_homework.presentation.model.total


/**
 * Общая сумма финансовых операций.
 *
 * Модель данных для presentation слоя.
 */
data class TotalItem(
    /** Сумма всех операций */
    val total: Int,
    /** Сумма входящих переводов */
    val income: Int,
    /** Сумма расходов */
    val outcome: Int,
    /** Отношение поступлений на счет и расходов */
    val progress: Float
)