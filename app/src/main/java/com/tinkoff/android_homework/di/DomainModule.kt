package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.repo.detail.DetailRepositoryImpl
import com.tinkoff.android_homework.data.network.repo.operations.OperationsRepository
import com.tinkoff.android_homework.data.network.repo.total.TotalRepository
import com.tinkoff.android_homework.domain.main.usecases.GetDetailUseCase
import com.tinkoff.android_homework.domain.main.usecases.GetDetailUseCaseImpl
import com.tinkoff.android_homework.domain.main.usecases.GetOperationsUseCase
import com.tinkoff.android_homework.domain.main.usecases.GetOperationsUseCaseImpl
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Модуль для внедрения зависимостей domain-слоя.
 *
 * Подключен к компоненту времени жизни всего приложения.
 */
@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    /** Предоставляем зависимость Use Case для подписки на изменение суммы финансовых операций */
    @Singleton
    @Provides
    fun provideSubscribeTotalUseCase(
        repository: TotalRepository,
    ): SubscribeTotalUseCase {
        return SubscribeTotalUseCaseImpl(repository)
    }


    /** Предоставляем зависимость Use Case для подписки на изменение списка финансовых операций */
    @Singleton
    @Provides
    fun provideSubscribeOperationUseCase(
        repository: OperationsRepository,
    ): GetOperationsUseCase {
        return GetOperationsUseCaseImpl(repository)
    }


    /** Предоставляем зависимость Use Case для подписки на изменение описания финансовой операции */
    @Singleton
    @Provides
    fun provideSubscribeDetailUseCase(
        repository: DetailRepositoryImpl,
    ):  GetDetailUseCase {
        return GetDetailUseCaseImpl(repository)
    }
}