package com.tinkoff.android_homework.data.storage.models


/**
 * Тип финансовой операции.
 *
 * Модель из data слоя (storage).
 */
enum class OperationType {
    /** Оплата товаров и услуг */
    OUTCOME,
    /** Входящий перевод */
    INCOME,
}