package com.tinkoff.android_homework.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Тип финансовой операции.
 * Автоматическая сериализация и десериализация класса.
 *
 * Модель из data слоя (network).
 */
@Serializable
enum class OperationType {
    /**
     * Оплата товаров и услуг.
     *
     * Имя в JSON - OUTCOME.
     */
    @SerialName("OUTCOME")
    OUTCOME,
    /**
     * Входящий перевод.
     *
     * Имя в JSON - INCOME.
     */
    @SerialName("INCOME")
    INCOME
}