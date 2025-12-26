package com.tinkoff.android_homework.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tinkoff.android_homework.R
import com.tinkoff.android_homework.presentation.model.operations.OperationItem
import com.tinkoff.android_homework.presentation.model.operations.PresentationOperationType


/**
 * Преобразование объекта данных в элемент интерфейса.
 * Управляет данными и связывает их с View Holder.
 */
class OperationAdapter : RecyclerView.Adapter<OperationAdapter.OperationViewHolder>() {

    /** Список элементов для отображения. */
    var data: List<OperationItem> = emptyList()
        set(newValue) {
            field = newValue
            // Сообщает об изменениях (полная перерисовка)
            notifyDataSetChanged()
        }


    /**
     * Создание нового объекта View Holder.
     *
     * @param parent Родительский ViewGroup - RecyclerView.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        // Создание View из XML
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.operation_item, parent, false)
        // Создание экземпляра View Holder
        return OperationViewHolder(itemView)
    }


    /** Получение общего количества элементов. */
    override fun getItemCount(): Int = data.size


    /** Связывание данных с View Holder. */
    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        data[position].let { operationItem ->
            // Определение иконки финансовой операции
            val operationIcon = when (operationItem.presentationOperationType) {
                PresentationOperationType.OUTCOME -> R.drawable.spending_icon
                PresentationOperationType.INCOME -> R.drawable.income_icon
            }
            // Установка иконки финансовой операции
            holder.operationIcon.setImageResource(operationIcon)

            // Установка текстового описания финансовой операции
            holder.operationTitle.text = operationItem.operationTitle
            // Установка суммы финансовой операции
            holder.operationSum.text = operationItem.operationSum.toString()
        }
    }



    /** Хранение ссылок на представления каждого элемента списка */
    class OperationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // TODO заменить findViewById на View Binding

        /** Ссылка на иконку финансовой операции */
        val operationIcon: ImageView = itemView.findViewById(R.id.operation_icon)
        /** Ссылка на текстовое описание финансовой операции */
        val operationTitle: TextView = itemView.findViewById(R.id.operation_title)
        /** Ссылка на сумму финансовой операции */
        val operationSum: TextView = itemView.findViewById(R.id.operation_sum)
    }
}