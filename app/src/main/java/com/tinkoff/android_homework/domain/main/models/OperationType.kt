package com.tinkoff.android_homework.domain.main.models


/**
 * Тип финансовой операции.
 *
 * Модель из domain слоя.
 */
enum class OperationType {
    /** Оплата товаров и услуг */
    OUTCOME,
    /** Входящий перевод */
    INCOME,
}