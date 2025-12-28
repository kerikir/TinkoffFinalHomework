package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.data.repo.detail.DetailRepositoryImpl
import com.tinkoff.android_homework.data.repo.operations.OperationsRepositoryImpl
import com.tinkoff.android_homework.data.repo.total.TotalRepositoryImpl
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import com.tinkoff.android_homework.domain.main.repos.OperationsRepository
import com.tinkoff.android_homework.domain.main.repos.TotalRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * Сетевой модуль для внедрения зависимостей.
 *
 * Подключен к компоненту времени жизни всего приложения.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class NetworkModule {

    /** Связывает интерфейс с реализацией для работы с общей суммой финансовых операций */
    @Binds
    abstract fun bindTotalRepository(
        impl: TotalRepositoryImpl,
    ): TotalRepository

    /** Связывает интерфейс с реализацией для работы с списком финансовых операций */
    @Binds
    abstract fun bindOperationsRepository(
        impl: OperationsRepositoryImpl,
    ): OperationsRepository

    /** Связывает интерфейс с реализацией для работы с детальным описанием финансовой операции */
    @Binds
    abstract fun bindDetailRepository(
        impl: DetailRepositoryImpl,
    ): DetailRepository
}