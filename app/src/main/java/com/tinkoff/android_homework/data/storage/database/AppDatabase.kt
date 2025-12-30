package com.tinkoff.android_homework.data.storage.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.database.utils.ListStringConverter
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import com.tinkoff.android_homework.data.storage.entities.OperationDbModel
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel


/**
 * Конфигурация базы данных.
 *
 * Сущности: OperationDbModel, TotalDbModel, DetailDbModel.
 * Преобразователь типов - ListStringConverter.
 */
@Database(
    entities = [OperationDbModel::class, TotalDbModel::class, DetailDbModel::class],
    version = 4,
    exportSchema = false,
)
@TypeConverters(ListStringConverter::class)
abstract class AppDatabase : RoomDatabase() {

    /** Получение DAO для работы с финансовыми операциями в базе данных */
    abstract fun operationDao(): OperationDbModelDao

    /** Получение DAO для работы с общей суммой финансовых операций в базе данных */
    abstract fun totalDao(): TotalDbModelDao

    /** Получение DAO для работы с детальным описанием финансовых операций в базе данных */
    abstract fun detailDao(): DetailDbModelDao


    /** Определение констант */
    companion object {
        /** Имя базы данных */
        const val DATABASE_NAME = "operations.db"
    }
}