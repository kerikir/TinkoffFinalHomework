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


@Module
@InstallIn(SingletonComponent::class)
object RemoteDataSourceModule {

    @Singleton
    @Provides
    fun provideDetailRemoteDataSource(detailDtoService: DetailDtoService) : DetailRemoteDataSource {
        return DetailRemoteDataSourceImpl(detailDtoService)
    }


    @Singleton
    @Provides
    fun provideTotalRemoteDataSource(totalDtoService: TotalDtoService) : TotalRemoteDataSource {
        return TotalRemoteDataSourceImpl(totalDtoService)
    }


    @Singleton
    @Provides
    fun provideDetailRemoteDataSource(operationsDtoService: OperationsDtoService) : OperationsRemoteDataSource {
        return OperationsRemoteDataSourceImpl(operationsDtoService)
    }
}