package com.tinkoff.android_homework.presentation.main

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.LinearProgressIndicator
import com.tinkoff.android_homework.R
import com.tinkoff.android_homework.presentation.adapter.OperationAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlin.getValue



@AndroidEntryPoint
class OperationsFragment : Fragment(R.layout.fragment_operations) {

    // Модель представлений - ленивая инициализация
    private val viewModel by viewModels<MainViewModel>()

    /** Ссылка на текстовое представление - общая сумма на счету */
    private lateinit var totalSum: TextView
    /** Ссылка на текстовое представление - сумма расходов */
    private lateinit var outcome: TextView
    /** Ссылка на текстовое представление - общая сумма начислений */
    private lateinit var income: TextView
    /** Ссылка на индикатор прогресса - отношение доходов к расходам */
    private lateinit var progressBar: LinearProgressIndicator


    /** Ссылка на представление с переработкой - список финансовых операций */
    private lateinit var operationsRecyclerView: RecyclerView
    /** Адаптер для Recycler View */
    private val operationAdapter = OperationAdapter()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Получение ссылки на Recycler View
        operationsRecyclerView = view.findViewById(R.id.operations_recycler)

        // Получение ссылки на TextView
        totalSum = view.findViewById(R.id.sum)
        // Получение ссылки на TextView
        outcome = view.findViewById(R.id.outcome)
        // Получение ссылки на TextView
        income = view.findViewById(R.id.income)
        // Получение ссылки на LinearProgressIndicator
        progressBar = view.findViewById(R.id.progress_bar)

        // Установка Adapter и LayoutManager для RecyclerView
        initOperationsRecycler()

        // Запуск потока для отслеживания изменения в списке финансовых операций
        subscribeToOperations()
        // Запуск потока для отслеживания изменения в статистике общей суммы финансовых операций
        subscribeToTotal()
    }



    /**
     * Подписка на изменение общей суммы финансовой операции.
     * Статистика общей суммы финансовых операций отображается в отдельном файле макете.
     */
    private fun subscribeToTotal() {
        // Запуск корутины на время жизни Activity
        lifecycleScope.launch {
            // Работа корутины в зависимости от жизненного цикла UI
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // Подписка на изменение статистики общей суммы финансовых операций
                viewModel.total.collect { totalItem ->
                    // Установка суммы начислений
                    income.text = totalItem?.income.toString()
                    // Установка суммы расходов
                    outcome.text = totalItem?.outcome.toString()
                    // Установка общей суммы финансовых операций
                    totalSum.text = totalItem?.total.toString()
                    // Обновление прогресса - отношения расходов и доходов
                    progressBar.progress = totalItem?.progress?.toInt() ?: 0
                }
            }
        }
    }



    /**
     * Подписка на изменение данных списка операций.
     * Список операций отображается в RecyclerView.
     */
    private fun subscribeToOperations() {
        // Запуск корутины на время жизни Activity
        lifecycleScope.launch {
            // Работа корутины в зависимости от жизненного цикла UI
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // Подписка на изменение списка операций
                viewModel.operations.collect {
                    // Обновление данных списка операций - Recycler View
                    operationAdapter.data = it
                }
            }
        }
    }



    /**
     *  Инициализация Recycler View для работы
     */
    private fun initOperationsRecycler() {
        // Установка вида расположения элементов RecyclerView - вертикальный список
        operationsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        // Установка адаптера для RecyclerView
        operationsRecyclerView.adapter = operationAdapter
    }
}