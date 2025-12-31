package com.tinkoff.android_homework.presentation.mappers.details

import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.presentation.mappers.models.PresentationOperationTypeMapper
import com.tinkoff.android_homework.presentation.model.detail.DetailItem
import javax.inject.Inject

class DetailItemMapper @Inject constructor(
    private val presentationOperationTypeMapper: PresentationOperationTypeMapper
) : (Detail) -> DetailItem {

    override operator fun invoke(detail: Detail): DetailItem {
        return DetailItem(
            type = presentationOperationTypeMapper(detail.type),
            comment = detail.comment,
            positions = detail.positions
        )
    }
}