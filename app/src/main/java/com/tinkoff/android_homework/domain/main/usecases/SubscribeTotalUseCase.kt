package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Total
import kotlinx.coroutines.flow.Flow


interface SubscribeTotalUseCase {
    suspend fun invoke(): Flow<Total>
}