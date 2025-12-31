package com.tinkoff.android_homework.presentation.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tinkoff.android_homework.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch



@AndroidEntryPoint
class DetailFragment : Fragment() {

    // Модель представлений - ленивая инициализация
    private val viewModel by viewModels<DetailViewModel>()

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



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        iconOperation = view.findViewById(R.id.icon_operation)
        titleTransfer = view.findViewById(R.id.title_transfer)
        transferSum = view.findViewById(R.id.transfer_sum)
        comment = view.findViewById(R.id.inscription_comment)
        positions = view.findViewById(R.id.inscription_positions)
    }

}