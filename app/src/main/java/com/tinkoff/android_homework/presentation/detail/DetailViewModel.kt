package com.tinkoff.android_homework.presentation.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinkoff.android_homework.domain.main.usecases.SubscribeDetailUseCase
import com.tinkoff.android_homework.presentation.mappers.details.DetailItemMapper
import com.tinkoff.android_homework.presentation.mappers.models.PresentationOperationTypeMapper
import com.tinkoff.android_homework.presentation.model.detail.DetailItem
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn


class DetailViewModel @AssistedInject constructor(
    private val subscribeDetailUseCase: SubscribeDetailUseCase,
    private val presentationOperationTypeMapper: PresentationOperationTypeMapper,
    private val detailItemMapper: DetailItemMapper,
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {




    /** Доступ к данным описание финансовой операции */
    val detail: StateFlow<DetailItem?> = subscribeDetailUseCase(
        operationId,
        presentationOperationTypeMapper.map(operationType))
        .map { detailItemMapper(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )
}