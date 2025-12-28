package com.tinkoff.android_homework

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Точка входа для Dagger Hilt.
 * Инициализация Jetpack Hilt в приложении.
 */
@HiltAndroidApp
class TBankAndroidApplication : Application()