package com.tinkoff.android_homework.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tinkoff.android_homework.data.storage.dao.DetailDao
import com.tinkoff.android_homework.data.storage.dao.OperationDao
import com.tinkoff.android_homework.data.storage.dao.TotalDao
import com.tinkoff.android_homework.data.storage.database.utils.ListStringConverter
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.data.storage.entities.TotalDb

/**
 * @author d.shtaynmets
 */
@Database(
    entities = [OperationDbModel::class, TotalDb::class, DetailDbModel::class],
    version = 3,
    exportSchema = false,
)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun operationDao(): OperationDao

    abstract fun totalDao(): TotalDao

    abstract fun detailDao(): DetailDao

    companion object {
        const val DATABASE_NAME = "operations.db"
    }
}
