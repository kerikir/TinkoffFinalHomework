package com.tinkoff.android_homework.data.repo.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import javax.inject.Inject


/**
 * Класс для проверки доступности интернета.
 */
class InternetChecker (private val context: Context) {

    /** Проверка на активное сетевое подключение к интернету. */
    fun isInternetAvailable(): Boolean {
        // Получение доступа к информации о сетевых подключениях
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        // Проверка есть ли активная сеть
        val networkInfo = connectivityManager.activeNetwork ?: return false
        // Проверка на возможности сети
        val capabilities = connectivityManager.getNetworkCapabilities(networkInfo) ?: return false
        // Проверка наличия интерента
        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}