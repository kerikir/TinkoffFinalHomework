package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import javax.inject.Inject


/**
 * Use Case для получения дополнительной информации о финансовой операции.
 *
 * Use Case в domain слое.
 * Реализация бизнес-логики.
 *
 * @param detailRepository Откуда будут приходить данные
 */
class SubscribeDetailUseCaseImpl @Inject constructor(
    private val detailRepository: DetailRepository
) : SubscribeDetailUseCase {

    /**
     * Получении дополнительной информации о финансовой операции
     *
     * @param id Идентификатор финансовой информации
     * @return Информация о финансовой операции
     */
    override suspend fun getDetail(id: Int): Detail {
        return detailRepository.getDetail(id)
    }
}