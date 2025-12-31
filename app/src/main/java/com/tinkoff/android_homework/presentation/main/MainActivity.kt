package com.tinkoff.android_homework.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tinkoff.android_homework.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    /**
     * Создание Activity.
     *
     * Для инициализации интерфейса, некоторых ресурсов и восстановления состояния.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}