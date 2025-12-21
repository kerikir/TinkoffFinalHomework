package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import kotlinx.coroutines.flow.Flow

/**
 * @author d.shtaynmets
 */
@Dao
interface TotalDao {

    @Query("SELECT * FROM ${TotalDbModel.TOTAL_TABLE_NAME}")
    fun getAll(): Flow<TotalDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(totalDbModel: TotalDbModel)
}
