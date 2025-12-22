package com.tinkoff.android_homework.data.storage.mappers.total

import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import com.tinkoff.android_homework.domain.main.entities.Total
import javax.inject.Inject


/**
 * Преобразователь из общей суммы финансовых операций data-слоя (storage) в общую сумму
 * финансовых операций domain-слоя.
 */
class TotalDbModelMapper @Inject constructor() : (TotalDbModel) -> Total {

    /**
     *  Преобразователь из общей суммы финансовых операций data-слоя (storage) в общую сумму
     *  финансовых операций domain-слоя.
     *
     *  @param totalDbModel Общая сумма финансовых операций data-слоя.
     *  @return Общая сумма финансовых операций domain-слоя.
     */
    override fun invoke(totalDbModel: TotalDbModel): Total {
        return Total(amount = totalDbModel.total)
    }
}