package com.tinkoff.android_homework.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.dao.TotalDao
import com.tinkoff.android_homework.data.storage.database.utils.ListStringConverter
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel

/**
 * @author d.shtaynmets
 */
@Database(
    entities = [OperationDbModel::class, TotalDbModel::class, DetailDbModel::class],
    version = 3,
    exportSchema = false,
)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun operationDao(): OperationDbModelDao

    abstract fun totalDao(): TotalDao

    abstract fun detailDao(): DetailDbModelDao

    companion object {
        const val DATABASE_NAME = "operations.db"
    }
}
