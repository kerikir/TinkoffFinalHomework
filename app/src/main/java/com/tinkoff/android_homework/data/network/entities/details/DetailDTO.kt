package com.tinkoff.android_homework.data.network.entities.details

import com.tinkoff.android_homework.data.network.models.OperationType
import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class DetailDTO(
    val type: OperationType,
    val amount: Int,
    val comment: String,
    val positions: List<String>
)
