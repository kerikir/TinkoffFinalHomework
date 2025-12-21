package com.tinkoff.android_homework.data.storage.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel

/**
 * @author d.shtaynmets
 */
@Dao
interface DetailDao {

    @Query("SELECT * FROM ${DetailDbModel.DETAILS_TABLE_NAME}")
    suspend fun getAll(): DetailDbModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg operations: DetailDbModel)
}
