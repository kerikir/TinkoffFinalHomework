package com.tinkoff.android_homework.di

import android.content.Context
import androidx.room.Room.databaseBuilder
import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.database.AppDatabase
import com.tinkoff.android_homework.data.storage.database.AppDatabase.Companion.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton


/**
 * Модуль для внедрения зависимостей для работы с БД.
 *
 * Подключен к компоненту времени жизни всего приложения.
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase =
        databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()


    /** Предоставляем зависимость объекта DAO для работы с финансовыми операциями в базе данных */
    @Provides
    @Singleton
    fun provideOperationsDao(db: AppDatabase): OperationDbModelDao = db.operationDao()

    /**
     * Предоставляем зависимость объекта DAO для работы
     * с общей суммой финансовых операций в базе данных
     */
    @Provides
    @Singleton
    fun provideTotalDao(db: AppDatabase): TotalDbModelDao = db.totalDao()

    /**
     * Предоставляем зависимость объекта DAO для работы
     * с детальным описанием финансовых операций в базе данных
     */
    @Provides
    @Singleton
    fun provideDetailDao(db: AppDatabase): DetailDbModelDao = db.detailDao()
}