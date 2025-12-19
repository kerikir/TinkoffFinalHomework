package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Total
import com.tinkoff.android_homework.domain.main.repos.TotalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SubscribeTotalUseCaseImpl @Inject constructor(
    private val repository: TotalRepository,
) : SubscribeTotalUseCase {

    override suspend fun invoke(): Flow<Total> {
        return repository.subscribeTotal()
    }
}