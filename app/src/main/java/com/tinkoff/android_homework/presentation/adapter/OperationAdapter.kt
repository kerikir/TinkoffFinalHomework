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

    var data: List<OperationItem> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }


    /** Создание нового объекта View Holder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OperationViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.operation_recycler_item, parent, false)
        return OperationViewHolder(itemView)
    }


    /** Получение общего количества элементов. */
    override fun getItemCount(): Int = data.size


    /** Связывание данных с View Holder. */
    override fun onBindViewHolder(holder: OperationViewHolder, position: Int) {
        data[position].let { operationItem ->
            val operationIcon = when (operationItem.presentationOperationType) {
                PresentationOperationType.OUTCOME -> R.drawable.spending_icon
                PresentationOperationType.INCOME -> R.drawable.income_icon
            }
            holder.operationIcon.setImageResource(operationIcon)

            holder.operationTitle.text = operationItem.operationTitle
            holder.operationSum.text = operationItem.operationSum.toString()
        }
    }



    /** Хранение ссылок на представления каждого элемента списка */
    class OperationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val operationIcon: ImageView = itemView.findViewById(R.id.operation_icon)
        val operationTitle: TextView = itemView.findViewById(R.id.operation_title)
        val operationSum: TextView = itemView.findViewById(R.id.operation_sum)
    }
}