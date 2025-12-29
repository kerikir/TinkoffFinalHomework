package com.tinkoff.android_homework.di


import com.tinkoff.android_homework.data.storage.dao.DetailDbModelDao
import com.tinkoff.android_homework.data.storage.dao.OperationDbModelDao
import com.tinkoff.android_homework.data.storage.dao.TotalDbModelDao
import com.tinkoff.android_homework.data.storage.datasource.DetailLocalDataSource
import com.tinkoff.android_homework.data.storage.datasource.DetailLocalDataSourceImpl
import com.tinkoff.android_homework.data.storage.datasource.OperationsLocalDataSource
import com.tinkoff.android_homework.data.storage.datasource.OperationsLocalDataSourceImpl
import com.tinkoff.android_homework.data.storage.datasource.TotalLocalDataSource
import com.tinkoff.android_homework.data.storage.datasource.TotalLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Модуль для внедрения зависимостей локального источника данных.
 *
 * Подключен к компоненту времени жизни всего приложения.
 */
@Module
@InstallIn(SingletonComponent::class)
object LocalDataSourceModule {

    @Singleton
    @Provides
    fun provideDetailLocalDataSource(detailDao: DetailDbModelDao) : DetailLocalDataSource {
        return DetailLocalDataSourceImpl(detailDao)
    }


    @Singleton
    @Provides
    fun provideOperationsLocalDataSource(operationDao: OperationDbModelDao) : OperationsLocalDataSource {
        return OperationsLocalDataSourceImpl(operationDao)
    }


    @Singleton
    @Provides
    fun provideTotalLocalDataSource(totalDao: TotalDbModelDao) : TotalLocalDataSource {
        return TotalLocalDataSourceImpl(totalDao)
    }
}