package com.tinkoff.android_homework.di

import com.tinkoff.android_homework.presentation.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


/**
 * Модуль модели представлений для внедрения зависимостей.
 *
 * Подключен к компоненту модели представления.
 */
@Module
@InstallIn(ViewModelComponent::class)
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindDetailViewModelFactory(
        factory: DetailViewModel.Factory
    ) : DetailViewModel.Factory
}