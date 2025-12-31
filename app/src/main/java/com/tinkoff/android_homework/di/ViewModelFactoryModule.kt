package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.presentation.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * Модуль модели представлений для внедрения зависимостей.
 *
 * Подключен к компоненту модели представления.
 */
@Module
@InstallIn(SingletonComponent::class)
interface ViewModelFactoryModule {

    @Binds
    abstract fun bindDetailViewModelFactory(
        factory: DetailViewModel.FactoryImpl
    ) : DetailViewModel.Factory
}