package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Operations


/**
 * @author d.shtaynmets
 */
interface SubscribeOperationsUseCase {

    suspend fun invoke(): Operations
}
