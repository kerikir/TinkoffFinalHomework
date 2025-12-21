package com.tinkoff.android_homework.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel.Companion.TOTAL_TABLE_NAME


/**
 * @author d.shtaynmets
 */
@Entity(tableName = TOTAL_TABLE_NAME)
data class TotalDbModel(
    @PrimaryKey
    val id: Long,
    val total: Int,
) {

    companion object {
        const val TOTAL_TABLE_NAME = "total_table"
    }
}
