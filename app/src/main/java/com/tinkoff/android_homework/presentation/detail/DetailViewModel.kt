package com.tinkoff.android_homework.presentation.detail

import androidx.lifecycle.ViewModel
import com.tinkoff.android_homework.domain.main.usecases.SubscribeDetailUseCase
import com.tinkoff.android_homework.presentation.model.detail.DetailItem
import com.tinkoff.android_homework.presentation.model.operations.PresentationOperationType
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow



class DetailViewModel @AssistedInject constructor(
    private val subscribeDetailUseCase: SubscribeDetailUseCase,
    @Assisted private val operationId: Int,
    @Assisted private val operationType: PresentationOperationType
) : ViewModel() {

    /** Фабрика ViewModel */
    @dagger.assisted.AssistedFactory
    interface Factory {
        fun create(
            operationId: Int,
            operationType: PresentationOperationType
        ) : DetailViewModel
    }





    private val _details: MutableStateFlow<DetailItem?> = MutableStateFlow(null)
    val details: StateFlow<DetailItem?> = _details.asStateFlow()
}