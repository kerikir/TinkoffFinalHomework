package com.tinkoff.android_homework.data.storage.mappers.detail

import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import com.tinkoff.android_homework.domain.main.entities.Detail
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class DetailDbToDomainMapper @Inject constructor() : (DetailDbModel) -> Detail {

    override fun invoke(detailDbModel: DetailDbModel): Detail {
        return Detail(
            type = detailDbModel.type,
            comment = detailDbModel.comment,
            positions = detailDbModel.positions
        )
    }
}
