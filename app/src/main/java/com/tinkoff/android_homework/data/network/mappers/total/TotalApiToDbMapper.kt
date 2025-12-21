package com.tinkoff.android_homework.data.network.mappers.total

import com.tinkoff.android_homework.data.network.entities.total.TotalApi
import com.tinkoff.android_homework.data.storage.entities.TotalDbModel
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class TotalApiToDbMapper @Inject constructor(): (TotalApi) -> TotalDbModel {
    override fun invoke(totalApi: TotalApi): TotalDbModel {
        return TotalDbModel(
            id = totalApi.id.toLong(),
            total = totalApi.total,
        )
    }
}
