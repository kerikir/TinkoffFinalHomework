package com.tinkoff.android_homework.presentation.model.operations


/**
 * Тип финансовой операции.
 *
 * Модель из presentation слоя.
 */
enum class OperationType {
    /** Оплата товаров и услуг */
    OUTCOME,
    /** Входящий перевод */
    INCOME
}