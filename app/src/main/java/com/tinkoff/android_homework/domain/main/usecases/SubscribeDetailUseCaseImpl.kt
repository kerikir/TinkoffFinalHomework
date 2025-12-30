package com.tinkoff.android_homework.domain.main.usecases

import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.domain.main.models.OperationType
import com.tinkoff.android_homework.domain.main.repos.DetailRepository
import kotlinx.coroutines.flow.Flow
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
     * Подписка на изменение дополнительной информации о финансовой операции
     *
     * @param id Идентификатор финансовой информации
     * @return Поток с информацией о финансовой операции
     */
    override operator fun invoke(id: Int, type: OperationType): Flow<Detail> {
        return detailRepository.subscribeDetail(id, type)
    }
}