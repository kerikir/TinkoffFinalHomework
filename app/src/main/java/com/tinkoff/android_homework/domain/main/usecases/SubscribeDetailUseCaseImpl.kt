package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import javax.inject.Inject


class SubscribeDetailUseCaseImpl @Inject constructor(
    private val detailRepository: DetailRepository
) : SubscribeDetailUseCase {

    override suspend fun getDetail(id: Int): Detail {
        return detailRepository.getDetail(id)
    }
}