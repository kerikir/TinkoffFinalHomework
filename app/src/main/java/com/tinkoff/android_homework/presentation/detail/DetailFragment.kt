package com.tinkoff.android_homework.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.tinkoff.android_homework.R
import com.tinkoff.android_homework.presentation.model.operations.PresentationOperationType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject


@AndroidEntryPoint
class DetailFragment : Fragment() {

    /** Ссылка на представление с изображение - иконка финансовой операции */
    private lateinit var iconOperation: ImageView
    /** Ссылка на текстовое представление - тип финансовой операции */
    private lateinit var titleTransfer: TextView
    /** Ссылка на текстовое представление - сумма финансовой операции */
    private lateinit var transferSum: TextView
    /** Ссылка на текстовое представление - комментарий к финансовой операции */
    private lateinit var comment: TextView
    /** Ссылка на текстовое представление - список позиций в финансовой операции */
    private lateinit var positions: TextView

    /** Аргументы при навигации с помощью компонента Navigation */
    private val args: DetailFragmentArgs by navArgs()

    /** Фабрика View Model */
    @Inject
    lateinit var viewModelFactory: DetailViewModel.Factory
    private val viewModel: DetailViewModel by viewModels {
        createViewModelFactory(
            factory = viewModelFactory,
            operationId = args.id,
            operationType = args.operationType
        )
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iconOperation = view.findViewById(R.id.icon_operation)
        titleTransfer = view.findViewById(R.id.title_transfer)
        transferSum = view.findViewById(R.id.transfer_sum)
        comment = view.findViewById(R.id.inscription_comment)
        positions = view.findViewById(R.id.inscription_positions)

        subscribeToDetail()
    }



    /**
     * Создание фабрики.
     * Функция-обертка.
     */
    private fun createViewModelFactory(
        factory: DetailViewModel.Factory,
        operationId: Int,
        operationType: PresentationOperationType
    ) : ViewModelProvider.Factory {

        return object : ViewModelProvider.Factory {

            // Игнорирование предупреждение компилятора
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return factory.create(operationId, operationType) as T
            }
        }
    }



    /**
     * Подписка на изменение описания финансовой операции.
     * Описание финансовой операции отображается в фрагменте.
     */
    private fun subscribeToDetail() {
        // Запуск корутины на время жизни Activity
        lifecycleScope.launch {
            // Работа корутины в зависимости от жизненного цикла UI
            repeatOnLifecycle(Lifecycle.State.STARTED) {

                // Подписка на изменение статистики общей суммы финансовых операций
                viewModel.detail.collect { detail ->
                    // Установка иконки и названия финансовой операции
                    if (detail?.type == PresentationOperationType.INCOME) {
                        iconOperation.setImageResource(R.drawable.income_icon)
                        titleTransfer.text = getString(R.string.title_transfer_income)
                    } else {
                        iconOperation.setImageResource(R.drawable.spending_icon)
                        titleTransfer.text = getString(R.string.title_transfer_spending)
                    }

                    // Установка суммы финансовой операции
                    transferSum.text
                    // Установка описания финансовой операции
                    comment.text = detail?.comment
                    // Установка
                    positions.text = detail?.positions?.joinToString(", ")
                }
            }
        }
    }
}