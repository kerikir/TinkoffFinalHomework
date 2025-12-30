package com.tinkoff.android_homework.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinkoff.android_homework.domain.main.entities.Total
import com.tinkoff.android_homework.domain.main.usecases.SubscribeOperationsUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import com.tinkoff.android_homework.presentation.mappers.operations.OperationItemMapper
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import com.tinkoff.android_homework.presentation.model.operations.PresentationOperationType
import com.tinkoff.android_homework.presentation.model.total.TotalItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Обработка отображаемых данных в UI - Main Activity
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val subscribeTotalUseCase: SubscribeTotalUseCase,
    private val subscribeOperationsUseCase: SubscribeOperationsUseCase,
    val operationItemMapper: OperationItemMapper,
) : ViewModel() {

    /** Доступ к данным списка финансовых операций */
    val operations: StateFlow<List<OperationItem>> = subscribeOperationsUseCase()
        .map { it.operations.map { value ->  operationItemMapper(value) } }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )


    /** Доступ к данным общей суммы финансовых операций */
    val total: StateFlow<TotalItem?> = combine(
        operations,
        subscribeTotalUseCase()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = null
            )
    ) { operationsList, totalDomain ->
        calculateTotalItem(operationsList, totalDomain)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = null
    )



    private fun calculateTotalItem(
        operations: List<OperationItem>,
        totalDomain: Total?
    ) : TotalItem? {

        if (operations.isEmpty()) return null
        totalDomain ?: return null

        // Определение общей суммы начислений
        val incomes = operations
            .filter { it.presentationOperationType == PresentationOperationType.INCOME }
            .sumOf { it.operationSum }

        // Определение общей суммы расходов
        val outcomes = operations
            .filter { it.presentationOperationType == PresentationOperationType.OUTCOME }
            .sumOf { it.operationSum }

        // Определение отношения расходов и доходов
        val progress = (outcomes.toFloat() / incomes.toFloat()) * 100f

        // Инициализация статистики финансовых операций
        return TotalItem(
            total = totalDomain.amount,
            income = incomes,
            outcome = outcomes,
            progress = progress
        )
    }
}