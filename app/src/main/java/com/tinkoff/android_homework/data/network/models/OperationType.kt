package com.tinkoff.android_homework.data.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Тип финансовой операции.
 *
 * Модель из data слоя (network).
 */
@Serializable
enum class OperationType {
    /** Оплата товаров и услуг */
    @SerialName("OUTCOME")
    OUTCOME,
    /** Входящий перевод */
    @SerialName("INCOME")
    INCOME
}