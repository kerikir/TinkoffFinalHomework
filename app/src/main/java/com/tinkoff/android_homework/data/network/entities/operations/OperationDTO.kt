package com.tinkoff.android_homework.data.network.entities.operations

import com.tinkoff.android_homework.data.network.models.OperationType
import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class OperationDTO(
    val id: Int,
    val type: OperationType,
    val name: String,
    val amount: Int,
)
