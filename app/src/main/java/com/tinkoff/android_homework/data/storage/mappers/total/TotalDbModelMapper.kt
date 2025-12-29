package com.tinkoff.android_homework.data.storage.mappers.total

import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import com.tinkoff.android_homework.domain.main.entities.Total
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


/**
 * Преобразователь из общей суммы финансовых операций data-слоя (storage) в общую сумму
 * финансовых операций domain-слоя.
 */
class TotalDbModelMapper @Inject constructor() : (Flow<TotalDbModel>) -> Flow<Total> {

    /**
     *  Преобразователь из общей суммы финансовых операций data-слоя (storage) в общую сумму
     *  финансовых операций domain-слоя.
     *
     *  @param totalDbModel Общая сумма финансовых операций data-слоя (storage).
     *  @return Общая сумма финансовых операций domain-слоя.
     */
    fun map(totalDbModel: TotalDbModel): Total {
        return Total(amount = totalDbModel.total)
    }


    /**
     *  Преобразователь из потока общей суммы финансовых операций data-слоя (storage)
     *  в поток общей суммы финансовых операций domain-слоя.
     *
     *  @param totalDbModelFlow Поток общей суммы финансовых операций data-слоя (storage).
     *  @return Поток общей суммы финансовых операций domain-слоя.
     */
    override operator fun invoke(totalDbModelFlow: Flow<TotalDbModel>): Flow<Total> {
        return totalDbModelFlow.map { map(it) }
    }
}