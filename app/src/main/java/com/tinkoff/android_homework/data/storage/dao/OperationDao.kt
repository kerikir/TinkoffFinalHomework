package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel

/**
 * @author d.shtaynmets
 */
@Dao
interface OperationDao {

    @Query("SELECT * FROM ${OperationDbModel.OPERATION_TABLE_NAME}")
    suspend fun getAll(): List<OperationDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: OperationDbModel)
}
