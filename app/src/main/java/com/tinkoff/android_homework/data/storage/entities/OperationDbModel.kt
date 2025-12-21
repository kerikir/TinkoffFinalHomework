package com.tinkoff.android_homework.data.storage.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel.Companion.OPERATION_TABLE_NAME
import com.tinkoff.android_homework.data.storage.models.OperationType


/**
 * @author d.shtaynmets
 */
@Entity(tableName = OPERATION_TABLE_NAME)
data class OperationDbModel(
    @PrimaryKey()
    val id: Long,
    val type: OperationType,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "amount")
    val amount: Int,
) {

    companion object {
        const val OPERATION_TABLE_NAME = "operation_table"
    }
}
