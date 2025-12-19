package com.tinkoff.android_homework.domain.main.entities


/**
 * Список финансовых операций.
 *
 * Модель данных для domain слоя.
 */
data class Operations(
    /** Список финансовых операций */
    val operations: List<Operation>,
)
