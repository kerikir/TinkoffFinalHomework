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
import javax.inject.Singleton

/**
 * @author d.shtaynmets
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provide(@ApplicationContext context: Context) =
        databaseBuilder(
            context,
            AppDatabase::class.java, DATABASE_NAME
        )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideOperationsDao(db: AppDatabase): OperationDbModelDao = db.operationDao()

    @Provides
    @Singleton
    fun provideTotalDao(db: AppDatabase): TotalDbModelDao = db.totalDao()

    @Provides
    @Singleton
    fun provideDetailDao(db: AppDatabase): DetailDbModelDao = db.detailDao()
}
