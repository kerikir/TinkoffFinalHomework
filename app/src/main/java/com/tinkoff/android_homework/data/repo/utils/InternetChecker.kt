package com.tinkoff.android_homework.data.repo.utils

import android.content.Context
import android.net.ConnectivityManager
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject


/**
 * Класс для проверки доступности интернета.
 */
class InternetChecker @Inject constructor(
    // Контекст приложения для доступа к системным сервисам Android
    @ApplicationContext private val context: Context
) {

    /** Проверка на активное сетевое подключение к интернету. */
    fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Получение активной сети
        val networkInfo = connectivityManager.getActiveNetworkInfo()
        // Проверка есть ли вообще сеть и подключен ли к сети
        return networkInfo != null && networkInfo.isConnected()
    }
}