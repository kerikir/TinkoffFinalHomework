package com.tinkoff.android_homework.presentation.mappers.details

import com.tinkoff.android_homework.domain.main.entities.Detail
import com.tinkoff.android_homework.presentation.mappers.models.PresentationOperationTypeMapper
import com.tinkoff.android_homework.presentation.model.detail.DetailItem
import javax.inject.Inject


/**
 * Преобразователь описания финансовой операции из типа domain-слоя в тип presentation-слоя.
 */
class DetailItemMapper @Inject constructor(
    private val presentationOperationTypeMapper: PresentationOperationTypeMapper
) : (Detail) -> DetailItem {

    /**
     *  Преобразователь описания финансовой операции из типа domain-слоя в тип presentation-слоя.
     *
     *  @param detail Описание финансовой операции domain-слоя.
     *  @return Описание финансовой операции presentation-слоя.
     */
    override operator fun invoke(detail: Detail): DetailItem {
        return DetailItem(
            type = presentationOperationTypeMapper(detail.type),
            comment = detail.comment,
            positions = detail.positions
        )
    }
}