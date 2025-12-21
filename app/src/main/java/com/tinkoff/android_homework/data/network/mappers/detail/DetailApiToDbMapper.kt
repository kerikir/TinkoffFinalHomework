package com.tinkoff.android_homework.data.network.mappers.detail

import com.tinkoff.android_homework.data.network.entities.details.DetailApi
import com.tinkoff.android_homework.data.storage.entities.DetailDbModel
import java.util.UUID
import javax.inject.Inject

/**
 * @author d.shtaynmets
 */
class DetailApiToDbMapper @Inject constructor() : (DetailApi) -> DetailDbModel {

    override fun invoke(detail: DetailApi): DetailDbModel {
        return DetailDbModel(
            id = UUID.randomUUID().timestamp(),
            type = detail.type,
            comment = detail.comment,
            positions = detail.positions
        )
    }

}
