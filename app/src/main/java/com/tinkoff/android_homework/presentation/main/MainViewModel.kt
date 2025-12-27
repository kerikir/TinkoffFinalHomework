package com.tinkoff.android_homework.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinkoff.android_homework.domain.main.usecases.GetOperationsUseCase
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import com.tinkoff.android_homework.presentation.mappers.operations.OperationItemMapper
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import com.tinkoff.android_homework.presentation.model.operations.PresentationOperationType
import com.tinkoff.android_homework.presentation.model.total.TotalItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Обработка отображаемых данных в UI - Main Activity
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val subscribeTotalUseCase: SubscribeTotalUseCase,
    private val getOperationsUseCase: GetOperationsUseCase,
    val uiMapper: OperationItemMapper,
) : ViewModel() {

    /** Источник данных списка финансовых операций */
    private val _operations: MutableStateFlow<List<OperationItem>> = MutableStateFlow(emptyList())
    /** Доступ к данным списка финансовых операций */
    val operations: StateFlow<List<OperationItem>> = _operations.asStateFlow()

    /** Источник данных общей суммы финансовых операций */
    private val _total: MutableStateFlow<TotalItem?> = MutableStateFlow(null)
    /** Доступ к данным общей суммы финансовых операций */
    val total: StateFlow<TotalItem?> = _total.asStateFlow()

    

    // Инициализация объекта View Model
    init {
        // Запуск корутины в области видимости View Model - загрузка данных асинхронно
        viewModelScope.launch {

            // Загрузка списка финансовых операций
            _operations.value =
                getOperationsUseCase
                    .invoke()
                    .operations
                    .map { uiMapper.invoke(it) }

            _total.value = subscribeTotalUseCase
                .invoke()
                .map { total ->
                    val incomes = _operations
                        .value
                        .filter { it.presentationOperationType == PresentationOperationType.INCOME }
                        .sumOf { it.operationSum }

                    val outcomes = _operations
                        .value
                        .filter { it.presentationOperationType == PresentationOperationType.OUTCOME }
                        .sumOf { it.operationSum }

                    val progress = (outcomes.toFloat() / incomes.toFloat()) * 100f

                    TotalItem(
                        total = total.amount,
                        income = incomes,
                        outcome = outcomes,
                        progress = progress
                    )
                }.first()
        }
    }
}