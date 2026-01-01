package com.tinkoff.android_homework.presentation.model.operations

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


/**
 * Тип финансовой операции.
 *
 * Модель из presentation слоя.
 */
@Parcelize
enum class PresentationOperationType : Parcelable {
    /** Оплата товаров и услуг */
    OUTCOME,
    /** Входящий перевод */
    INCOME
}