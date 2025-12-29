package com.tinkoff.android_homework.di

import android.content.Context
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.tinkoff.android_homework.data.network.services.DetailDtoService
import com.tinkoff.android_homework.data.network.services.OperationsDtoService
import com.tinkoff.android_homework.data.network.services.TotalDtoService
import com.tinkoff.android_homework.data.repo.utils.InternetChecker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * Модуль для внедрения зависимостей для работы с сетью.
 *
 * Подключен к компоненту времени жизни всего приложения.
 */
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    /** Предоставляем зависимость объекта для инициализации Retrofit */
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        // Перехватчик запросов
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        // Http клиент для совершения запросов
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        // Retrofit для создания API-сервисов
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .client(client)
            .addConverterFactory(Json.asConverterFactory(contentType).apply {})
            .baseUrl(BASE_URL)
            .build()
    }


    /**
     * Предоставляем зависимость объекта API-сервиса
     * для работы с общей суммой финансовых операций
     */
    @Provides
    @Singleton
    fun provideTotalService(retrofit: Retrofit): TotalDtoService {
        return retrofit.create(TotalDtoService::class.java)
    }


    /**
     * Предоставляем зависимость объекта API-сервиса
     * для работы с списком финансовых операций
     */
    @Provides
    @Singleton
    fun provideOperationsService(retrofit: Retrofit): OperationsDtoService {
        return retrofit.create(OperationsDtoService::class.java)
    }


    /**
     * Предоставляем зависимость объекта API-сервиса
     * для работы с детальным описанием финансовых операций
     */
    @Provides
    @Singleton
    fun provideDetailService(retrofit: Retrofit): DetailDtoService {
        return retrofit.create(DetailDtoService::class.java)
    }


    /**
     * Предоставляем зависимость объекта для проверки доступности интернета
     */
    @Provides
    @Singleton
    fun provideInternetChecker(
        // Контекст приложения для доступа к системным сервисам Android
        @ApplicationContext context: Context
    ): InternetChecker = InternetChecker(context)


    /** Адрес сервера */
    val BASE_URL = "https://raw.githubusercontent.com/InternetEducation/"
}