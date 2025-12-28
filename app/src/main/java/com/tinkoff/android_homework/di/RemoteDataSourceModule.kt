package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.network.datasource.DetailRemoteDataSource
import com.tinkoff.android_homework.data.network.datasource.DetailRemoteDataSourceImpl
import com.tinkoff.android_homework.data.network.datasource.OperationsRemoteDataSource
import com.tinkoff.android_homework.data.network.datasource.OperationsRemoteDataSourceImpl
import com.tinkoff.android_homework.data.network.datasource.TotalRemoteDataSource
import com.tinkoff.android_homework.data.network.datasource.TotalRemoteDataSourceImpl
import com.tinkoff.android_homework.data.network.services.DetailDtoService
import com.tinkoff.android_homework.data.network.services.OperationsDtoService
import com.tinkoff.android_homework.data.network.services.TotalDtoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Модуль для внедрения зависимостей сетевого источника данных.
 *
 * Подключен к компоненту времени жизни всего приложения.
 */
@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    /**
     * Предоставляем зависимость для сетевого источника данных
     * для детального описания финансовой операции
     */
    @Singleton
    @Provides
    fun provideDetailRemoteDataSource(detailDtoService: DetailDtoService) : DetailRemoteDataSource {
        return DetailRemoteDataSourceImpl(detailDtoService)
    }


    /**
     * Предоставляем зависимость для сетевого источника данных
     * для общей суммы финансовых операций
     */
    @Singleton
    @Provides
    fun provideTotalRemoteDataSource(totalDtoService: TotalDtoService) : TotalRemoteDataSource {
        return TotalRemoteDataSourceImpl(totalDtoService)
    }


    /**
     * Предоставляем зависимость для сетевого источника данных
     * для списка финансовых операций
     */
    @Singleton
    @Provides
    fun provideOperationsRemoteDataSource(operationsDtoService: OperationsDtoService) : OperationsRemoteDataSource {
        return OperationsRemoteDataSourceImpl(operationsDtoService)
    }
}