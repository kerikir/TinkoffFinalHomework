package com.tinkoff.android_homework.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel.Companion.DETAILS_TABLE_NAME
import com.tinkoff.android_homework.data.storage.models.OperationType


/**
 * @author d.shtaynmets
 */
@Entity(tableName = DETAILS_TABLE_NAME)
data class DetailDbModel(
    @PrimaryKey
    val id: Long,
    val type: OperationType,
    val comment: String,
    val positions: List<String>,
) {
    companion object {
        const val DETAILS_TABLE_NAME = "details_table"
    }
}
