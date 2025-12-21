package com.tinkoff.android_homework.data.storage.mappers.total

import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import com.tinkoff.android_homework.domain.main.entities.Total
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class TotalDbToDomainMapper @Inject constructor() : (TotalDbModel) -> Total {

    override fun invoke(totalDbModel: TotalDbModel): Total {
        return Total(amount = totalDbModel.total)
    }

}
